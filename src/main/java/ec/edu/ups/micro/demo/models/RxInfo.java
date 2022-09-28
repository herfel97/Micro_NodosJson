package ec.edu.ups.micro.demo.models;

import java.util.Date;

public class RxInfo {

    private String gatewayID;
    private Date time;
    private Object timeSinceGPSEpoch;
    private int rssi;
    private int loRaSNR;
    private int channel;
    private int rfChain;
    private int board;
    private int antenna;
    private Location location;
    private String fineTimestampType;
    private String context;
    private String uplinkID;

    public String getGatewayID() {
        return gatewayID;
    }

    public void setGatewayID(String gatewayID) {
        this.gatewayID = gatewayID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Object getTimeSinceGPSEpoch() {
        return timeSinceGPSEpoch;
    }

    public void setTimeSinceGPSEpoch(Object timeSinceGPSEpoch) {
        this.timeSinceGPSEpoch = timeSinceGPSEpoch;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public int getLoRaSNR() {
        return loRaSNR;
    }

    public void setLoRaSNR(int loRaSNR) {
        this.loRaSNR = loRaSNR;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getRfChain() {
        return rfChain;
    }

    public void setRfChain(int rfChain) {
        this.rfChain = rfChain;
    }

    public int getBoard() {
        return board;
    }

    public void setBoard(int board) {
        this.board = board;
    }

    public int getAntenna() {
        return antenna;
    }

    public void setAntenna(int antenna) {
        this.antenna = antenna;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getFineTimestampType() {
        return fineTimestampType;
    }

    public void setFineTimestampType(String fineTimestampType) {
        this.fineTimestampType = fineTimestampType;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getUplinkID() {
        return uplinkID;
    }

    public void setUplinkID(String uplinkID) {
        this.uplinkID = uplinkID;
    }
}
