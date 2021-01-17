package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class HomeStay extends Home implements Amount,Serializable {
    private int numberPeople;


    public HomeStay(String numberHome, int lengthOfStay, String kindOfHome, LocalDate dateOfRent, double cost, int numberPeople) {
        super(numberHome, lengthOfStay, kindOfHome, dateOfRent, cost);
        this.numberPeople = numberPeople;
    }

    public int getNumberPeople() {
        return numberPeople;
    }

    @Override
    public double getTotalMoney() {
        return getNumberPeople()*getCost();
    }

    @Override
    public String toString() {
        return "HomeStay{" + super.toString()+
                "numberPeople=" + numberPeople +
                '}';
    }
}
