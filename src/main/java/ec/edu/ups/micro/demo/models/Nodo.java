package ec.edu.ups.micro.demo.models;
import javax.persistence.*;

@Entity
@Table(name = "medidaC02")
public class Nodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String m1;
    private int m2;

    /*JSON Chirpstack*/
    private String applicationID;
    private String applicationName;
    private String deviceName;
    private String devEUI;


    public Nodo(){

    }

    public String getM1() {
        return m1;
    }

    public void setM1(String m1) {
        this.m1 = m1;
    }

    public int getM2() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2 = m2;
    }
}
