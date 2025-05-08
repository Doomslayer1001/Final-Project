import java.util.HashMap;
import java.util.Scanner;
/**
 * Write a description of class Strava here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Strava
{
    private HashMap<Integer,Athlete> athletes;
    private HashMap<Athlete,String> accounts;
    private int idAthletes=0;
    public Strava()
    {
        athletes = new HashMap<>();
    }
    
    public void startStrava(){
        Scanner scan =new Scanner(System.in);
       // mainMenu();
        logIn();
        String menuequipment = scan.next();
        Choice();  
    }
    
    public void listAllAthletes()
    {
        System.out.println("Found athletes are: "); 
        // display all athletes
        for (Integer id: athletes.keySet()){
            System.out.println("Id: " +id + " Name: "+ athletes.get(id));
        }
    }
    
       private Equipment Choice()
    {
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

    public int giveId(){
        idAthletes++;    
        return idAthletes;    
    }
    
    public void mainMenu(){
        Scanner scan =new Scanner(System.in);
        System.out.println("-------------------------------------------");  
        System.out.println("                   MENU");   
        System.out.println("-------------------------------------------");
        System.out.println("Choose among these options what to execute:"); System.out.println("");
        System.out.println("[a] New athlete");
        System.out.println("[b] New Equipment");
        System.out.println("[c] Access to your account");
        System.out.println("[d] Get details ");
        System.out.println("[e] Quit");
        String  menu = scan.next();
    }
    
    public void newAthleteStrava(){
            
    }
    
    public void newEquipmentStrava(){
        
    }
    
    public void logIn(){
        Scanner logInScanner =new Scanner(System.in);
        System.out.println("-------------------------------------------"); 
        System.out.print("Username: "); 
        String username = logInScanner.next(); 
        System.out.print("Password: "); 
        String password = logInScanner.next();
      
        while (username != null && password!= null){
            
        }
    }
    
    public void myAccount(){
        System.out.println("-------------------------------------------");  
        System.out.println("                 MY ACCOUNT");   
        System.out.println("-------------------------------------------"); 
        System.out.println("[1] New activity");
        System.out.println("[2] List all my activities");
        System.out.println("[3] Calculate my total distance");
        System.out.println("[4] Calculate my burned calories");
        System.out.println("[5] My profile");
        System.out.println("[0] Close my session");
    }
    
    public void getDetailsMenu(){
        System.out.println("-------------------------------------------");  
        System.out.println("                   MENU");   
        System.out.println("-------------------------------------------");
        System.out.println("Choose among these options what to execute:"); System.out.println("");  
        System.out.println("[1] List all athletes");
        System.out.println("[2] List all activities");
        System.out.println("[3] List all activities by athlete");
        System.out.println("[4] List all activities by mode");
        System.out.println("[0] Back");
        
    }
    
    

}
