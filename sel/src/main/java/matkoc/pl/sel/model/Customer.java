package matkoc.pl.sel.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="customers")
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @ToString @EqualsAndHashCode
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_customer;
    @Column(nullable = false)
    private String fName;
    @Column(nullable = false)
    private String lName;

}
