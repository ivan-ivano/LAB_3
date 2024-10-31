package Accomodation.Hotel;

import Accomodation.Accommodation;


public class Room extends Accommodation {
    public Room(String name, String type, double price, int maxAdult, int maxChildren, double dailyExpense) {
        super(name, type, price, maxAdult, maxChildren, dailyExpense);
    }

    @Override
    public String toString() {
        return "Room: " + "\n" +
                "name: " + getName() + "\n" +
                "type: " + getType() + "\n" +
                "price: " + getPrice() + "\n" +
                "maxAdult: " + getMaxAdult() + "\n" +
                "maxChildren: " + getMaxChildren() + "\n" +
                "amenities: " + getAmenities() + "\n";
    }
}
