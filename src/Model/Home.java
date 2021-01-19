package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Home implements Serializable {
    private String numberHome;
    private int lengthOfStay;
    private String kindOfHome;
    private LocalDate dateOfRent;
    private double cost;

    public Home() {
    }

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

    public int getLengthOfStay() {
        return lengthOfStay;
    }

    public void setNumberHome(String numberHome) {
        this.numberHome = numberHome;
    }

    public void setLengthOfStay(int lengthOfStay) {
        this.lengthOfStay = lengthOfStay;
    }

    public void setKindOfHome(String kindOfHome) {
        this.kindOfHome = kindOfHome;
    }

    public void setDateOfRent(LocalDate dateOfRent) {
        this.dateOfRent = dateOfRent;
    }

    public void setCost(double cost) {
        this.cost = cost;
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
