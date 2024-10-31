import Accomodation.CottageVillage.Cottage;
import Accomodation.CottageVillage.CottageVillage;
import Accomodation.Hotel.Hotel;
import Accomodation.Hotel.Room;
import Amenity.Amenity;
import Booking.Booking;
import Booking.BookingManager;
import Booking.Exceptions.BookingExceptions.*; // Додано імпорт для винятків
import Client.Client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Create list of amenities
        List<Amenity> amenities = new ArrayList<>();
        amenities.add(new Amenity("WiFi", 0, 0, 10, 5));
        amenities.add(new Amenity("Kitchen", 0, 0, 15, 10));

        Amenity Sofa = new Amenity("Big sofa", 0, 2, 5, 2);
        Amenity BabyBed = new Amenity("Baby bed", 1, 0, 5, 2);
        Amenity TV = new Amenity("TV", 0, 0, 20, 10);

        // Create cottages
        List<Cottage> cottages = new ArrayList<>();
        cottages.add(new Cottage("Cottage 1", "Standard", 100.0, 2, 2, 50.0));
        cottages.add(new Cottage("Cottage 2", "Luxury", 200.0, 4, 2, 100.0));

        // Create cottage village
        CottageVillage cottageVillage = new CottageVillage("Magic Village", cottages, new ArrayList<>());
        cottageVillage.addAmenity(amenities.get(0));
        cottageVillage.addAmenity(amenities.get(1));

        // Add amenities to the cottages
        cottageVillage.getCottages().get(1).addAmenity(TV);

        // Create hotel
        Hotel hotel = new Hotel("Classic Hotel", new ArrayList<>(), amenities);

        // Add rooms to the hotel
        hotel.addRoom(new Room("Single Room", "Standard", 50.0, 1, 0, 30.0));
        hotel.addRoom(new Room("Double Room", "Luxury", 80.0, 2, 1, 40.0));

        // Add amenities to the rooms
        hotel.getRooms().get(0).addAmenity(Sofa);
        hotel.getRooms().get(0).addAmenity(BabyBed);
        hotel.getRooms().get(1).addAmenity(TV);

        hotel.printRoomAmenities(hotel.getRooms().get(1));

        // Create a booking manager
        BookingManager bookingManager = new BookingManager();

        // Create clients
        Client client = new Client("Oleg", "oleg228@gmail.com", "+380123456789");
        Client client2 = new Client("Test", "test@gmail.com", "+380987654321");

        // Booking dates
        LocalDate startDate = LocalDate.of(2024, 8, 1);
        LocalDate endDate = LocalDate.of(2024, 8, 5);

        // Create booking
        Booking booking = bookingManager.createBooking(client, hotel.getRooms().get(1), startDate, endDate, 1);

        // Check availability
        bookingManager.checkAvailability(hotel.getRooms().get(1), startDate, endDate);

        // Find rooms by amenity or category
        hotel.findRoomsByAmenityOrCategory("TV", "Luxury");

        // Output all bookings
        System.out.println("All bookings: " + bookingManager.getBookings());

        try {
            bookingManager.createBooking(client, hotel.getRooms().get(1), startDate, endDate, 1);
        } catch (ClientAlreadyBookedAccommodationException | BookingUnavailableException |
                 InvalidBookingPeriodException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            bookingManager.createBooking(client2, hotel.getRooms().get(1), endDate, startDate, 1);
        } catch (InvalidBookingPeriodException e) {
            System.out.println("Error: " + e.getMessage());
        }

        bookingManager.calculateIncomeAndExpenses();
    }
}
