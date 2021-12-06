package Controllers;

import Models.Car;
import Models.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PersonController {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<Person> searchPersonByPesel(String pesel){
        List<Person> persons = em.createQuery("select p from Person p where p.pesel = :pesel")
                .setParameter("pesel", pesel)
                .getResultList();
        return persons;
    }

    public List<Person> searchPersonById(long id){
        List<Person> persons = em.createQuery("select p from Person p where p.id = :id")
                .setParameter("id", id)
                .getResultList();
        return persons;
    }

    public Person searchPersonById2(long personId){
        Person person = (Person) em.createQuery("select p from Person p where p.id = :personId")
                .setParameter("personId", personId)
                .getSingleResult();
        return person;
    }

    public void addPerson(String pesel, String name, String surname, String email, long phone_number){
        em.getTransaction().begin();
        Person person = new Person();
        person.setPesel(pesel);
        person.setName(name);
        person.setSurname(surname);
        person.setEmail(email);
        person.setPhone_number(phone_number);
        em.merge(person);
        em.getTransaction().commit();
    }

    public void deletePersonById(long id){
        em.getTransaction().begin();
        em.remove(searchPersonById(id));
        em.getTransaction().commit();
    }

    public void deletePerson(Person person){
        em.getTransaction().begin();
        em.remove(person);
        em.getTransaction().commit();
    }

}
