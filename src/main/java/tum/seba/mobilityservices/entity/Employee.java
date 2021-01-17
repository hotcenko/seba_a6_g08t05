package tum.seba.mobilityservices.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Employee extends User {
	@NotBlank(message = "PhoneNumber is required")
	private String phoneNumber;
	private Date employmentDate;

	// ServicePoint
	@ManyToMany
	private List<ServicePoint> servicePoints;

	public Employee() {
	}

	public Employee(String firstName, String lastName, String email, String password, String streetName,
			int streetNumber, String city, String phoneNumber, Date employmentDate) {
		super(firstName, lastName, email, password, streetName, streetNumber, city);
		this.phoneNumber = phoneNumber;
		this.employmentDate = employmentDate;
	}

	public List<ServicePoint> getServicePoints() {
		return servicePoints;
	}

	public void setServicePoints(List<ServicePoint> servicePoints) {
		this.servicePoints = servicePoints;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getEmploymentDate() {
		return employmentDate;
	}

	public void setEmploymentDate(Date employmentDate) {
		this.employmentDate = employmentDate;
	}

	@Override
	public String toString() {
		return "Employee [phoneNumber=" + phoneNumber + ", employmentDate=" + employmentDate + "]";
	}

}
