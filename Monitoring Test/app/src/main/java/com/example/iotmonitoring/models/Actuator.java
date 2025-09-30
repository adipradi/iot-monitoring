package com.test.iotmonitor.models;

public class Actuator {
    private boolean pump;
    private boolean lamp;

    public Actuator() {
        // Diperlukan oleh Firebase
    }

    public Actuator(boolean pump, boolean lamp) {
        this.pump = pump;
        this.lamp = lamp;
    }

    public boolean isPump() {
        return pump;
    }

    public void setPump(boolean pump) {
        this.pump = pump;
    }

    public boolean isLamp() {
        return lamp;
    }

    public void setLamp(boolean lamp) {
        this.lamp = lamp;
    }
}
