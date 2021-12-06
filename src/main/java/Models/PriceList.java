package Models;

import Models.Car;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
//@ToString
@Table(name = "priceList")
public class PriceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double price;

    public PriceList(long id, double price) {
        this.id = id;
        this.price = price;
    }

    @OneToMany(mappedBy="priceList")
    private Set<Car> cars;

    public PriceList() {}

    @Override
    public String toString() {
        return "PriceList{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
