package sit707_week5;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {

	@Test
	public void testStudentIdentity() {
		String studentId = "s223140522";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "yuheng wang";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	 private static WeatherController wController;
	    private static double[] hourlyTemperatures;
	    private static int nHours;
	    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


	    @BeforeClass
	    public static void setUpClass() {
	        // Initialize the controller once for all tests
	        wController = WeatherController.getInstance();

	        // Retrieve all hourly temperatures once and store them
	        nHours = wController.getTotalHours();
	        hourlyTemperatures = new double[nHours];
	        for (int i = 0; i < nHours; i++) {
	            hourlyTemperatures[i] = wController.getTemperatureForHour(i + 1);
	        }
	    }

	    @Test
	    public void testTemperatureMin() {
	        System.out.println("+++ testTemperatureMin +++");
	        System.out.println("+++ testTemperatureMin +++ at " + sdf.format(new Date()));

	        double minTemperature = Double.MAX_VALUE;
	        for (double temp : hourlyTemperatures) {
	            if (minTemperature > temp) {
	                minTemperature = temp;
	            }
	        }

	        // Should be equal to the min value that is cached in the controller.
	        Assert.assertEquals("The calculated minimum temperature should match the cached minimum", minTemperature, wController.getTemperatureMinFromCache(), 0.001);
	    }

	    @Test
	    public void testTemperatureMax() {
	        System.out.println("+++ testTemperatureMax +++");
	        System.out.println("+++ testTemperatureMax +++ at " + sdf.format(new Date()));

	        double maxTemperature = Double.MIN_VALUE;
	        for (double temp : hourlyTemperatures) {
	            if (maxTemperature < temp) {
	                maxTemperature = temp;
	            }
	        }

	        // Should be equal to the max value that is cached in the controller.
	        Assert.assertEquals("The calculated maximum temperature should match the cached maximum", maxTemperature, wController.getTemperatureMaxFromCache(), 0.001);
	    }

	    @Test
	    public void testTemperatureAverage() {
	        System.out.println("+++ testTemperatureAverage +++");
	        System.out.println("+++ testTemperatureAverage +++ at " + sdf.format(new Date()));

	        double sumTemp = 0;
	        for (double temp : hourlyTemperatures) {
	            sumTemp += temp;
	        }
	        double averageTemp = sumTemp / nHours;

	        // Should be equal to the average value that is cached in the controller.
	        Assert.assertEquals("The calculated average temperature should match the cached average", averageTemp, wController.getTemperatureAverageFromCache(), 0.001);
	    }

//	@Test
//	public void testTemperatureMin() {
//		System.out.println("+++ testTemperatureMin +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		// Retrieve all the hours temperatures recorded as for today
//		int nHours = wController.getTotalHours();
//		double minTemperature = 1000;
//		for (int i=0; i<nHours; i++) {
//			// Hour range: 1 to nHours
//			double temperatureVal = wController.getTemperatureForHour(i+1); 
//			if (minTemperature > temperatureVal) {
//				minTemperature = temperatureVal;
//			}
//		}
//		
//		// Should be equal to the min value that is cached in the controller.
//		Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);
//		
//		// Shutdown controller
//		wController.close();		
//	}
//	
//	@Test
//	public void testTemperatureMax() {
//		System.out.println("+++ testTemperatureMax +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		// Retrieve all the hours temperatures recorded as for today
//		int nHours = wController.getTotalHours();
//		double maxTemperature = -1;
//		for (int i=0; i<nHours; i++) {
//			// Hour range: 1 to nHours
//			double temperatureVal = wController.getTemperatureForHour(i+1); 
//			if (maxTemperature < temperatureVal) {
//				maxTemperature = temperatureVal;
//			}
//		}
//		
//		// Should be equal to the min value that is cached in the controller.
//		Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
//		
//		// Shutdown controller
//		wController.close();
//	}
//
//	@Test
//	public void testTemperatureAverage() {
//		System.out.println("+++ testTemperatureAverage +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		// Retrieve all the hours temperatures recorded as for today
//		int nHours = wController.getTotalHours();
//		double sumTemp = 0;
//		for (int i=0; i<nHours; i++) {
//			// Hour range: 1 to nHours
//			double temperatureVal = wController.getTemperatureForHour(i+1); 
//			sumTemp += temperatureVal;
//		}
//		double averageTemp = sumTemp / nHours;
//		
//		// Should be equal to the min value that is cached in the controller.
//		Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemp);
//		
//		// Shutdown controller
//		wController.close();
//	}
//	
	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
	
	@AfterClass
     public static void tearDownClass() {
         System.out.println("Closing WeatherController at: " + sdf.format(new Date()));
         wController.close();
     }
}
