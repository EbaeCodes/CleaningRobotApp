package server;

import java.io.Serializable;

import common.Observer;

public class Map implements Observer, Serializable {
    private Map map;
    private static Map instance = null;

    private Map() {
    }

    public static Map getInstance() {
	if (instance == null) {
	    instance = new Map();
	}
	return instance;
    }

    @Override
    public void update(Map map, Battery battery, RobotLocation loc) {
	this.map = map;
	System.out.println("The map of the area is updated");

    }

    public String getMap() {
	String map = "This is the map of the area";
	return map;
    }

    public void setMap(Map map) {
	this.map = map;
    }

}
