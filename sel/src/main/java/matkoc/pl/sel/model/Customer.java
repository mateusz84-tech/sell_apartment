package matkoc.pl.sel.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="customers")
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @ToString @EqualsAndHashCode
public class Customer implements Comparable<Customer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_customer;
    @Column(nullable = false)
    private String fName;
    @Column(nullable = false)
    private String lName;
    @Column(nullable = false, unique = true)
    private Integer phoneNumber;
    @Column(nullable = true, unique = true)
    private Long accountNumber;
    @Column(nullable = true, unique = true)
    private String email;

    @OneToOne(optional = false)
    @JoinColumn(name = "address_id")
    private Address address;

    @Override
    public int compareTo(Customer otherCustomer) {
        int result = this.fName.compareTo(otherCustomer.getFName());
        if(result == 0) result = this.lName.compareTo(otherCustomer.getLName());
        if(result == 0) result = this.email.compareTo(otherCustomer.getEmail());
        return result;
    }
}
