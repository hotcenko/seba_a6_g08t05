package tum.seba.mobilityservices.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class ServicePoint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Name field is required")
	private String name;
	private String streetName;
	private int streetNumber;
	private String city;

	public ServicePoint() {
	}

	public ServicePoint(String name, String streetName, int streetNumber, String city) {
		this.name = name;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.city = city;
	}

	// Rental
	@OneToMany(mappedBy = "servicePoint", cascade = CascadeType.ALL)
	private List<Rental> rentals;

	// Employee
	@ManyToMany(mappedBy = "servicePoints", cascade = CascadeType.ALL)
	private List<Employee> employee;

	// Vehicle
	@OneToMany(mappedBy = "servicePoint", cascade = CascadeType.ALL)
	private List<Vehicle> vehicles;

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}



	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}



	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "ServicePoint [id=" + id + ", name=" + name + ", streetName=" + streetName + ", streetNumber="
				+ streetNumber + ", city=" + city + "]";
	}

}
