package ec.edu.ups.micro.demo.repository;

import ec.edu.ups.micro.demo.models.Nodo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;


@Repository
public interface NodoRepository  extends CrudRepository<Nodo,Long> {


}
