package Accomodation.CottageVillage;

import Accomodation.Accommodation;

public class Cottage extends Accommodation {
    public Cottage(String name, String type, double price, int maxAdult, int maxChildren, double dailyExpense) {
        super(name, type, price, maxAdult, maxChildren, dailyExpense);
    }

    @Override
    public String toString() {
        return "Cottage: " + '\n' +
                "name:" + getName() + '\n' +
                "type:" + getType() + '\n' +
                "amenities: " + getAmenities()+ '\n'+
                "price per day: " + getPrice() + '\n' +
                "max adult: " + getMaxAdult() + '\n' +
                "max children: " + getMaxChildren() + '\n';
    }
}
