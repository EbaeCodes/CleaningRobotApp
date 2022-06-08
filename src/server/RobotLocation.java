package server;

import java.io.Serializable;

import common.Observer;

public class RobotLocation implements Observer, Serializable {
    private String name;
    private double longitude;
    private double latitude;

    public RobotLocation() {

    }

    public RobotLocation(String name, double latitude, double longitude) {
	this.name = name;
	this.latitude = latitude;
	this.longitude = longitude;
    }

    public double getLongitude() {
	return longitude;
    }

    public void setLongitude(double longitude) {
	this.longitude = longitude;
    }

    public double getLatitude() {
	return latitude;
    }

    public void setLatitude(double latitude) {
	this.latitude = latitude;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void getLocation() {
	RobotLocation robotloc = new RobotLocation(getName(), getLongitude(), getLatitude());
    }

    @Override
    public String toString() {
	return "Current Room = " + name + "\nPosition = " + longitude + "N," + latitude + "°W";
    }

    @Override
    public void update(Map map, Battery battery, RobotLocation loc) {
	this.latitude = loc.getLatitude();
	this.longitude = loc.getLongitude();
	toString();

    }

}
