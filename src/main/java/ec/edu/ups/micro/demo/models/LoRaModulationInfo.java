package ec.edu.ups.micro.demo.models;

public class LoRaModulationInfo {

    private int bandwidth;
    private int spreadingFactor;
    private String codeRate;
    private boolean polarizationInversion;

    public int getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(int bandwidth) {
        this.bandwidth = bandwidth;
    }

    public int getSpreadingFactor() {
        return spreadingFactor;
    }

    public void setSpreadingFactor(int spreadingFactor) {
        this.spreadingFactor = spreadingFactor;
    }

    public String getCodeRate() {
        return codeRate;
    }

    public void setCodeRate(String codeRate) {
        this.codeRate = codeRate;
    }

    public boolean isPolarizationInversion() {
        return polarizationInversion;
    }

    public void setPolarizationInversion(boolean polarizationInversion) {
        this.polarizationInversion = polarizationInversion;
    }
}
