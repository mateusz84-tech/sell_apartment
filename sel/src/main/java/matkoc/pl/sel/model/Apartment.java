package matkoc.pl.sel.model;

import lombok.*;
import javax.persistence.*;
@Entity
@Table(name="apartments")
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @ToString @EqualsAndHashCode
public class Apartment implements Comparable<Apartment>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer apartment_id;
    @Column(nullable = false, unique = true)
    private String projectNumber;
    @Column(nullable = false, unique = true)
    private String apartmentNumber;
    @Column(nullable = false, scale = 5, precision = 2)
    private Double area;
    @Column(nullable = false)
    private Short numberOfRooms;
    @Column(nullable = false)
    private String section;
    @Column(nullable = false)
    private Short floorLevel;
    private Boolean isFree;
    @Column(nullable = false, precision = 2)
    private Double price;


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
