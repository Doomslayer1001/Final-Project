import java.util.ArrayList;

/**
 * Write a description of class Athlete here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Athlete
{
    private String name;               // Name of the athlete
    private Gender gender;             // Gender of the athlete
    private ArrayList<Activity> activities;  // List of activities the athlete has performed
    private double weight;             // Athlete's weight (used for calorie calculations)
    private int dateOfBirth; 

    public Athlete(String name, Gender gender, double weight, int dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.dateOfBirth = dateOfBirth;
        this.activities = new ArrayList<>();
    }
    
    public String getName(){
     return this.name;
    }
    

}
