package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private List<Sensor> sensorList;
    private List<Integer> readings;

    public AverageSensor() {
        sensorList = new ArrayList<>();
        readings = new ArrayList<>();
    }

    public void addSensor(Sensor additional) {
        sensorList.add(additional);
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : sensorList) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void on() {
        for (Sensor sensor : sensorList) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor : sensorList) {
            sensor.off();
        }
    }

    @Override
    public int measure() {
        if (!this.isOn() || this.sensorList.isEmpty()) {
            throw new IllegalStateException("Thermometers are not on or there are no sensors.");
        } else {
            int sum = 0;
            int average;

            for (Sensor sensor : sensorList) {
                sum += sensor.measure();
            }
            average = sum / sensorList.size();
            this.readings.add(average);
            return average;
        }
    }

    public List<Integer> readings() {
        return this.readings;
    }
}
