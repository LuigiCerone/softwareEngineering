package test;

import main.Controller.ControllerSignals;
import main.Model.DAO.RobotDAO;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;


public class ControllerSignalsTest {
    private  static final int SECS_TO_WAIT = 30;

    @Test
    public void main() {
        System.out.println("Testing mode.");

        insertTestingData();
    }

    @Test
    public void insertTestingData() {
        try {
            // new RobotDAO().delete("P3Z");
            // TODO Delete all signals too.

            String data = "{\"signal\": 1, \"timestamp\": \"2017-12-09 12:43:10\", " +
                    "\"cluster\": \"CZA\", \"zone\": \"U8I\", \"robot\": \"P3Z\", \"value\": 0}";

            Thread myThread = new Thread(new ControllerSignals(data));
            myThread.start();

            TimeUnit.SECONDS.sleep(SECS_TO_WAIT);

            data = "{\"signal\": 1, \"timestamp\": \"2017-12-09 12:43:40\", " +
                    "\"cluster\": \"CZA\", \"zone\": \"U8I\", \"robot\": \"P3Z\", \"value\": 1}";

            myThread = new Thread(new ControllerSignals(data));
            myThread.start();

            assertEquals(SECS_TO_WAIT, new RobotDAO().getDownTime("P3Z"));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
