package tum.seba.mobilityservices.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Customer extends User {

	@Size(min = 3, max = 8, message = "Username must be at least 3 and up to 8 characters")
	private String username;
	private Date dateOfBirth;

	// Rental
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Rental> rentals;

	public Customer() {
	}

	public Customer(String firstName, String lastName, String email, String password, String streetName,
			int streetNumber, String city, String username, Date dateOfBirth) {
		super(firstName, lastName, email, password, streetName, streetNumber, city);
		this.username = username;
		this.dateOfBirth = dateOfBirth;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Customer [username=" + username + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
