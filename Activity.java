import java.util.ArrayList;

/**
 * Write a description of class Activity here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Activity
{
     
    private double distance;           // Distance of the activity 
    private String description;        // Description of the activity
    private Modality modality;         
    private double duration;  
    private double caloriesBurned; 

    private ArrayList<String> activities;

    public Activity(double distance, String description, Modality modality, double duration) {
        
        this.distance = distance;
        this.description = description;
        this.modality = modality;

        this.duration = duration;   
        this.caloriesBurned = calculateCaloriesBurned();
    }
    
    public double getDistance()

    {        
       return this.distance;
    }
    
    public double getDuration()
    {
        return this.duration;
    }
    
    public String getDescription()
    {
        return this.description;
    }
    
    
    public Modality getModality()

    {       
      return this.modality;
    
    }
    
     public double calculateCaloriesBurned() {
        double met = 0;

        switch (modality) {
            case RUNNING:
                met = 9.8;  
                break;
            case WALKING:
                met = 3.8;  
                break;
            case BIKING:
                met = 7.5;  
                break;
            default:
                met = 1.0;  
        }

        
        double weight = 75;  // Example weight in kg
        
        return (met * weight * 3.5 / 200) * duration;
    }
    
    public double getCaloriesBurned() {
        return caloriesBurned;
    }
}
