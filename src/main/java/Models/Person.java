package Models;

import Models.Client;
import Models.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String pesel;
    private String name;
    private String surname;
    private String email;
    private long phone_number;

    public Person() {}

    public Person(long id, String pesel, String name, String surname, String email, long phone_number) {
        this.id = id;
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone_number = phone_number;
    }

    @OneToOne(mappedBy = "person")
    private Client client;

    @OneToOne(mappedBy = "person")
    private Employee employee;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", pesel=" + pesel +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone_number=" + phone_number +
                '}';
    }

}

