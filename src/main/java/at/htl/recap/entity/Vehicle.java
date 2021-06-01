package at.htl.recap.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="V_VEHICLE")
@SequenceGenerator(
        name="vehicleSeq",
        sequenceName = "VEHICLE_SEQ",
        initialValue = 1000
)
public class Vehicle {

    @Id
    @Column(name = "V_ID")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vehicleSeq"
    )
    Long id;

    @Column(name = "V_BRAND")
    String brand;

    @Column(name = "V_MODEL")
    String model;

    @Column(name = "V_YOC")
    int yoc;

    public int age(){
        return LocalDate.now().getYear() - yoc;
    }

    @Override
    public String toString() {
        return String.format("%s %s", brand, model);
    }
}
