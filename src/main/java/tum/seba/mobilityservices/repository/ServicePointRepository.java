package tum.seba.mobilityservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tum.seba.mobilityservices.entity.Customer;
import tum.seba.mobilityservices.entity.ServicePoint;
import tum.seba.mobilityservices.entity.Vehicle;

import java.util.List;

@Repository
public interface ServicePointRepository extends JpaRepository<ServicePoint, Integer> {
    @Query(value = "SELECT s, v FROM ServicePoint s, Vehicle v WHERE s = ?1 and s.vehicles = v.id", nativeQuery = true)
    List<Vehicle> findAllVehiclesForServicePoint(ServicePoint servicePoint);
}
