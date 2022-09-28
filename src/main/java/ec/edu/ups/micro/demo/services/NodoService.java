package ec.edu.ups.micro.demo.services;

import ec.edu.ups.micro.demo.models.Nodo;
import ec.edu.ups.micro.demo.models.Root;
import ec.edu.ups.micro.demo.repository.NodoRepository;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.awt.X11.XSystemTrayPeer;

import java.util.ArrayList;
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

    public Root registroPeticion(Root root){
        System.out.println("Location");
        System.out.println("latitude: "+root.getRxInfo().get(0).getLocation().getLatitude());
        System.out.println("Altitude: "+root.getRxInfo().get(0).getLocation().getAltitude());
        System.out.println("Longitude: "+root.getRxInfo().get(0).getLocation().getLongitude());
        System.out.println("objectJSON: "+root.getObjectJSON());

        JSONObject json = new JSONObject(root.getObjectJSON());

        System.out.println("temperatureSensor: "+json.getInt("temperatureSensor"));
        System.out.println("humiditySensor: "+json.getInt("humiditySensor"));

        return root;
    }

}
