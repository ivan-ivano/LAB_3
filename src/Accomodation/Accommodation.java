package Accomodation;

import Amenity.Amenity;

import java.util.ArrayList;
import java.util.List;

public abstract class Accommodation {
    private final String name;
    private final String type;
    private final List<Amenity> amenities;
    private final double price;
    private int maxAdult;
    private int maxChildren;
    private final double dailyExpense;

    public Accommodation(String name, String type, double price, int maxAdult, int maxChildren, List<Amenity> amenities, double dailyExpense) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.maxAdult = maxAdult;
        this.maxChildren = maxChildren;
        this.amenities = amenities;
        this.dailyExpense = dailyExpense;
    }

    public Accommodation(String name, String type, double price, int maxAdult, int maxChildren, double dailyExpense) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.maxAdult = maxAdult;
        this.maxChildren = maxChildren;
        this.amenities = new ArrayList<>();
        this.dailyExpense = dailyExpense;
    }


    public void addAmenity(Amenity amenity) {
        amenities.add(amenity);
        if (amenity.getExtraAdult() > maxAdult) {
            maxAdult = amenity.getExtraAdult();
        }
        else if (amenity.getExtraChild() > maxChildren) {
            maxChildren = amenity.getExtraChild();
        }
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", amenities=" + amenities +
                ", price=" + price +
                ", maxAdult=" + maxAdult +
                ", maxChildren=" + maxChildren +
                '}';
    }

    public double getDailyExpense() {
        return dailyExpense;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public int getMaxChildren() {
        return maxChildren;
    }

    public int getMaxAdult() {
        return maxAdult;
    }
}
