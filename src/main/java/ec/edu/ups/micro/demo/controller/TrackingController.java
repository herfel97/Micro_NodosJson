package ec.edu.ups.micro.demo.controller;

import ec.edu.ups.micro.demo.models.RequestMessage;
import ec.edu.ups.micro.demo.models.Root;
import ec.edu.ups.micro.demo.services.SensorTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nodoTracking")
public class TrackingController {

    @Autowired
    SensorTrackingService sensorTrackingService;

    @PostMapping(path = "/save")
    public RequestMessage registrar(@RequestBody Root root){
        return this.sensorTrackingService.registroPeticionTracking(root);
    }

}
