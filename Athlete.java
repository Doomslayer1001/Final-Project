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
    
    public void addActivity(){

        Scanner scan = new Scanner(System.in);
        String answer;
        while(true){
            System.out.println("Would you like to choose an Equipment yes/no?");
            answer= scan.nextLine().trim().toLowerCase();
            if (answer.equals("yes")){
                
            }
        } 

        
   // Activity activity = new Activity(); 
    }
    
    public void displayAllMyActivities(){
        System.out.println("My activites are: ");
        for (Activity a:activities){    
          System.out.println(a);
        }
    }
    
    public double getTotalDistance() {
        double totalDistance = 0;
        for (Activity activity : activities) {
            totalDistance += activity.getDistance();
        }
        return totalDistance;
    }
    
       public double getTotalCaloriesBurned() {
        double totalCalories = 0;
        for (Activity activity : activities) {
            totalCalories += activity.getCaloriesBurned();
        }
        return totalCalories;
    }
    
    public void getAthleteInfo()
    {
        System.out.println("Name: "+ this.name);
        System.out.println("Gender: "+ this.gender.toString());
        System.out.println("Height: "+height+" Weight: "+weight);
        System.out.println("Year of birth: "+ yearOfBirth);
        System.out.println("My activities: "+activities);
    }
    
        @Override
    public String toString() {
        return this.name;  // Return the athlete's name for the comparison
    }
}
