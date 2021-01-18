package View;

import Model.Apartment;
import Model.Home;
import Model.HomeStay;
import Service.ManageHome;

import java.time.LocalDate;
import java.util.Scanner;

public class TestMain {
    static Scanner scanner = new Scanner(System.in);
    static ManageHome manageHome = new ManageHome();
    static final String REGEX = "^[0-9]{4}(-[0-9]{2}){2}";

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("=====Menu=====");
            System.out.println("1.Thêm nhà cho thuê mới");
            System.out.println("2.Tìm nhà trong danh sách cho thuê");
            System.out.println("3.Hiển thị nhà cho thuê theo thứ tự tăng dần");
            System.out.println("4.Hiển thị nhà có giá thuê cao nhất và thấp nhất");
            System.out.println("5.Ghi File");
            System.out.println("6.Đọc File");
            System.out.println("0. Thoát");
            System.out.println("-----------------------------------");
            System.out.println("Xin chọn phương thức thực hiện");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Số lượng nhà cần thêm mới");
                    int number = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < number; i++) {
                        addNewHome();
                    }
                    break;
                case 2:
                    System.out.println("Nhập nhà cần tìm kiếm");
                    String numberHome = scanner.nextLine();
                    manageHome.searchHome(numberHome);
                    break;
                case 3:
                    manageHome.sortHomeByCost();
                    break;
                case 4:
                    manageHome.showHomeHaveCostMinAndMax();
                    break;
                case 5:
                    manageHome.writeFile();
                    break;
                case 6:
                    manageHome.readFile();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        } while (true);
    }

    public static void addNewHome() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số nhà");
        String numberHome = sc.nextLine();
        System.out.println("Nhập thời gian lưu trú");
        int lengthOfStay = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập loại nhà muốn thuê");
        String kindOfHome = sc.nextLine();
        String day;
        do {
            System.out.println("Nhâp ngày nhận nhà kiểu yyyy-MM-dd");
            day = sc.nextLine();
        } while (!day.matches(REGEX));
        LocalDate dateOfRent = LocalDate.parse(day);
        System.out.println("Nhập giá tiền");
        int cost = Integer.parseInt(scanner.nextLine());
        boolean isApartment = false;
        boolean isHomeStay = false;
        do {
            System.out.println("Nhập chữ viết hoa loại nhà muốn thuê: Apartment or HomeStay");
            kindOfHome = sc.nextLine();
            isApartment = kindOfHome.equalsIgnoreCase("A");
            if (isApartment) {
                System.out.println("Nhập diện tích căn hộ ");
                int area = Integer.parseInt(scanner.nextLine());
                Home home = new Apartment(numberHome,lengthOfStay,kindOfHome,dateOfRent,cost,area);
                manageHome.addNewHome(home);
            }
            isHomeStay =kindOfHome.equalsIgnoreCase("HS");
            if (isHomeStay) {
                System.out.println("Nhập số lượng người lưu trú");
                int numberPeople = Integer.parseInt(sc.nextLine());
                Home home = new HomeStay(numberHome,lengthOfStay,kindOfHome,dateOfRent,cost,numberPeople);
                manageHome.addNewHome(home);
            }
        } while (isApartment == false && isHomeStay == false);

        System.err.println("----------------------------------------");
    }
}
