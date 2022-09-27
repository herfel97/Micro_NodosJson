package ec.edu.ups.micro.demo.controller;

import ec.edu.ups.micro.demo.models.Nodo;
import ec.edu.ups.micro.demo.services.NodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/nodo")
public class NodoController {

    @Autowired
    NodoService nodoService;

    @GetMapping()
    public ArrayList<Nodo> obtenerNodos(){
        return nodoService.obtenerNodos();
    }

    @PostMapping()
    public Nodo guardarNodo(@RequestBody Nodo nodo){
        return this.nodoService.guardarNodo(nodo);
    }




}
