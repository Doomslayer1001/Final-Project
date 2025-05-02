import java.util.ArrayList;

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

    private ArrayList<String> activities;

    public Activity(String name, double distance, String description, Modality modality, double duration) {
        this.name = name;
        this.distance = distance;
        this.description = description;
        this.modality = modality;

        this.duration = duration;   
        
    }
    
    private void Equipment(){
        Equipment bike = new Equipment("Bike", 1.5);
        Equipment skate = new Equipment("Skate",4.5);
        Equipment poll = new Equipment("Poll (depending on the weight of the person)", 0);

        this.duration = duration;
        ArrayList<String> activities = new ArrayList<String>();
        activities.add("hiking");
        activities.add("swimming");
        activities.add("cycling");
        activities.add("skating");
        activities.add("race walking");
        activities.add("sprints");
        activities.add("pole vault");
        

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
