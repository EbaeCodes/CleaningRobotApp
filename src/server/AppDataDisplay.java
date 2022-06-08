package server;

import common.Observer;

public class AppDataDisplay {
    private Observer battery;
    private Observer location;
    private Map map;
    private RobotData data;

    public AppDataDisplay(Battery battery, RobotLocation location) {
	this.data = new RobotData(battery, location);
	this.battery = battery;
	this.location = location;
	map.getInstance();

    }

    public void addObservers() {
	data.addObserver(battery);
	data.addObserver(location);
    }

    public void startMyAutoMode() {
	addObservers();
	data.updateAllObservers();
	// System.out.println(map.getMap());
	System.out.println("Robot Starts Cleaning in Auto mode: ");
	System.out.println(battery.toString());
	System.out.println(location.toString());

    }

    @Override
    public String toString() {
	return "\nRobot Battery Information: " + "\n" + battery + "\n" + "Robot Location Information: " + "\n"
		+ location;
    }

}
