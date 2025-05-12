import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Write a description of class Athlete here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
    
    public Athlete(String name, Gender gender, double weight,double height, int yearOfBirth) {
        
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.yearOfBirth = yearOfBirth;
        this.activities = new ArrayList<>();

    }
    
    public String getName(){
     return this.name;
    }
    
    public double getWeight(){
        return this.weight;
     }
    
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
    
    public double getTotalDistance() {
        double totalDistance = 0;
        for (Activity activity : activities) {
            totalDistance += activity.getDistance();
        }
        return totalDistance;
    }
    
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
    
    public double calculateCaloriesBurned(Activity activity) {
        double MET = getMetValue(activity.getModality());  
        double duration = activity.getDuration();  
        double weight = this.weight;  
        return (duration * MET * 3.5 * weight) / 200; //formula to get burned calories
    }
    
    public double getTotalCaloriesBurned() {
        double totalCalories = 0;   
        // Loop through all activities of the athlete and adding em up
        for (Activity activity : activities) {
            totalCalories += calculateCaloriesBurned(activity);
        }
        return totalCalories;
    }
    
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
    
    public ArrayList<Activity> getActivities() {
        return activities;
    }
}
