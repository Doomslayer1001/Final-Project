
/**
 * Write a description of class Activity here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Activity
{
    private String name;               // Name of the activity 
    private double distance;           // Distance of the activity 
    private String description;        // Description of the activity
    private Modality modality;         
    private double duration;  
    
    public Activity(String name, double distance, String description, Modality modality, double duration) {
        this.name = name;
        this.distance = distance;
        this.description = description;
        this.modality = modality;
        this.duration = duration;   
    }
    
    public String getName(){
     return this.name;
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
    
}
