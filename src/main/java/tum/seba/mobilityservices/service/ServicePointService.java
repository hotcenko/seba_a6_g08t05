package tum.seba.mobilityservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tum.seba.mobilityservices.entity.ServicePoint;
import tum.seba.mobilityservices.repository.ServicePointRepository;

@Service
public class ServicePointService {

	@Autowired
	ServicePointRepository servicePointRepository;
	
	public void save(ServicePoint newServicePoint) {
		servicePointRepository.save(newServicePoint);
	}
	
	public Iterable<ServicePoint> findAll() {
		return servicePointRepository.findAll();
	}
	
	public ServicePoint findById(int servicePointId) {
		
		Optional<ServicePoint> foundServicePoint = servicePointRepository.findById(servicePointId);
		
		if (foundServicePoint.isPresent()) {
			return foundServicePoint.get();
		} else {
			return null;
		}
		
	}
	
	public void deleteById(int servicePointId) {
		
		try {
			servicePointRepository.deleteById(servicePointId);
		}
		catch (Exception e) {
			System.err.println("Unable to delete ServicePoint with ID: " + servicePointId);
		}
		
	}

}
