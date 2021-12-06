package Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String model;
    private String licensePlate;
    private long productionDate;
    private long mileage;
    private String fuel;
    private String VIN;

    public Car(String brand, String model, String licensePlate, Long productionDate, Long mileage, String fuel, String VIN, PriceList priceList) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.productionDate = productionDate;
        this.mileage = mileage;
        this.fuel = fuel;
        this.VIN = VIN;
        this.priceList = priceList;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "carReservation",
            joinColumns = { @JoinColumn(name = "carId") },
            inverseJoinColumns = { @JoinColumn(name = "reservationId") }
    )
    Set<Reservation> reservations = new HashSet<>();

    @OneToOne(mappedBy = "car")
    private Fault fault;

    @OneToOne(mappedBy = "car")
    private Rent rent;

    @ManyToOne
    @JoinColumn(name="priceListId", nullable=false)
    private PriceList priceList;

    public Car() {}

    @OneToOne(mappedBy = "car")
    private VehicleInspection vehicleInspection;

    @OneToOne(mappedBy = "car")
    private Insurance insurance;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", productionDate=" + productionDate +
                ", mileage=" + mileage +
                ", fuel='" + fuel + '\'' +
                ", VIN='" + VIN + '\'' +
                '}' + "\r\n";
    }
}
