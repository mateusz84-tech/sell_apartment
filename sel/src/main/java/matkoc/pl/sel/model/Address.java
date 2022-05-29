package matkoc.pl.sel.model;

import lombok.*;
import javax.persistence.*;
@Entity
@Table(name="addresses")
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @ToString @EqualsAndHashCode
public class Address implements Comparable<Address>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer address_id;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String streetNumber;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private Customer customer;
    @Override
    public int compareTo(Address otherAddress) {
        int result = this.street.compareTo(otherAddress.getStreet());
        if(result == 0) result = this.streetNumber.compareTo(otherAddress.getStreetNumber());
        if(result == 0) result = this.city.compareTo(otherAddress.getCity());
        if(result == 0) result = this.zipCode.compareTo(otherAddress.getZipCode());
        return result;
    }
}
