package Accomodation.CottageVillage;

import Amenity.Amenity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CottageVillage {
    private final String name;
    private final List<Cottage> cottages;
    private final List<Amenity> amenities;

    public CottageVillage(String name, List<Cottage> cottages, List<Amenity> amenities) {
        this.name = name;
        this.cottages = cottages;
        this.amenities = amenities;
    }

    public void findCottagesByAmenityOrCategory(String amenityName, String category) {
        List<Cottage> a = cottages.stream()
                .filter(cottage ->
                        (cottage.getType().equalsIgnoreCase(category)) && (hasAmenity(cottage, amenityName))
                )
                .toList();

        System.out.println("cottages with category: " + category + " and amenity: " + amenityName);
        a.stream()
                .map(Cottage::getName)
                .forEach(System.out::println);
    }

    private boolean hasAmenity(Cottage cottage, String amenityName) {
        return cottage.getAmenities().stream()
                .anyMatch(amenity -> amenity.getName().equalsIgnoreCase(amenityName)) ||
                amenities.stream().anyMatch(amenity -> amenity.getName().equalsIgnoreCase(amenityName));
    }

    public void printCottageAmenities(Cottage cottage) {
        Set<Amenity> uniqueAmenities = new HashSet<>(cottage.getAmenities());
        uniqueAmenities.addAll(amenities);

        System.out.println("Cottage amenities with village " + name + ": " + cottage.getName() + ":");
        uniqueAmenities.stream()
                .map(Amenity::getName)
                .forEach(System.out::println);
        System.out.println("\n");
    }

    public void addCottage(Cottage cottage) {
        cottages.add(cottage);
    }

    public void addAmenity(Amenity amenity) {
        amenities.add(amenity);
    }

    public String getName() {
        return name;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public List<Cottage> getCottages() {
        return cottages;
    }
}
