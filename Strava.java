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
    private HashMap<Integer,String> athletes;
    private int idAthletes=0;
    private Athlete athlete;
    public Strava()
    {
        athletes = new HashMap<>();
    }
    
    public void addAthletes(){
        mainMenu();
        //athletes.put(athlete.getId(),athlete.getName());   
    }
    
    public void listAllAthletes()
    {
        System.out.println("Found athletes are: "); 
        // display all athletes
        for (Integer id: athletes.keySet()){
            System.out.println("Id: " +id + " Name: "+ athletes.get(id));
        }
    }
    
       private void Choice()
    {
        Equipment bike = new Equipment("Bike", 1.5);
        Equipment skate = new Equipment("Skate",4.5);
        Equipment poll = new Equipment("Poll (depending on the weight of the person)", 0);
        
        Scanner scan = new Scanner(System.in);
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
                System.out.println(bike);
            }
            else if( value == 2){
                chosen = skate;
                System.out.println(skate);
            }
            else if (value == 3){
                chosen = poll;
                System.out.println(poll);
            }
            else{
                System.out.println("Invalid option try again");
            }        
        }
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
        System.out.println("[1] New athlete");
        System.out.println("[2] New Equipment");
        System.out.println("[3] Access to your account");
        System.out.println("[4] Get details ");
        System.out.println("[5] Quit");
        int menu = scan.nextInt();
        if (menu == 1){
            newAthleteStrava();
        }
        else if (menu == 2){
            Choice();
        }
        else if (menu == 3){
            System.out.println("hello");
        }
        else if (menu == 4){
            getDetailsMenu();
        }
    }
    
    public void newAthleteStrava(){
       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter athlete's name:");
       String name = scanner.nextLine();
       
       System.out.println("Enter athlete's gender(MALE,FEMALE,OTHER):");
       
      
    }
    
    public void getDetailsMenu(){
        String choose = null;
        Scanner scan =new Scanner(System.in);
        while (choose == null){
            System.out.println("-------------------------------------------");  
            System.out.println("                   MENU");   
            System.out.println("-------------------------------------------");
            System.out.println("Choose among these options what to execute:"); System.out.println("");  
            System.out.println("[1] List all athletes");
            System.out.println("[2] List all activities");
            System.out.println("[3] List all activities by athlete");
            System.out.println("[4] List all activities by mode");
            System.out.println("[0] Back");
            
            int value = scan.nextInt();
            if(value == 1){
            System.out.println("Boys");
            }
            else if(value == 0){
                mainMenu();
            }
        }
    }
    
    

}
