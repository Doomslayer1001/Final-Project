import java.util.Scanner;

/**
 * Write a description of class PowActivities here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PowActivity extends Activity
{
    private Equipment equipment;
    
    public PowActivity(double distance, String description, Modality modality, 
                           double duration) {
        super(distance, description, modality, duration);
    }
    
    public void chooseEquipment(Equipment equipment){
        this.equipment = equipment;
        System.out.println("you choose a PowerActivity");
    }
    
    public Equipment getEquipment(){
        return equipment;
    }
}
