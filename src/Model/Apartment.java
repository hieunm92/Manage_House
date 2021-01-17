package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Apartment extends Home implements Amount, Serializable{
    private int area;

    public Apartment(String numberHome, int lengthOfStay, String kindOfHome, LocalDate dateOfRent, double cost, int area) {
        super(numberHome, lengthOfStay, kindOfHome, dateOfRent, cost);
        this.area = area;
    }

    public int getArea() {
        return area;
    }

    @Override
    public double getTotalMoney() {
        return getArea()* getCost();
    }

    @Override
    public String toString() {
        return "Apartment{" + super.toString()+
                "area=" + area +
                '}';
    }


}
