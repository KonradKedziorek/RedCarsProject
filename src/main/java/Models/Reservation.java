package Models;

import Models.Car;
import Models.Client;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date issueDate;
    private Date returnDate;

    @ManyToMany(mappedBy = "reservations")
    private Set<Client> clients = new HashSet<>();

    @ManyToMany(mappedBy = "reservations")
    private Set<Car> cars = new HashSet<>();

    public Reservation(long id, Date issueDate, Date returnDate) {
        this.id = id;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public Reservation() {}

}
