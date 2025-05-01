import java.util.ArrayList;
/**
 * Write a description of class PowActivities here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PowActivity extends Activity
{
    
    ArrayList<Equipment> equip;
    public PowActivity(String name, double distance, String description, Modality modality, 
                           double duration) {
        super(name, distance, description, modality, duration);
        equip = new ArrayList<>();
    }
    
    public void addEquipment(Equipment equip){
        this.equip.add(equip);
    
    }
}
