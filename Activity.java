import java.util.ArrayList;

/**
 * Represents a physical activity performed by an athlete.
 * Stores the distance, duration, description, and the type of activity (modality).
 * @author (Laura Valentina Trujillo Diaz , Danush Soosai and Keny-John Shamba)
 * @version (5/16/2025)
 */
public class Activity
{
     
    private double distance;           // Distance of the activity 
    private String description;        // Description of the activity
    private Modality modality;         
    private double duration;  

    private Athlete athlete;
    private ArrayList<String> activities;
    
    /**
     * Constructor of the Activity class 
     */
    public Activity(double distance, String description, Modality modality, double duration) {
        
        this.distance = distance;
        this.description = description;
        this.modality = modality;

        this.duration = duration;   

    }
    
    

    /**
     * Returns a formatted string with all relevant activity information.
     */
    public String toString() {
        return "Description: " + description +
           ", Distance: " + distance + " km" +
           ", Duration: " + duration + " min" +
           ", Modality: " + modality.toString().toLowerCase();
    }
    
    /**
     * Gets the distance of the activity.
     */
    public double getDistance()

    {        
       return this.distance;
    }
    /**
     * Gets the duration of the activity.
     */
    public double getDuration()
    {
        return this.duration;
    }
    /**
     * Gets the description of the activity. 
     */
    public String getDescription()
    {
        return this.description;
    }
    /**
     * Gets the modality of the activity.
     */
    
    public Modality getModality()

    {       
      return this.modality;
    
    }
    
    /**
     * Show the total distance and athlete name associated with the activity
     * 
     */
    public void totalDistance () {
        String myStrg = "Activity: " + modality + " | Distance: " + distance + " km | Athlete: " + athlete.getName();
        System.out.println(myStrg.toString());
    }
}