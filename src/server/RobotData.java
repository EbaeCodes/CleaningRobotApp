package server;

import java.util.ArrayList;

import common.IObservable;
import common.Observer;

public class RobotData implements IObservable {
    private Map map;
    private RobotLocation loc;
    private Battery battery;
    private ArrayList<Observer> observers;

    public RobotData(Battery battery, RobotLocation loc) {
	this.loc = loc;
	this.battery = battery;
	this.observers = new ArrayList<Observer>();

    }

    @Override
    public void removeObserver(Observer observer) {
	if (observers.contains(observer)) {
	    int index = observers.indexOf(observer);
	    observers.remove(index);
	}
    }

    @Override
    public void addObserver(Observer obs) {
	observers.add(obs);

    }

    @Override
    public void updateAllObservers() {
	for (Observer obs : observers) {
	    obs.update(map, battery, loc);
	}

    }

    public void BatteryUpdate() {
	updateAllObservers();
	this.battery.getBatteryDuration();
	this.battery.getBatteryLevel();

    }

    public void MapUpdate() {
	updateAllObservers();
    }

    public void RobotLocUpdate() {
	this.loc.getLatitude();
	this.loc.getLongitude();
	this.loc.getName();
	updateAllObservers();
    }

}
