package Service;

import Model.Apartment;
import Model.Home;
import Model.HomeStay;
import Storage.WriteAndReadFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManageHome {
    private static final String FILE_NAME = "home.dat";
    List<Home> homeList = new ArrayList<>();

    public void addNewHome(Home home) {
        homeList.add(home);
    }

    public void showAll() {
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s"
                , "Số nhà"
                , "Thời gian lưu trú"
                , "Loại nhà thuê"
                , "Ngày thuê"
                , "Giá nhà"
                , "Diện tích"
                , "Lượng người"
                , "Tổng tiền");
        for (Home house : homeList) {
            if (house instanceof Apartment) {
                Apartment apartment = (Apartment) house;
                System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s"
                        , apartment.getNumberHome()
                        , apartment.getLengthOfStay()
                        , apartment.getKindOfHome()
                        , apartment.getDateOfRent()
                        , apartment.getCost()
                        , apartment.getArea()
                        , ""
                        , apartment.getTotalMoney() + "\n");
            } else if (house instanceof HomeStay) {
                HomeStay homeStay = (HomeStay) house;
                System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s"
                        , homeStay.getNumberHome()
                        , homeStay.getLengthOfStay()
                        , homeStay.getKindOfHome()
                        , homeStay.getDateOfRent()
                        , homeStay.getCost()
                        ,""
                        , homeStay.getNumberPeople()
                        , homeStay.getTotalMoney() + "\n");
            }
        }
    }

    public void sortHomeByCost() {
        Collections.sort(homeList, (o1, o2) -> {
            if (o1.getCost() > o2.getCost()) return -1;
            else if (o1.getCost() < o2.getCost()) return 1;
            else return 0;
        });
        showAll();
    }

    public void showHomeHaveCostMinAndMax() {
        sortHomeByCost();
        System.out.println("Nhà có giá thuê cao nhất" + homeList.get(0));
        System.out.println("Nhà có giá thuê thấp nhất" + homeList.get(homeList.size() - 1));
    }

    public void searchHome(String numberHome) {
        for (Home house : homeList) {
            if (numberHome.equalsIgnoreCase(house.getNumberHome())) {
                System.out.println(house);
                return;
            }
        }
        System.out.println("Không tìm thấy trong danh sách");
    }

    public void deleteHome() {

    }

    public void editHome() {

    }

    public void writeFile() {
        WriteAndReadFile.writeFile(homeList, FILE_NAME);
    }

    public void readFile() {
        homeList = (List<Home>) WriteAndReadFile.readFile(FILE_NAME);
        showAll();
    }


}
