package Booking;

import Accomodation.Accommodation;
import Client.Client;

import java.time.LocalDate;
import java.util.stream.Stream;

public class Booking {
    private final Client client;
    private final Accommodation accommodation;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int days;
    private final int numberOfPersons;
    private final double pricePerDay;
    private final double totalPrice;

    public Booking(Client client, Accommodation accommodation, LocalDate startDate, LocalDate endDate, double pricePerDay, int numberOfPersons) {
        this.client = client;
        this.accommodation = accommodation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.days = (int) startDate.until(endDate).getDays();
        this.pricePerDay = pricePerDay;
        this.numberOfPersons = numberOfPersons;

        this.totalPrice = calculateTotalPrice();
    }

    private double calculateTotalPrice() {
        if (accommodation.getName().contains("Cottage")) {
            if ((startDate.getMonthValue() == 3 && endDate.getMonthValue() == 3) ||
                    (startDate.getMonthValue() == 11 && endDate.getMonthValue() == 11)) {
                return days * pricePerDay * 0.8;
            }


            return Stream.iterate(startDate, date -> date.plusDays(1))
                    .limit(days)
                    .mapToDouble(date -> date.getMonthValue() == 3 || date.getMonthValue() == 11 ? pricePerDay * 0.8 : pricePerDay)
                    .sum();
        }
        else {
            return days * pricePerDay;
        }
    }

    public Client getClient() {
        return client;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getDays() {
        return days;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }


    @Override
    public String toString() {
        return "Booking: " + "\n" +
                "client: " + client.getName() + "\n" +
                "accommodation: " + accommodation.getName() + "\n" +
                "startDate: " + startDate + "\n" +
                "endDate: " + endDate + "\n" +
                "days: " + days + "\n" +
                "totalPrice: " + totalPrice + "\n" +
                "numberOfPersons: " + numberOfPersons + "\n";

    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
