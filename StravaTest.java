

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

/**
 * The test class StravaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StravaTest
{
    private HashMap<Integer,Athlete> athletes;
    private HashMap<Athlete,String> accounts;
    private ArrayList<Equipment> equipment;

    private int idAthletes=0;
    private Athlete athlete;
    private final Scanner scan =new Scanner(System.in);
    /**
     * Default constructor for test class StravaTest
     */
    public StravaTest()
    {
        athletes = new HashMap<>();
        accounts = new HashMap<>();
        equipment = new ArrayList<>();
        
        Equipment bike = new Equipment("Bike", 1.5);
        equipment.add(bike);
        Equipment skate = new Equipment("Skate",4.5);  //equipment by default
        equipment.add(skate);
        Equipment poll = new Equipment("Poll (depending on the weight of the person)", 0);
        equipment.add(poll);
    }


    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUpTestTotalCaloriesCalculation()
    
    {
        Athlete athlete = new Athlete("Anna", Gender.FEMALE, 60.0, 165.0, 1990);
        Activity activity = new Activity(5.0, "Morning run", Modality.RUNNING, 30);
        athlete.getActivities().add(activity);

        double calories = athlete.getTotalCaloriesBurned();
        assertTrue(calories > 0); 
    }

    public void testTotalDistance(){
        Athlete athlete = new Athlete("Kenny",Gender.MALE, 70.0 , 85.5 , 2001);
        Activity run1 = new Activity(3.5, "Morning run", Modality.RUNNING, 25);
        Activity cycle1 = new Activity(10.0, "Evening biking", Modality.BIKING, 45);

        athlete.getActivities().add(run1);
        athlete.getActivities().add(cycle1);

        double expectedTotal = 13.5;
        assertEquals(expectedTotal, athlete.getTotalDistance(), 0.01);
    }

     
}


