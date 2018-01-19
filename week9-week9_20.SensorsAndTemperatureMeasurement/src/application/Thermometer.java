package application;

import java.util.Random;

public class Thermometer implements Sensor {

    private boolean status;

    public Thermometer() {
        this.status = false;
    }

    @Override
    public boolean isOn() {
        return status;
    }

    @Override
    public void on() {
        this.status = true;
    }

    @Override
    public void off() {
        this.status = false;
    }

    @Override
    public int measure() {
        if (!this.isOn()) {
            throw new IllegalStateException("Thermometer is off");
        } else {
            Random randomNumber = new Random();
            return randomNumber.nextInt(60 + 1) - 30;
        }
    }
}
