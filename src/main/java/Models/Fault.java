package Models;

import Models.Car;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "fault")
public class Fault {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private Boolean fixedStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carId", referencedColumnName = "id")
    private Car car;

    public Fault(long id, String description, Boolean fixedStatus) {
        this.id = id;
        this.description = description;
        this.fixedStatus = fixedStatus;
    }

    public Fault() {}
}
