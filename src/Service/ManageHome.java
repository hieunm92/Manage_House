package Service;

import Model.Home;
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
        for (Home house : homeList) {
            System.out.println(house);
        }
    }

    public void sortHomeByCost() {
        Collections.sort(homeList, (o1, o2) -> {
            if (o1.getCost() > o2.getCost()) return 100000;
            else if (o1.getCost() < o2.getCost()) return -10000;
            else return 0;
        });
        System.out.println(homeList);
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

    public void writeFile() {
        WriteAndReadFile.writeFile(homeList, FILE_NAME);
    }

    public void readFile() {
        homeList = (List<Home>) WriteAndReadFile.readFile(FILE_NAME);
        showAll();
    }


}
