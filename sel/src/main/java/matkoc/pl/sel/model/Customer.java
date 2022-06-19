package matkoc.pl.sel.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="customers")
@NoArgsConstructor
@AllArgsConstructor @ToString @EqualsAndHashCode
public class Customer implements Comparable<Customer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_customer;
    @NotNull
    @Access(AccessType.PROPERTY)
    @Column(name = "FIRST_NAME")
    private String fName;
    @NotNull
    @Access(AccessType.PROPERTY)
    @Column(name = "LAST_NAME")
    private String lName;
    @NotNull
    @Access(AccessType.PROPERTY)
    @Column(name = "PHONE_NUMBER", unique = true)
    private Integer phoneNumber;
    @NotNull
    @Access(AccessType.PROPERTY)
    @Column(name ="ACCOUNT_NUMBER", unique = true)
    private Long accountNumber;
    @NotNull
    @Access(AccessType.PROPERTY)
    @Column(name = "EMAIL", unique = true)
    private String email;

    @OneToOne(optional = false)
    @JoinColumn(name = "ID_ADDRESS")
    @Access(AccessType.PROPERTY)
    private Address address;

    @Override
    public int compareTo(Customer otherCustomer) {
        int result = this.fName.compareTo(otherCustomer.getfName());
        if(result == 0) result = this.lName.compareTo(otherCustomer.getlName());
        if(result == 0) result = this.email.compareTo(otherCustomer.getEmail());
        return result;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
