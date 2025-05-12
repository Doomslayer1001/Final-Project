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
    
    public void addActivity(Strava strava){

    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the distance of the activity (in km): ");
    double distance = scan.nextDouble();
    scan.nextLine(); // Consume the newline left by nextDouble()

    System.out.println("Enter a description for the activity: ");
    String description = scan.nextLine();

    System.out.println("Enter the modality (WALKING,RUNNING, CYCLING, SWIMMING): ");
    String modalityInput = scan.nextLine().toUpperCase();
    Modality modality = Modality.valueOf(modalityInput);

    System.out.println("Enter the duration of the activity (in minutes): ");
    double duration = scan.nextDouble();
    scan.nextLine(); // Consume the newline left by nextDouble()

    System.out.println("Are you using equipment for this activity? (yes/no): ");
    String equipmentChoice = scan.nextLine().trim().toLowerCase();

        if (equipmentChoice.equals("yes")) {
            ArrayList<Equipment> availableEquipment = strava.getEquipment();  //arraylist of equipment extracted from strava
    
            System.out.println("Select equipment from the following list:");
            for (int i = 0; i < availableEquipment.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + availableEquipment.get(i).getDescription());
            }
    
            System.out.print("Enter the number of the equipment you want to use: ");
            int number = scan.nextInt();
            scan.nextLine();  
    
            if (number > 0 && number <= availableEquipment.size()) {
                Equipment selectedEquipment = availableEquipment.get(number - 1);
                
                PowActivity powActivity = new PowActivity(distance, description, modality, duration);
                powActivity.chooseEquipment(selectedEquipment);
                System.out.println("New Powered Activity created with equipment: " + selectedEquipment.getDescription());
            } else {
                System.out.println("Invalid equipment choice! Creating a regular activity instead...");
                Activity activity = new Activity(distance, description, modality, duration);
                activities.add(activity);
                System.out.println("New regular Activity");
            }
        } else {
            Activity activity = new Activity(distance, description, modality, duration);
            activities.add(activity);
            System.out.println("New regular Activity created");
        }
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
