package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ElectricCar;

/**
 * Tanner Patterson - tpatterson4
 * CIS175 or CIS152 - SPRING
 * Jan 31, 2022
 */
public class ElectricCarHelper
{
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ElectricCarList");
	
	public void insertCar(ElectricCar ec)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ec);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ElectricCar> showAllCars()
	{
		EntityManager em = emfactory.createEntityManager();
		List<ElectricCar> allItems = em.createQuery("SELECT ec FROM ElectricCar ec").getResultList();
		return allItems;
	}
	
	public void deleteCar(ElectricCar toDelete)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ElectricCar> typedQuery = em.createQuery("select ec from ElectricCar ec where ec.make = :selectedMake "
				+ "and ec.model = :selectedModel and ec.year = :selectedYear and ec.price = :selectedPrice and ec.maxmiles = :selectedMaxmiles "
				+ "and ec.topspeed = :selectedTopspeed and ec.zerosixtyacceleration = :selectedZerosixtyacceleration "
				+ "and ec.chargepower = :selectedChargepower", ElectricCar.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		typedQuery.setParameter("selectedYear", toDelete.getYear());
		typedQuery.setParameter("selectedPrice", toDelete.getPrice());
		typedQuery.setParameter("selectedMaxmiles", toDelete.getMaxmiles());
		typedQuery.setParameter("selectedTopspeed", toDelete.getTopspeed());
		typedQuery.setParameter("selectedZerosixtyacceleration", toDelete.getZerosixtyacceleration());
		typedQuery.setParameter("selectedChargepower", toDelete.getChargepower());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		ElectricCar result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public ElectricCar searchForElectricCarById(int idToEdit) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ElectricCar found = em.find(ElectricCar.class, idToEdit);
		em.close();
		return found;
	}

	public void updateCar(ElectricCar toEdit) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<ElectricCar> searchForElectricCarByMake(String make) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ElectricCar> typedQuery = em.createQuery("select ec from ElectricCar ec where ec.make = :selectedMake", ElectricCar.class);
		typedQuery.setParameter("selectedMake", make);
		
		List<ElectricCar> foundElectricCars = typedQuery.getResultList();
		em.close();
		return foundElectricCars;
	}

	public List<ElectricCar> searchForElectricCarByModel(String model) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ElectricCar> typedQuery = em.createQuery("select ec from ElectricCar ec where ec.model = :selectedModel", ElectricCar.class);
		typedQuery.setParameter("selectedModel", model);
		
		List<ElectricCar> foundElectricCars = typedQuery.getResultList();
		em.close();
		return foundElectricCars;
	}
	
	public List<ElectricCar> searchForElectricCarByYear(int year) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ElectricCar> typedQuery = em.createQuery("select ec from ElectricCar ec where ec.year = :selectedYear", ElectricCar.class);
		typedQuery.setParameter("selectedYear", year);
		
		List<ElectricCar> foundElectricCars = typedQuery.getResultList();
		em.close();
		return foundElectricCars;
	}
	
	public List<ElectricCar> searchForElectricCarByPrice(double price) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ElectricCar> typedQuery = em.createQuery("select ec from ElectricCar ec where ec.price = :selectedPrice", ElectricCar.class);
		typedQuery.setParameter("selectedPrice", price);
		
		List<ElectricCar> foundElectricCars = typedQuery.getResultList();
		em.close();
		return foundElectricCars;
	}
	
	public List<ElectricCar> searchForElectricCarByMaxMiles(int maxmiles) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ElectricCar> typedQuery = em.createQuery("select ec from ElectricCar ec where ec.maxmiles = :selectedMaxmiles", ElectricCar.class);
		typedQuery.setParameter("selectedMaxmiles", maxmiles);
		
		List<ElectricCar> foundElectricCars = typedQuery.getResultList();
		em.close();
		return foundElectricCars;
	}
	
	public List<ElectricCar> searchForElectricCarByTopSpeed(int topspeed) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ElectricCar> typedQuery = em.createQuery("select ec from ElectricCar ec where ec.topspeed = :selectedTopspeed", ElectricCar.class);
		typedQuery.setParameter("selectedTopspeed", topspeed);
		
		List<ElectricCar> foundElectricCars = typedQuery.getResultList();
		em.close();
		return foundElectricCars;
	}
	
	public List<ElectricCar> searchForElectricCarByZeroSixtyAcceleration(double zerosixtyacceleration) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ElectricCar> typedQuery = em.createQuery("select ec from ElectricCar ec where ec.zerosixtyacceleration = :selectedZerosixtyacceleration", ElectricCar.class);
		typedQuery.setParameter("selectedZerosixtyacceleration", zerosixtyacceleration);
		
		List<ElectricCar> foundElectricCars = typedQuery.getResultList();
		em.close();
		return foundElectricCars;
	}
	
	public List<ElectricCar> searchForElectricCarByChargePower(int chargepower) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ElectricCar> typedQuery = em.createQuery("select ec from ElectricCar ec where ec.chargepower = :selectedChargepower", ElectricCar.class);
		typedQuery.setParameter("selectedChargepower", chargepower);
		
		List<ElectricCar> foundElectricCars = typedQuery.getResultList();
		em.close();
		return foundElectricCars;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
