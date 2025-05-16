import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Respresents an Athlete who can perform various activities 
 *Stores personal information and tracks activity-related data such as distance and calories burned.
 * @author (Laura Valentina Trujillo Diaz , Danush Soosai and Keny-John Shamba)
 * @version (5/16/2025)
 * 
 * 
 */
public class Athlete
{
    private int id;
    private String name;               // Name of the athlete
    private Gender gender;             // Gender of the athlete
    private ArrayList<Activity> activities;  // List of activities the athlete has performed
    private double weight;// Athlete's weight (used for calorie calculations)
    private double height;
    private int yearOfBirth; 
    
    /**
     * Constructor of the Athlete class 
     */
    public Athlete(String name, Gender gender, double weight,double height, int yearOfBirth) {
        
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.yearOfBirth = yearOfBirth;
        this.activities = new ArrayList<>();

    }
   
    
    /**
     * Get the name of the athlete
     */
    public String getName(){
     return this.name;
    }
    
    /**
     * Get the weight of the Athlete
     */
    public double getWeight(){
        return this.weight;
     }
    
    /**
     *Displays all activities performed by the athlete, including descriptions and additional information if applicable.
     */
    public void displayAllMyActivities(){
    System.out.println("My activities are: ");
    for (Activity a : activities) {
  
        System.out.println(a.getDescription());
        System.out.println(a.getDistance());
        System.out.println(a.getDuration());
        Modality modality = a.getModality();
        System.out.println(modality.toString().toLowerCase());
        
        if (a instanceof PowActivity) { //check if a it is a powered activity
            PowActivity poweredActivity = (PowActivity) a; //casting, where we assign subtype to supertype  
            Equipment equipment = poweredActivity.getEquipment(); 
            System.out.println("Equipment used: " + equipment.getDescription()); 
            
        }
        System.out.println();
    }
    }
    
    /**
     * Get the total of the distance
     */
    public double getTotalDistance() {
        double totalDistance = 0;
        for (Activity activity : activities) {
            totalDistance += activity.getDistance();
        }
        return totalDistance;
    }
    
    /**
     * Returns the MET (Metabolic Equivalent of Task) value for a given modality.
     */  
    private double getMetValue(Modality modality) {
        switch (modality) {
            case RUNNING:
                return 9.8;  
            case BIKING:        //different MET values depending on the modality
                return 7.5;  
            case SWIMMING:
                return 6.7;  
            case WALKING:
                return 4.0; 
            default:
                return 3.5;
        }
    }
    /**
     *  Calculates the number of calories burned for a given activity based on the athlete's weight and activity duration.
     */
    public double calculateCaloriesBurned(Activity activity) {
        double MET = getMetValue(activity.getModality());  
        double duration = activity.getDuration();  
        double weight = this.weight;  
        return (duration * MET * 3.5 * weight) / 200; //formula to get burned calories
    }
    
    /**
     * Calculates the total number of calories burned by the athlete across all activities.
     * @return the total calories burned
     */
    public double getTotalCaloriesBurned() {
        double totalCalories = 0;   
        // Loop through all activities of the athlete and adding em up
        for (Activity activity : activities) {
            totalCalories += calculateCaloriesBurned(activity);
        }
        return totalCalories;
    }
    
    /**
     * Displays the personal information of the athlete
     */
    public void getAthleteInfo()
    {
        System.out.println("Name: "+ this.name);
        System.out.println("Gender: "+ this.gender.toString());
        System.out.println("Height: "+height+" Weight: "+weight);
        System.out.println("Year of birth: "+ yearOfBirth);
    }
    
        @Override
    public String toString() {
        return this.name;  
    }
    
    /**
     * Returns the list of activities performed by the athlete.
     * @return list of activities
     */
    public ArrayList<Activity> getActivities() {
        return activities;
    }

}
