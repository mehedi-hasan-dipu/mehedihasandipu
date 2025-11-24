// model/Hostel.java
package model;

import java.util.List;

public class Hostel {
    private String name, location, description, roomType, genderType, contactNumber, email, address, mapLink;
    private int price;
    private List<String> facilities;

    public Hostel(String name, String location, String description, String roomType,
                  String genderType, int price, List<String> facilities,
                  String contactNumber, String email, String address, String mapLink) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.roomType = roomType;
        this.genderType = genderType;
        this.price = price;
        this.facilities = facilities;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.mapLink = mapLink;
    }

    // Getters
    public String getName() { return name; }
    public String getLocation() { return location; }
    public String getDescription() { return description; }
    public String getRoomType() { return roomType; }
    public String getGenderType() { return genderType; }
    public int getPrice() { return price; }
    public List<String> getFacilities() { return facilities; }
    public String getContactNumber() { return contactNumber; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getMapLink() { return mapLink; }
}