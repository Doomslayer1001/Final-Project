import java.util.HashMap;

/**
 * Write a description of class Strava here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Strava
{
    private HashMap<Integer,String> athletes;
    private int idAthletes=0;
    public Strava()
    {
        athletes = new HashMap<>();
    }
    
    public void addAthletes(Athlete athlete){
     athletes.put(athlete.getId(),athlete.getName());   
    }
    
    public void listAllAthletes()
    {
        System.out.println("Found athletes are: "); 
        // display all athletes
        for (Integer id: athletes.keySet()){
            System.out.println("Id: " +id + " Name: "+ athletes.get(id));
        }
    }
    

    private void Choice(){
        Equipment bike = new Equipment("Bike", 1.5);
        Equipment skate = new Equipment("Skate",4.5);
        Equipment poll = new Equipment("Poll (depending on the weight of the person)", 0);
    }
    

    public int giveId(){
        idAthletes++;    
        return idAthletes;    
    }

}
