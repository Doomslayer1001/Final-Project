
/**
 * Write a description of class PowActivities here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PowActivity extends Activity
{
    private Equipment equipment;
    public PowActivity(String name, double distance, String description, Modality modality, 
                           double duration, Equipment equipment) {
        super(name, distance, description, modality, duration);
        this.equipment = equipment;
    }
}
