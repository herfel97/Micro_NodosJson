package ec.edu.ups.micro.demo.controller;

import ec.edu.ups.micro.demo.models.RequestMessage;
import ec.edu.ups.micro.demo.models.Root;
import ec.edu.ups.micro.demo.services.SensorCo2Service;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;

@RestController
@RequestMapping("/nodoCo2")
public class Co2Controller {

    @Autowired
    SensorCo2Service sensorCo2Service;

    @PostMapping(path = "/save")
    public RequestMessage registrar(@RequestBody Root root){
        return this.sensorCo2Service.registrarMedicionCo2(root);
    }

    @PostMapping(value = "/list")
    public String listar(@RequestParam  /*@DateTimeFormat(pattern = "yyyy-MM-dd")*/ String fecha ) throws  Exception  {
        return this.sensorCo2Service.listar(fecha);
    }

}
