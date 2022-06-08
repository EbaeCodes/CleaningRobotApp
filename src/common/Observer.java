package common;

import server.Battery;
import server.Map;
import server.RobotLocation;

public interface Observer {
    public void update(Map map, Battery battery, RobotLocation loc);

}
