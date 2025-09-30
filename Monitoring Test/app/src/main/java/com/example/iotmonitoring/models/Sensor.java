package com.test.iotmonitor.models;

public class Sensor {
    private String suhu;
    private String kelembaban;
    private String soil_moisture;
    private String ldr;

    public Sensor() {
        // Diperlukan oleh Firebase
    }

    public Sensor(String suhu, String kelembaban, String soil_moisture, String ldr) {
        this.suhu = suhu;
        this.kelembaban = kelembaban;
        this.soil_moisture = soil_moisture;
        this.ldr = ldr;
    }

    public String getSuhu() {
        return suhu;
    }

    public void setSuhu(String suhu) {
        this.suhu = suhu;
    }

    public String getKelembaban() {
        return kelembaban;
    }

    public void setKelembaban(String kelembaban) {
        this.kelembaban = kelembaban;
    }

    public String getSoil_moisture() {
        return soil_moisture;
    }

    public void setSoil_moisture(String soil_moisture) {
        this.soil_moisture = soil_moisture;
    }

    public String getLdr() {
        return ldr;
    }

    public void setLdr(String ldr) {
        this.ldr = ldr;
    }
}
