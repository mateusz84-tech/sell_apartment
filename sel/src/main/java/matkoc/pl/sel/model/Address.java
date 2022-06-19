package matkoc.pl.sel.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="addresses")
@NoArgsConstructor
@AllArgsConstructor @ToString @EqualsAndHashCode
public class Address implements Comparable<Address>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer address_id;
    @NotNull
    @Access(AccessType.PROPERTY)
    @Column(name = "STREET")
    private String street;
    @NotNull
    @Access(AccessType.PROPERTY)
    @Column(name = "STREET_NUMBER")
    private String streetNumber;
    @NotNull
    @Access(AccessType.PROPERTY)
    @Column(name = "CITY")
    private String city;
    @NotNull
    @Access(AccessType.PROPERTY)
    @Column(name = "ZIP_CODE")
    private String zipCode;

    @OneToOne(mappedBy = "address")
    @JoinColumn(name ="ID_CUSTOMER")
    private Customer customer;

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int compareTo(Address otherAddress) {
        int result = this.street.compareTo(otherAddress.getStreet());
        if(result == 0) result = this.streetNumber.compareTo(otherAddress.getStreetNumber());
        if(result == 0) result = this.city.compareTo(otherAddress.getCity());
        if(result == 0) result = this.zipCode.compareTo(otherAddress.getZipCode());
        return result;
    }
}
