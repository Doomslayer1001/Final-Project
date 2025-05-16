
/**
 * Represents a piece of equipment used during a powered activity.
 * Stores the equipment's name and weight.
 * Provides descriptive output for displaying equipment information
 * @author (Laura Valentina Trujillo Diaz , Danush Soosai and Keny-John Shamba)
 * @version (5/16/2025)
 */
public class Equipment
{
    private String name;
    private double weight;
    
    /**
     * Constructor of the Equipment class
     */
    public Equipment(String name, double weight)
    {
        this.name = name;
        this.weight = weight;
    }
    
     /**
      * Return a description of the equipment 
      * @return a string with the name and weight of the equipment.
      */
     public String  getDescription() {
        return name + ": " + " (Weight: " + weight + "kg)";
    }
    /**
     * Returns a string representation of the equipment.
     *
     * @return the description of the equipment
     */
    @Override
    public String toString(){
        return getDescription();
    }
}
