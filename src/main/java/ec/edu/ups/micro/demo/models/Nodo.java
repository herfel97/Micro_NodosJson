package ec.edu.ups.micro.demo.models;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nodos")
public class Nodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private int m1;
    private int m2;
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Nodo(){

    }

    public int getM1() {
        return m1;
    }

    public void setM1(int m1) {
        this.m1 = m1;
    }

    public int getM2() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2 = m2;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
