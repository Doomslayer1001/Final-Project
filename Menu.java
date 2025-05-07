import java.util.Scanner;
/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Menu
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Menu
     */
    public Menu()
    {
        
        Scanner scan =new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scan.next();
        System.out.println("What is your last name?");
        String last_name = scan.next();
        Choice();
        //athletes.put(athlete.getId(),athlete.getName());   
    
    
    }
        private Equipment Choice(){
        Equipment bike = new Equipment("Bike", 1.5);
        Equipment skate = new Equipment("Skate",4.5);
        Equipment poll = new Equipment("Poll (depending on the weight of the person)", 0);
        Scanner scan =new Scanner(System.in);
        Equipment chosen = null;
        while(chosen == null){
        System.out.println("Choose an equipment");
        System.out.println("1. Bike");
        System.out.println("2. Skate");
        System.out.println("3. Poll");
        System.out.println("please choose an equipment");
        int value = scan.nextInt();
        if (value == 1 ){
            chosen = bike;
        }
        else if( value == 2){
            chosen = skate;
        }
        else if (value == 3){
            chosen = poll;
        }
        else
        {
            System.out.println("Invalid option try again");
        }
        
    }
    return chosen;
}
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
