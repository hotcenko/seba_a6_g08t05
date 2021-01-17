package tum.seba.mobilityservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tum.seba.mobilityservices.entity.Customer;
import tum.seba.mobilityservices.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public void save(Customer newCustomer) {
		customerRepository.save(newCustomer);
	}
	
	public Iterable<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	public Customer findById(int customerId) {
		
		Optional<Customer> foundCustomer = customerRepository.findById(customerId);
		
		if (foundCustomer.isPresent()) {
			return foundCustomer.get();
		} else {
			return null;
		}
		
	}
	
	public void deleteById(int customerId) {
		
		try {
			customerRepository.deleteById(customerId);
		}
		catch (Exception e) {
			System.err.println("Unable to delete Customer with ID: " + customerId);
		}
		
	}

}
