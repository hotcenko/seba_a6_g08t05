package tum.seba.mobilityservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.status.Status;
import tum.seba.mobilityservices.entity.Rental;
import tum.seba.mobilityservices.repository.RentalRepository;

@Service
public class RentalService {

	@Autowired
	private RentalRepository rentalRepository;

	public void save(Rental newRental) {
		rentalRepository.save(newRental);
	}

	public Iterable<Rental> findAll() {
		return rentalRepository.findAll();
	}

	public Rental findById(int rentalId) {

		Optional<Rental> foundRental = rentalRepository.findById(rentalId);

		if (foundRental.isPresent()) {
			return foundRental.get();
		} else {
			return null;
		}

	}

	public Rental findAllCompletedRentals(Status status) {
//		return RentalRepository.findAllCompletedRentals(status);
		return null;
	}

	public void deleteById(int rentalId) {

		try {
			rentalRepository.deleteById(rentalId);
		} catch (Exception e) {
			System.err.println("Unable to delete Rental with ID: " + rentalId);
		}

	}

}
