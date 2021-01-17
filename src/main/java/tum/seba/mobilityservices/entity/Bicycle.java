package tum.seba.mobilityservices.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
@Entity
public class Bicycle extends Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Min(value=21, message = "Number of Gears need to be at least 21")
	private int numberOfGears;

	private boolean isElectrical;

	//Konstruktor
	public Bicycle() {
	}

	public Bicycle(String manufacturer, String modelType, Date lastService, boolean isAvailable, int numberOfGears,
			boolean isElectrical) {
		super(manufacturer, modelType, lastService, isAvailable);
		this.numberOfGears = numberOfGears;
		this.isElectrical = isElectrical;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberOfGears() {
		return numberOfGears;
	}

	public void setNumberOfGears(int numberOfGears) {
		this.numberOfGears = numberOfGears;
	}

	public boolean isElectrical() {
		return isElectrical;
	}

	public void setElectrical(boolean isElectrical) {
		this.isElectrical = isElectrical;
	}

	@Override
	public String toString() {
		return "Bicycle [id=" + id + ", numberOfGears=" + numberOfGears + ", isElectrical=" + isElectrical + "]";
	}

}
