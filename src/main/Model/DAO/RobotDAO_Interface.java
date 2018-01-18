package main.Model.DAO;

import main.Model.ReadData;
import main.Model.Robot;

import java.util.HashMap;
import java.util.List;

public interface RobotDAO_Interface {

    void insert(ReadData readData);

    public Robot get(int robotId);

    public Robot findRobotByIdOrInsert(ReadData readData);

    public void updateCountAndStartDown(Robot robot, ReadData readData);

    public void updateCountAndStopDown(Robot robot, ReadData readData, long downTimeDiff);

    public void updateCount(Robot robot);

    public long getDownTime(String robotId);

    public void delete(String p3Z);

    public List<Robot> getAllRobots();

    void updateIR(HashMap<String, Float> robotsIR);
}
