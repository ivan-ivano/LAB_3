package Amenity;

public class Amenity {
    private final String name;
    private final double price;
    private final int extraAdult;
    private final int extraChild;
    private final double dailyExpense;

    public Amenity(String name, int extraChild, int extraAdult, double price, double dailyExpense) {
        this.name = name;
        this.extraChild = extraChild;
        this.extraAdult = extraAdult;
        this.price = price;
        this.dailyExpense = dailyExpense; // Ініціалізація поля
    }

    public String getName() {
        return name;
    }

    public int getExtraChild() {
        return extraChild;
    }

    public int getExtraAdult() {
        return extraAdult;
    }

    public double getPrice() {
        return price;
    }

    public double getDailyExpense() {
        return dailyExpense;
    }
}
