package Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date employedSince;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId", referencedColumnName = "id")
    private Person person;

    @ManyToOne
    @JoinColumn(name="positionId", nullable=false)
    private Wage wage;

    public Employee() {}

    public Employee(long id, Date employedSince) {
        this.id = id;
        this.employedSince = employedSince;
    }

}
