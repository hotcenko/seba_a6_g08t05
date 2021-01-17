package tum.seba.mobilityservices.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

@Entity
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Min(value = 5, message = "Price must be at least 5.00 (30 minuts)")
	private double price;
	private boolean isPaid;

	@OneToOne(mappedBy = "invoice", cascade = CascadeType.ALL)
	private Rental rental;

	public Invoice() {
	}

	public Invoice(double price, boolean isPaid) {
		this.price = price;
		this.isPaid = isPaid;
	}


	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", price=" + price + ", isPaid=" + isPaid + "]";
	}

}
