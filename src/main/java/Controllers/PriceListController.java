package Controllers;

import Models.Car;
import Models.PriceList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PriceListController {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
    EntityManager em = entityManagerFactory.createEntityManager();

    public PriceList searchByPrice(double price){
        PriceList priceList = (PriceList) em.createQuery("select p from PriceList p where p.price = :price")
                .setParameter("price", price)
                .getSingleResult();
        return priceList;
    }

    public List<PriceList> searchAllPrices(){
        List<PriceList> prices = em.createQuery("select p.price from PriceList p")
                .getResultList();
        return prices;
    }

}
