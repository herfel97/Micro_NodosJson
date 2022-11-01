package ec.edu.ups.micro.demo.repository;

import ec.edu.ups.micro.demo.models.SensorCO2;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SensorCo2Repository extends CrudRepository<SensorCO2, Long> {

    @Query ("SELECT n from SensorCO2 n")
    List<SensorCO2> listarTodo();

    @Query ("SELECT n from SensorCO2 n where n.fecha = :fechaParam")
    List<SensorCO2> listarSensoresPorFecha(@Param("fechaParam") Date fecha);

    @Query ("SELECT n from SensorCO2 n where n.fecha <= :fechaParam")
    List<SensorCO2> listarSensoresPorRangoDeFechas(@Param("fechaParam") Date fechaFinal);

    @Query ("SELECT n from SensorCO2 n where n.deviceName = :nombreDispositivo")
    List<SensorCO2> listarMedicionesPorDispositivo(@Param("nombreDispositivo") String nombreDispositivo);

    @Query ("SELECT n from SensorCO2 n where n.deviceName = :nombreDispositivo and n.fechaBusq = :fecha")
    List<SensorCO2> listarMedicionesPorDispositivoyFecha(@Param("nombreDispositivo") String nombreDispositivo, @Param("fecha") Date fecha);

}
