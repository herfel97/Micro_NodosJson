package ec.edu.ups.micro.demo.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sensorC02")
public class SensorCO2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String deviceName;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    private double Co2_A;
    private double Co2_b;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCo2_A() {
        return Co2_A;
    }

    public void setCo2_A(double co2_A) {
        Co2_A = co2_A;
    }

    public double getCo2_b() {
        return Co2_b;
    }

    public void setCo2_b(double co2_b) {
        Co2_b = co2_b;
    }
}
