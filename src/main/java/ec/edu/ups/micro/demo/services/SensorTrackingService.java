package ec.edu.ups.micro.demo.services;

import ec.edu.ups.micro.demo.models.RequestMessage;
import ec.edu.ups.micro.demo.models.Root;
import ec.edu.ups.micro.demo.models.SensorTracking;
import ec.edu.ups.micro.demo.repository.SensorTrackingRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorTrackingService {

    @Autowired
    SensorTrackingRepository sensorTrackingRepository;


    public RequestMessage registroPeticionTracking(Root root){
        JSONObject json = new JSONObject(root.getObjectJSON());

        SensorTracking sensorTracking = new SensorTracking();
        sensorTracking.setDeviceName(root.getDeviceName());
        sensorTracking.setFecha(root.getRxInfo().get(0).getTime());
        sensorTracking.setAcc_x(json.getDouble("Acc_x"));
        sensorTracking.setAcc_y(json.getDouble("Acc_y"));
        sensorTracking.setAcc_z(json.getDouble("Acc_z"));
        sensorTracking.setHour(json.getInt("hour"));
        sensorTracking.setMinute(json.getInt("minute"));
        sensorTracking.setSecond(json.getInt("second"));
        sensorTracking.setUsecond(json.getInt("usecond"));
        sensorTracking.setLatitude(json.getDouble("latitude"));
        sensorTracking.setLongitude(json.getDouble("longitude"));
        sensorTracking.setVoltaje(json.getDouble("voltaje"));
        RequestMessage rm = new RequestMessage();

        try {
            sensorTrackingRepository.save(sensorTracking);
            rm.setCode("0");
            rm.setMessage("Peticion ingresada correctamente: "+json.toString());
        }catch (Exception e){
            rm.setCode("1");
            rm.setMessage("Fallo WS"+e.getMessage());
        }
        return rm;
    }

}
