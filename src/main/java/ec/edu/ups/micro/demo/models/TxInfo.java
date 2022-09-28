package ec.edu.ups.micro.demo.models;

public class TxInfo {

    private int frequency;
    private String modulation;
    private LoRaModulationInfo loRaModulationInfo;

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getModulation() {
        return modulation;
    }

    public void setModulation(String modulation) {
        this.modulation = modulation;
    }

    public LoRaModulationInfo getLoRaModulationInfo() {
        return loRaModulationInfo;
    }

    public void setLoRaModulationInfo(LoRaModulationInfo loRaModulationInfo) {
        this.loRaModulationInfo = loRaModulationInfo;
    }
}
