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
@Table(name = "insurance")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date startInsureDate;
    private Date endInsureDate;
    private String type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carId", referencedColumnName = "id")
    private Car car;

    public Insurance(long id, Date startInsureDate, Date endInsureDate, String type) {
        this.id = id;
        this.startInsureDate = startInsureDate;
        this.endInsureDate = endInsureDate;
        this.type = type;
    }

    public Insurance() {}
}
