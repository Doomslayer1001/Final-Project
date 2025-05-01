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

}
