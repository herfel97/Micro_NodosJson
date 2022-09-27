package ec.edu.ups.micro.demo.services;

import ec.edu.ups.micro.demo.models.Nodo;
import ec.edu.ups.micro.demo.repository.NodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
