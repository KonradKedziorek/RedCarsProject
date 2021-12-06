package Controllers;

import Models.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeController {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<Employee> searchById(long id){
        List<Employee> employees = em.createQuery("select e from Employee e where e.id = :id")
                .setParameter("id", id)
                .getResultList();
        return employees;
    }

}
