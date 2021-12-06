package Models;

import Models.Car;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "vehicleInspection")
public class VehicleInspection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date validityDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carId", referencedColumnName = "id")
    private Car car;

    public VehicleInspection(long id, Date validityDate) {
        this.id = id;
        this.validityDate = validityDate;
    }

    public VehicleInspection() {}
}
