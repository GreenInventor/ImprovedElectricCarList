package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Tanner Patterson - tpatterson4
 * CIS175 or CIS152 - SPRING
 * Feb 23, 2022
 */
@Entity
public class Dealership 
{
	@Id
	@GeneratedValue
	private int id;
	private String dealershipName;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ElectricCar> cars;
	
	/**
	 * 
	 */
	public Dealership() 
	{
		super();
	}

	/**
	 * @param id
	 * @param dealershipName
	 * @param cars
	 */
	public Dealership(int id, String dealershipName, List<ElectricCar> cars) {
		super();
		this.id = id;
		this.dealershipName = dealershipName;
		this.cars = cars;
	}

	/**
	 * @param dealershipName
	 * @param cars
	 */
	public Dealership(String dealershipName, List<ElectricCar> cars) {
		super();
		this.dealershipName = dealershipName;
		this.cars = cars;
	}

	/**
	 * @return the dealershipName
	 */
	public String getDealershipName() {
		return dealershipName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the cars
	 */
	public List<ElectricCar> getCars() {
		return cars;
	}

	/**
	 * @param cars the cars to set
	 */
	public void setCars(List<ElectricCar> cars) {
		this.cars = cars;
	}

	/**
	 * @param dealershipName the dealershipName to set
	 */
	public void setDealershipName(String dealershipName) {
		this.dealershipName = dealershipName;
	}
}
