package tum.seba.mobilityservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tum.seba.mobilityservices.entity.Vehicle;
import tum.seba.mobilityservices.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	public void save(Vehicle newVehicle) {
		vehicleRepository.save(newVehicle);
	}
	
	public Iterable<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}
	
	public Vehicle findById(int vehicleId) {
		
		Optional<Vehicle> foundVehicle = vehicleRepository.findById(vehicleId);
		
		if (foundVehicle.isPresent()) {
			return foundVehicle.get();
		} else {
			return null;
		}
		
	}
	
	public void deleteById(int vehicleId) {
		
		try {
			vehicleRepository.deleteById(vehicleId);
		}
		catch (Exception e) {
			System.err.println("Unable to delete Vehicle with ID: " + vehicleId);
		}
		
	}

}
