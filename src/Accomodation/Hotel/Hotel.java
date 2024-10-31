package Accomodation.Hotel;

import Amenity.Amenity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Hotel {
    private final String name;
    private final List<Room> rooms;
    private final List<Amenity> amenities;

    public Hotel(String name, List<Room> rooms, List<Amenity> amenities) {
        this.name = name;
        this.rooms = new ArrayList<Room>();
        this.amenities = amenities;
    }


    public void findRoomsByAmenityOrCategory(String amenityName, String category) {
        List<Room> a = rooms.stream()
                .filter(room ->
                        (room.getType().equalsIgnoreCase(category)) && (hasAmenity(room, amenityName))
                )
                .toList();

        System.out.println("Rooms with category: " + category + " and amenity: " + amenityName);
        a.stream()
                .map(Room::getName)
                .forEach(System.out::println);
    }

    private boolean hasAmenity(Room room, String amenityName) {
        return room.getAmenities().stream()
                .anyMatch(amenity -> amenity.getName().equalsIgnoreCase(amenityName)) ||
                amenities.stream().anyMatch(amenity -> amenity.getName().equalsIgnoreCase(amenityName));
    }

    public void printRoomAmenities(Room room) {
        Set<Amenity> uniqueAmenities = new HashSet<>(room.getAmenities());
        uniqueAmenities.addAll(amenities);

        System.out.println("Room amenities with hotel: " + room.getName() + ":");
        uniqueAmenities.stream()
                .map(Amenity::getName)
                .forEach(System.out::println);
        System.out.println("\n");
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addAmenity(Amenity amenity) {
        amenities.add(amenity);
    }

    public String getName() {
        return name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }
}
