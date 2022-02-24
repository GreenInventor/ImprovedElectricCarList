package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Dealership;

/**
 * Tanner Patterson - tpatterson4
 * CIS175 or CIS152 - SPRING
 * Feb 23, 2022
 */
public class DealershipHelper 
{
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ElectricCarList");
	
	public void insertNewDealership(Dealership dc)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(dc);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Dealership> getDealerships()
	{
		EntityManager em = emfactory.createEntityManager();
		List<Dealership> allDealers = em.createQuery("SELECT dc FROM Dealership dc").getResultList();
		return allDealers;
	}

	public Dealership searchForDealershipById(Integer tempId) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Dealership found = em.find(Dealership.class, tempId);
		em.close();
		return found;
	}

	public void deleteDealership(Dealership toDelete) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Dealership> typedQuery = em.createQuery("select dc from Dealership dc where dc.id = :selectedId", Dealership.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		Dealership result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public void updateDealership(Dealership toEdit) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
