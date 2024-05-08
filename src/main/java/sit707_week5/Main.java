package sit707_week5;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Main entry of application.
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        WeatherController wController = WeatherController.getInstance();
        
        System.out.println("Temperature min: " + wController.getTemperatureMinFromCache());
        System.out.println("Temperature max: " + wController.getTemperatureMaxFromCache());
        System.out.println("Temperature avg: " + wController.getTemperatureAverageFromCache());
        System.out.println("Temperature at first hour: " + wController.getTemperatureForHour(1));
        
        Date nowDate = new Date();
        String persistTime = wController.persistTemperature(10, 23.2, nowDate);
        String now = new SimpleDateFormat("HH:mm:ss").format(nowDate);
        System.out.println("Persist time: " + persistTime + ", now: " + now);

        
        wController.close();
    }
}
