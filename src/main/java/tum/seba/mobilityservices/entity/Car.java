package tum.seba.mobilityservices.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.util.Date;
import javax.validation.constraints.NotBlank;

@Entity
public class Car extends Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int numberOfSeats;
	private int horsePower;
	@NotBlank(message = "FuelType is required")
	private String fuelType;
	@Min(value =1, message = "Current Mileage need to be at least 1")
	private int currentMileage;

	public Car() {
	}

	public Car(String manufacturer, String modelType, Date lastService, boolean isAvailable, int numberOfSeats,
			int horsePower, String fuelType, int currentMileage) {
		super(manufacturer, modelType, lastService, isAvailable);
		this.numberOfSeats = numberOfSeats;
		this.horsePower = horsePower;
		this.fuelType = fuelType;
		this.currentMileage = currentMileage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getCurrentMileage() {
		return currentMileage;
	}

	public void setCurrentMileage(int currentMileage) {
		this.currentMileage = currentMileage;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", numberOfSeats=" + numberOfSeats + ", horsePower=" + horsePower + ", fuelType="
				+ fuelType + ", currentMileage=" + currentMileage + "]";
	}

}
