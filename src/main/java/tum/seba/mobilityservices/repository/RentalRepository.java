package tum.seba.mobilityservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ch.qos.logback.core.status.Status;
import tum.seba.mobilityservices.entity.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {
	@Query(value = "SELECT r FROM Rental r WHERE r.Status = ?1", nativeQuery = true)
	Rental findAllCompletedRentals(Status status);

}
