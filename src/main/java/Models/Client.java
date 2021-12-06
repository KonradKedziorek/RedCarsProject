package Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String driversLicenseNumber;

    public Client() {}

    public Client(long id, String driversLicenseNumber) {
        this.id = id;
        this.driversLicenseNumber = driversLicenseNumber;
    }

    @OneToOne
    @JoinColumn(name = "personId", referencedColumnName = "id")
    private Person person;

    @OneToOne
    @JoinColumn(name = "rentId", referencedColumnName = "id")
    private Rent rent;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "clientReservation",
            joinColumns = { @JoinColumn(name = "clientId") },
            inverseJoinColumns = { @JoinColumn(name = "reservationId") }
    )
    Set<Reservation> reservations = new HashSet<>();

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", driversLicenseNumber=" + driversLicenseNumber +
                '}';
    }

}
