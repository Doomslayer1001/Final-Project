import java.util.ArrayList;

/**
 * Write a description of class Strava here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Strava
{
    private ArrayList<Athlete> athletes;
     
    public Strava()
    {
        athletes = new ArrayList<>();
    }
    
    public void addAthletes(Athlete athlete){
      athletes.add(athlete);  
    }
    
    public void listAllAthletes()
    {
        // display all athletes
        for(Athlete athlete : athletes) {
            System.out.println("Found athletes are: ");          
            System.out.println(athlete);   // empty line between posts
        }
    }
    
    private void Choice(){
        Equipment bike = new Equipment("Bike", 1.5);
        Equipment skate = new Equipment("Skate",4.5);
        Equipment poll = new Equipment("Poll (depending on the weight of the person)", 0);
    }
    
}
