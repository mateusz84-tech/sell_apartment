package matkoc.pl.sel.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="apartments")
@NoArgsConstructor
@AllArgsConstructor @ToString @EqualsAndHashCode
public class Apartment implements Comparable<Apartment>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer apartment_id;
    @NotNull
    @Access(AccessType.PROPERTY)
    @Column(name = "PROJECT_NUMBER", unique = true)
    private String projectNumber;
    @NotNull
    @Access(AccessType.PROPERTY)
    @Column(name = "APARTMENT_NUMBER", unique = true)
    private String apartmentNumber;
    @NotNull
    @Access(AccessType.PROPERTY)
    @Column(name = "AREA", scale = 5, precision = 2)
    private Double area;
    @NotNull
    @Access(AccessType.PROPERTY)
    @Column(name = "NUMBER_OF_ROOMS")
    @Size(min = 1, max = 7, message = "Dopuszczalna wartość pomiędzy 1 - 7")
    private Short numberOfRooms;
    @NotNull
    @Access(AccessType.PROPERTY)
    @Column(name = "SECTION")
    private String section;
    @NotNull
    @Access(AccessType.PROPERTY)
    @Column(name = "FLOOR_LEVEL")
    @Size(min = 0, max = 10, message = "Dopuszczalna wartość 0 - 10")
    private Short floorLevel;
    @NotNull
    @Access(AccessType.PROPERTY)
    @Column(name = "IS_FREE")
    private Boolean isFree;
    @NotNull
    @Access(AccessType.PROPERTY)
    @Column(name = "PRICE", precision = 2)
    private Double price;

    public Integer getApartment_id() {
        return apartment_id;
    }

    public void setApartment_id(Integer apartment_id) {
        this.apartment_id = apartment_id;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Short getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Short numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Short getFloorLevel() {
        return floorLevel;
    }

    public void setFloorLevel(Short floorLevel) {
        this.floorLevel = floorLevel;
    }

    public Boolean getFree() {
        return isFree;
    }

    public void setFree(Boolean free) {
        isFree = free;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Transient
    public Double pricePreMeter(){
        return getPrice() / getArea();
    }
    @Override
    public int compareTo(Apartment otherApartment) {
        int result = this.projectNumber.compareTo(otherApartment.getProjectNumber());
        if(result == 0) result = this.apartmentNumber.compareTo(otherApartment.getApartmentNumber());
        if(result == 0) result = this.area.compareTo(otherApartment.getArea());
        if(result == 0) result = this.numberOfRooms.compareTo(otherApartment.getNumberOfRooms());
        if(result == 0) result = this.section.compareTo(otherApartment.getSection());
        if(result == 0) result = this.floorLevel.compareTo(otherApartment.getFloorLevel());
        if(result == 0) result = this.price.compareTo(otherApartment.getPrice());
        return result;
    }
}
