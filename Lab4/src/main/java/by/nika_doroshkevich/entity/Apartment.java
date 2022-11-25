package by.nika_doroshkevich.entity;

import java.io.Serializable;

public class Apartment implements Identifiable, Serializable {

    private int id;
    private String status;
    private String type;
    private int rooms;
    private int apartments;
    private int beds;
    private double price;
    private String photo;

    public Apartment() {
    }

    public Apartment(int id, String status, String type, int rooms, int apartments, int beds, double price, String photo) {
        this.id = id;
        this.status = status;
        this.type = type;
        this.rooms = rooms;
        this.apartments = apartments;
        this.beds = beds;
        this.price = price;
        this.photo=photo;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getApartments() {
        return apartments;
    }

    public void setApartments(int apartments) {
        this.apartments = apartments;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Apartment apartment = (Apartment) o;
        return id == apartment.id &&
                status.equals(apartment.status) &&
                type.equals(apartment.type) &&
                beds == apartment.beds &&
                rooms == apartment.rooms &&
                apartments ==apartment.apartments &&
                price == apartment.price &&
                photo.equals(apartment.photo);

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result +  id;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + rooms;
        result = prime * result + beds;
        result = prime * result + apartments;
        result = prime * result + (int) price;
        result = prime * result + ((photo == null) ? 0 : photo.hashCode());
        return result;
    }

    @Override
    public String toString() {
        String result = "Product{" + "id=" + id +
                ", type=" + type +
                ", status=" + status +
                ", numberOfRooms='" + rooms + '\'' +
                ", numberOfBeds='" + beds + '\'' +
                ", apartmentNumber='" + apartments + '\'' +
                ", price=" + price +
                ", photo=" + photo +
                '}';
        return result;
    }
}
