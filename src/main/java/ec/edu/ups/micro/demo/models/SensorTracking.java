package ec.edu.ups.micro.demo.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sensorTracking")
public class SensorTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String deviceName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private double Acc_x;
    private double Acc_y;
    private double Acc_z;
    private int hour;
    private double latitude;
    private double longitude;
    private int minute;
    private int second;
    private int usecond;
    private double voltaje;



    public double getAcc_x() {
        return Acc_x;
    }

    public void setAcc_x(double acc_x) {
        Acc_x = acc_x;
    }

    public double getAcc_y() {
        return Acc_y;
    }

    public void setAcc_y(double acc_y) {
        Acc_y = acc_y;
    }

    public double getAcc_z() {
        return Acc_z;
    }

    public void setAcc_z(double acc_z) {
        Acc_z = acc_z;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getUsecond() {
        return usecond;
    }

    public void setUsecond(int usecond) {
        this.usecond = usecond;
    }

    public double getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(double voltaje) {
        this.voltaje = voltaje;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
