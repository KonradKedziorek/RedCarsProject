package Models;

import Models.Car;
import Models.Client;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "rent")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long employeeId;
    private LocalDate issueDate;
    private LocalDate returnDate;

    @OneToOne(mappedBy = "rent")
    private Client client;

    @OneToOne
    @JoinColumn(name = "carId", referencedColumnName = "id")
    private Car car;

    public Rent(long id, long employeeId, LocalDate issueDate, LocalDate returnDate) {
        this.id = id;
        this.employeeId = employeeId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public Rent() {}

}
