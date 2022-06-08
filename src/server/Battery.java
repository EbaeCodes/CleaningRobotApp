package server;

import java.io.Serializable;

import common.Observer;

public class Battery implements Observer, Serializable {
    private int batteryLevel;
    private int batteryDuration;

    public Battery() {

    }

    public Battery(int batteryLevel, int duration) {
	this.batteryLevel = batteryLevel;
	this.batteryDuration = duration;
    }

    public int getBatteryLevel() {
	return batteryLevel;
    }

    public int getBatteryDuration() {
	return batteryDuration;
    }

    public void setBatteryLevel(int batteryLevel) {
	this.batteryLevel = batteryLevel;
    }

    public void setBatteryDuration(int batteryDuration) {
	this.batteryDuration = batteryDuration;
    }

    @Override
    public void update(Map map, Battery battery, RobotLocation loc) {
	this.batteryDuration = battery.getBatteryDuration();
	this.batteryLevel = battery.getBatteryLevel();
	toString();

    }

    @Override
    public String toString() {
	return "Battery Level= " + batteryLevel + "%" + "\nBattery Duration= " + batteryDuration + "mins\n";
    }

}
