package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Home {
    private String numberHome;
    private int lengthOfStay;
    private String kindOfHome;
    private LocalDate dateOfRent;
    private double cost;

    public Home(String numberHome, int lengthOfStay, String kindOfHome, LocalDate dateOfRent, double cost) {
        this.numberHome = numberHome;
        this.lengthOfStay = lengthOfStay;
        this.kindOfHome = kindOfHome;
        this.dateOfRent = dateOfRent;
        this.cost = cost;
    }

    public String getNumberHome() {
        return numberHome;
    }

    public String getKindOfHome() {
        return kindOfHome;
    }

    public LocalDate getDateOfRent() {
        return dateOfRent;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Home{" +
                "numberHome='" + numberHome + '\'' +
                ", lengthOfStay=" + lengthOfStay +
                ", kindOfHome='" + kindOfHome + '\'' +
                ", dateOfRent=" + dateOfRent +
                ", cost=" + cost +
                '}';
    }
}
