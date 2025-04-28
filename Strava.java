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
    /**
    public void show()
    {
        // display all posts
        for(Athlete athlethe : athletes) {
            
            System.out.println();   // empty line between posts
        }
    }
*/
}
