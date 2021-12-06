package Controllers;

import Models.Car;
import Models.PriceList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CarController {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<Car> searchCarById(long carId){
        List<Car> cars = em.createQuery("select c from Car c where c.id = :carId")
                .setParameter("carId", carId)
                .getResultList();
        return cars;
    }

    public Car searchCarById2(long carId){
        Car car = (Car) em.createQuery("select c from Car c where c.id = :carId")
                .setParameter("carId", carId)
                .getSingleResult();
        return car;
    }

    public List<Car> searchCarByVIN(String VIN){
        List<Car> cars = em.createQuery("select c from Car c where c.VIN like :VIN")
                .setParameter("VIN","%" + VIN + "%")
                .getResultList();
        return cars;
    }

    public List<Car> searchCarByBrand(String brand){
        List<Car> cars =  em.createQuery("select c from Car c where c.brand like :brand")
                .setParameter("brand", "%" + brand + "%")
                .getResultList();
        return cars;
    }

    public List<Car> searchCarByModel(String model){
        List<Car> cars = em.createQuery("select c from Car c where c.model like :model")
                .setParameter("model", "%" + model + "%")
                .getResultList();
        return cars;
    }

    public List<Car> searchAllCars(){
        List<Car> cars = em.createQuery("select c from Car c")
                .getResultList();
        return cars;
    }

    public void addCar(String brand, String model, String licensePlate, long productionDate, long mileage, String fuel, String VIN, PriceList priceList){
        em.getTransaction().begin();
        Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);
        car.setLicensePlate(licensePlate);
        car.setProductionDate(productionDate);
        car.setMileage(mileage);
        car.setFuel(fuel);
        car.setVIN(VIN);
        car.setPriceList(priceList);
        em.merge(car);
        em.getTransaction().commit();
    }

    public void deleteCarById(long id){
        em.getTransaction().begin();
        em.remove(searchCarById(id));
        em.getTransaction().commit();
    }

    public void deleteCar(Car car){
        em.getTransaction().begin();
        em.remove(car);
        em.getTransaction().commit();
    }

}
