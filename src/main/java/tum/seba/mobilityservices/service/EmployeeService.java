package tum.seba.mobilityservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tum.seba.mobilityservices.entity.Employee;
import tum.seba.mobilityservices.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void save(Employee newEmployee) {
		employeeRepository.save(newEmployee);
	}
	
	public Iterable<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	public Employee findById(int employeeId) {
		
		Optional<Employee> foundEmployee = employeeRepository.findById(employeeId);
		
		if (foundEmployee.isPresent()) {
			return foundEmployee.get();
		} else {
			return null;
		}
		
	}
	
	public void deleteById(int employeeId) {
		
		try {
			employeeRepository.deleteById(employeeId);
		}
		catch (Exception e) {
			System.err.println("Unable to delete Employee with ID: " + employeeId);
		}
		
	}

}
