package tum.seba.mobilityservices.repository;

import ch.qos.logback.core.status.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tum.seba.mobilityservices.entity.Customer;
import tum.seba.mobilityservices.entity.Invoice;
import tum.seba.mobilityservices.entity.Rental;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "SELECT i, c, r FROM Customer c, Invoice i, Rental r WHERE c.rentals = r.invoice and i.isPaid = false", nativeQuery = true)
    List<Customer> findAllCustomerUnpaidInvoices();

}
