import java.util.Scanner;

/**
 * 
 * Represents a type of activity(powered activities) that requires equipment
 * Extends class of the Activity class
 * @author (Laura Valentina Trujillo Diaz , Danush Soosai and Keny-John Shamba)
 * @version (5/16/2025)
 */
public class PowActivity extends Activity
{
    private Equipment equipment;
    
    
    /**
     * Constructorof the PowActivity class
     * Inherits all parameters from the Activity class.
     */
    public PowActivity(double distance, String description, Modality modality, 
                           double duration) {
        super(distance, description, modality, duration);
    }
    
    /**
     * Sets the equipment used for this powered activity.
     */
    public void chooseEquipment(Equipment equipment){
        this.equipment = equipment;
        System.out.println("you chose a PoweredActivity");
    }
    /**
     * Returns the equipment used in this powered activity.
     *  @return the equipment object
     */
    public Equipment getEquipment(){
        return equipment;
    }
}
