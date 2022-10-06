package ec.edu.ups.micro.demo.services;

import ec.edu.ups.micro.demo.models.Nodo;
import ec.edu.ups.micro.demo.models.Root;
import ec.edu.ups.micro.demo.models.SensorTracking;
import ec.edu.ups.micro.demo.repository.NodoRepository;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import sun.awt.X11.XSystemTrayPeer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class NodoService {

    @Autowired
    NodoRepository nodoRepository;

    public ArrayList<Nodo> obtenerNodos(){
        return (ArrayList<Nodo>) nodoRepository.findAll();
    }

    public Nodo guardarNodo(Nodo nodo){

        return nodoRepository.save(nodo);
    }

    public Optional<Nodo> obtenerPorId(Long id){
        return nodoRepository.findById(id);
    }



}
