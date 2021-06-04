package at.htl.recap.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;

import static org.hibernate.annotations.CascadeType.PERSIST;

@Entity
@Table(name = "V_REGISTER")
@SequenceGenerator(
        name="registerSeq",
        sequenceName = "REGISTER_SEQ",
        initialValue = 5000
)
public class Register extends PanacheEntityBase {

    @Id
    @Column(name = "R_ID")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "registerSeq"
    )
    public Long id;

    @Column(name = "R_LICENSEPLATE")
    public String licensePLate;

    @Column(name = "R_OWNER")
    public String owner;

    @JoinColumn
    @Cascade(PERSIST)
    @ManyToOne
    public Vehicle vehicle;

    @Column(name = "R_ENDDATE")
    public LocalDate endDate;

    @Column(name = "R_STARTDATE")
    public LocalDate startDate;

    public Register(String licensePLate,
                    String owner,
                    Vehicle vehicle
    ) {
        this.licensePLate = licensePLate;
        this.owner = owner;
        this.vehicle = vehicle;
        this.startDate = LocalDate.now();
    }

    public Register() {
    }
}
