package ec.edu.ups.micro.demo.controller;

import ec.edu.ups.micro.demo.models.Nodo;
import ec.edu.ups.micro.demo.models.Root;
import ec.edu.ups.micro.demo.services.NodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/nodo")
public class NodoController {

    @Autowired
    NodoService nodoService;

    @GetMapping()
    public ArrayList<Nodo> obtenerNodos() {
        return nodoService.obtenerNodos();
    }

    @PostMapping()
    public Nodo guardarNodo(@RequestBody Nodo nodo) {
        return this.nodoService.guardarNodo(nodo);
    }

    @GetMapping(path = "/{id}")
    public Optional<Nodo> obtenerNodoPorId(@PathVariable("id") Long id) {
        return nodoService.obtenerPorId(id);
    }

    @PostMapping(path = "/generar")
    public Root registrarPeticion(@RequestBody Root root){
        return this.nodoService.registroPeticion(root);
    }

    @PostMapping(path = "/porfecha")
    public ArrayList<Nodo> obtenerMedicionesPorFecha(@PathVariable("fecha") Date date){
        return
    }


}
