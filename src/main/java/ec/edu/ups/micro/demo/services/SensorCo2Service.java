package ec.edu.ups.micro.demo.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.org.apache.regexp.internal.RE;
import ec.edu.ups.micro.demo.models.RequestMessage;
import ec.edu.ups.micro.demo.models.Root;
import ec.edu.ups.micro.demo.models.SensorCO2;
import ec.edu.ups.micro.demo.repository.SensorCo2Repository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class SensorCo2Service {

    @Autowired
    SensorCo2Repository sensorCo2Repository;

    public RequestMessage registrarMedicionCo2(Root root){
        JSONObject json = new JSONObject(root.getObjectJSON());

        SensorCO2 sensorCO2 = new SensorCO2();

        sensorCO2.setFecha(root.getRxInfo().get(0).getTime());
        sensorCO2.setDeviceName(root.getDeviceName());
        sensorCO2.setCo2_A(json.getDouble("Co2_A"));
        sensorCO2.setCo2_b(json.getDouble("Co2_b"));

        RequestMessage rm = new RequestMessage();

        try {
            sensorCo2Repository.save(sensorCO2);
            rm.setCode("0");
            rm.setMessage("Peticion ingresada correctamente: "+json.toString());
        }catch (Exception e){
            rm.setCode("1");
            rm.setMessage("Fallo WS"+e.getMessage());
        }
        return rm;
    }

    public String listar(String fecha) throws Exception {

        Date sdf  = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        List<SensorCO2> listarSensoresPorFecha = sensorCo2Repository.listarSensoresPorFecha(sdf);
        Type listType = new TypeToken<List<SensorCO2>>() {}.getType();

        System.out.println(listarSensoresPorFecha.size());
        Gson gson = new Gson();
        String json = gson.toJson(listarSensoresPorFecha, listType);

        return json;
    }

}
