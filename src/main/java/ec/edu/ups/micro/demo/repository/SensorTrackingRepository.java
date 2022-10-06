package ec.edu.ups.micro.demo.repository;

import ec.edu.ups.micro.demo.models.Nodo;
import ec.edu.ups.micro.demo.models.SensorTracking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorTrackingRepository extends CrudRepository<SensorTracking,Long> {

}
