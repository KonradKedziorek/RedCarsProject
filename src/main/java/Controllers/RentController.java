package Controllers;

import Models.Car;
import Models.Rent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class RentController {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<Rent> searchRentById(long id){
        List<Rent> rents = em.createQuery("select r from Rent r where r.id = :id")
                .setParameter("id", id)
                .getResultList();
        return rents;
    }

    public Rent searchRentById2(long rentId){
        Rent rent = (Rent) em.createQuery("select r from Rent r where r.id = :rentId")
                .setParameter("rentId", rentId)
                .getSingleResult();
        return rent;
    }

    public void addRent(long employeeId, LocalDate issueDate, LocalDate returnDate, Car car){
        em.getTransaction().begin();
        Rent rent = new Rent();
        rent.setIssueDate(issueDate);
        rent.setReturnDate(returnDate);
        rent.setEmployeeId(employeeId);
        rent.setCar(car);
        em.merge(rent);
        em.getTransaction().commit();
    }

    public void deleteRentById(long id){
        em.getTransaction().begin();
        em.remove(searchRentById(id));
        em.getTransaction().commit();
    }

    public void deleteRent(Rent rent){
        em.getTransaction().begin();
        em.remove(rent);
        em.getTransaction().commit();
    }

}
