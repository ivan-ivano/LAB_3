package Booking;

import Accomodation.Accommodation;
import Booking.Exceptions.BookingExceptions;
import Client.Client;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Amenity.Amenity;


public class BookingManager {
    private final List<Booking> bookings;

    public BookingManager() {
        this.bookings = new ArrayList<Booking>();
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void calculateIncomeAndExpenses() {
        double totalIncome = bookings.stream()
                .mapToDouble(Booking::getTotalPrice)
                .sum();

        double totalExpenses = bookings.stream()
                .mapToDouble(booking -> {
                    double accommodationExpense = booking.getAccommodation().getDailyExpense() * booking.getDays();
                    double amenitiesExpense = booking.getAccommodation().getAmenities().stream()
                            .mapToDouble(Amenity::getDailyExpense)
                            .sum() * booking.getDays();
                    return accommodationExpense + amenitiesExpense;
                })
                .sum();

        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Total Profit: " + (totalIncome - totalExpenses));
    }

    public Booking createBooking(Client client, Accommodation accommodation, LocalDate start, LocalDate end, int numberOfPersons) {
        if (start.isAfter(end)) {
            throw new BookingExceptions.InvalidBookingPeriodException("The start date cannot be after the end date.");
        }

        if (hasClientBookedAccommodation(client, accommodation)) {
            throw new BookingExceptions.ClientAlreadyBookedAccommodationException("Client has already booked this accommodation.");
        }

        if (isAvailable(accommodation, start, end)) {
            double pricePerDay = calculateDailyRate(accommodation);

            Booking booking = new Booking(client, accommodation, start, end, pricePerDay, numberOfPersons);
            bookings.add(booking);
            return booking;
        } else {
            throw new BookingExceptions.BookingUnavailableException("Accommodation is not available for the selected dates.");
        }
    }

    private double calculateDailyRate(Accommodation accommodation) {
        double basePrice = accommodation.getPrice();

        double amenitiesCost = accommodation.getAmenities().stream()
                .mapToDouble(Amenity::getPrice)
                .sum();

        return basePrice + amenitiesCost;
    }

    public boolean isAvailable(Accommodation accommodation, LocalDate start, LocalDate end) {
        return bookings.stream()
                .noneMatch(booking ->
                        booking.getAccommodation().equals(accommodation) &&
                        isDateOverlap(booking, start, end));
    }

    public void checkAvailability(Accommodation accommodation, LocalDate start, LocalDate end) {
        if (isAvailable(accommodation, start, end)) {
            System.out.println(accommodation.getName() + " is available for the selected dates.");
        } else {
            System.out.println(accommodation.getName() + "Accommodation is not available for the selected dates.");
        }
    }

    private boolean hasClientBookedAccommodation(Client client, Accommodation accommodation) {
        return bookings.stream()
                .anyMatch(booking -> booking.getClient().equals(client) && booking.getAccommodation().equals(accommodation));
    }

    private boolean isDateOverlap(Booking booking, LocalDate start, LocalDate end) {
        return (booking.getStartDate().isBefore(end) && booking.getEndDate().isAfter(start));
    }
}
