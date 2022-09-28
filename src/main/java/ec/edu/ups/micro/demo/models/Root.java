package ec.edu.ups.micro.demo.models;

import java.util.ArrayList;

public class Root {

    private String applicationID;
    private String applicationName;
    private String deviceName;
    private String devEUI;
    private ArrayList<RxInfo> rxInfo;
    private TxInfo txInfo;
    private boolean adr;
    private int dr;
    private int fCnt;
    private String data;
    private String objectJSON;
    private Tags tags;

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDevEUI() {
        return devEUI;
    }

    public void setDevEUI(String devEUI) {
        this.devEUI = devEUI;
    }

    public ArrayList<RxInfo> getRxInfo() {
        return rxInfo;
    }

    public void setRxInfo(ArrayList<RxInfo> rxInfo) {
        this.rxInfo = rxInfo;
    }

    public TxInfo getTxInfo() {
        return txInfo;
    }

    public void setTxInfo(TxInfo txInfo) {
        this.txInfo = txInfo;
    }

    public boolean isAdr() {
        return adr;
    }

    public void setAdr(boolean adr) {
        this.adr = adr;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public int getfCnt() {
        return fCnt;
    }

    public void setfCnt(int fCnt) {
        this.fCnt = fCnt;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObjectJSON() {
        return objectJSON;
    }

    public void setObjectJSON(String objectJSON) {
        this.objectJSON = objectJSON;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }
}
