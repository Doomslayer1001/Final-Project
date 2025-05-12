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

    private Athlete athlete;
    private ArrayList<String> activities;
    
    public Activity(double distance, String description, Modality modality, double duration) {
        
        this.distance = distance;
        this.description = description;
        this.modality = modality;

        this.duration = duration;   

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
    

    public void totalDistance () {
        String myStrg = "Activity: " + modality + " | Distance: " + distance + " km | Athlete: " + athlete.getName();
        System.out.println(myStrg.toString());
    }
}