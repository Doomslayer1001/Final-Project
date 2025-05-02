
/**
 * Write a description of class Equipment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Equipment
{
    private String name;
    private double weight;
    
    public Equipment(String name, double weight)
    {
        this.name = name;

        this.weight = weight;
        

    }
    
       public String  getDescription() {
        return name + ": " + " (Weight: " + weight + "kg)";
    }

}
