import java.awt.Choice;

/**
 * Write a description of class PowActivities here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PowActivity extends Activity
{

    public PowActivity(String name, double distance, String description, Modality modality, 
                           double duration) {
        super(distance, description, modality, duration);
        Choice Equipment = new Choice();
    }
    
    public void chooseEquipment(){
        //Equipment.add("Please select");
        
        
    }
}
