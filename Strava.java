import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
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
    private ArrayList<Equipment> equipment;

    private int idAthletes=0;
    private Athlete athlete;
    private final Scanner scan =new Scanner(System.in);
    public Strava()
    {
        athletes = new HashMap<>();
        accounts = new HashMap<>();
    }

    public void startStrava(){
        clearTerminal();
        mainMenu();
    }
    
    private void listAllAthletes()
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
        mainMenu();
    }

    private int giveId(){
        idAthletes++;    
        return idAthletes;    
    }

    private void mainMenu(){
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
            scan.nextLine();
        if (menu == 1){
                clearTerminal();
                newAthleteStrava();
            } else if (menu == 2) {
                clearTerminal();
                Choice();
            } else if (menu == 3) {
                clearTerminal();
                logIn();
            } else if (menu == 4) {
                clearTerminal();
                getDetailsMenu();
            } else if (menu == 5) {
                System.out.println("Thank you for using our service.");

            } else {
                System.out.println("Invalid input");
            }

    }
    
    private void newAthleteStrava(){

       System.out.println("Enter athlete's name:");
       String name = scan.nextLine();
       
       System.out.println("Enter athlete's gender(MALE,FEMALE,OTHER):");
       String genderInput = scan.nextLine().toUpperCase();
       Gender gender = Gender.valueOf(genderInput);

       System.out.print("Enter athlete's weight (kg): ");
       double weight = scan.nextDouble();
    
       System.out.print("Enter athlete's height (cm): ");
       double height = scan.nextDouble();

       System.out.print("Enter athlete's year of birth: ");
       int yearOfBirth = scan.nextInt();
       scan.nextLine();

       System.out.print("Set a password for the athlete: ");
       String password = scan.nextLine();
       clearTerminal();

       Athlete newAthlete = new Athlete(name, gender, weight, height, yearOfBirth);
       System.out.println("You just added an athlete " + newAthlete);

        
         int newId = giveId();
        athletes.put(newId, newAthlete);
        accounts.put(newAthlete, password);
        System.out.println("Athlete added with ID: " + newId);
        mainMenu();

    }


    private void newEquipmentStrava(){
        
    }
    
    private void logIn(){
    System.out.println("-------------------------------------------");
    boolean loggedIn = false;

    while (loggedIn==false) {
        System.out.print("Username: ");
        String username = scan.next(); 
        System.out.print("Password: ");
        String password = scan.next(); 
        clearTerminal();

        for (Athlete athlete : accounts.keySet()) {
            if (athlete.toString().trim().equals(username) && accounts.get(athlete).equals(password)) {
                System.out.println("Login successful! Welcome " + athlete.getName());
                loggedIn = true; 
                myAccount(athlete); 
                break; 
            }
        }

        if (loggedIn==false) {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
    }
    
    private void myAccount(Athlete athlete){
        boolean done=false;
        while (!done){
            System.out.println("-------------------------------------------");  
            System.out.println("                 MY ACCOUNT");   
            System.out.println("-------------------------------------------"); 
            System.out.println("[1] New activity");
            System.out.println("[2] List all my activities");
            System.out.println("[3] Calculate my total distance");
            System.out.println("[4] Calculate my burned calories");
            System.out.println("[5] My profile");
            System.out.println("[0] Close my session");
            int menu = scan.nextInt();
            scan.nextLine();
                if (menu == 1){
                    clearTerminal();
                    addActivity(athlete);                
                } else if (menu == 2) {
                    clearTerminal();
                    athlete.displayAllMyActivities();
                } else if (menu == 3) {
                    clearTerminal();
                    athlete.getTotalDistance();                
                } else if (menu == 4) {
                    clearTerminal();
                    athlete.getTotalCaloriesBurned();
                } else if (menu == 5) {
                   clearTerminal(); 
                   athlete.getAthleteInfo();
                } else if (menu == 0) {
                    done=true;   
                } else {
                    System.out.println("Invalid input");
                }
        }
        mainMenu();
    }  

    private void getDetailsMenu(){
        String choose = null;
        
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
              clearTerminal();  
              listAllAthletes();
            }
            else if(value == 2){
                System.out.println("Boys");
            }
            else if(value == 3){
                System.out.println("Boys");
            }
            else if(value == 4){
                System.out.println("Boys");
            }
            else if(value == 0){
                mainMenu();
                break;
            }
            else{
                System.out.println("Invalid input");
            }
            
        }

    }
    
    private void addActivity(Athlete athlete){

        System.out.println("Enter the distance of the activity (in km): ");
        double distance = scan.nextDouble();
        scan.nextLine(); 
    
        System.out.println("Enter a description for the activity: ");
        String description = scan.nextLine();
    
        System.out.println("Enter the modality (WALKING,RUNNING, CYCLING, SWIMMING): ");
        String modalityInput = scan.nextLine().toUpperCase();
        Modality modality = Modality.valueOf(modalityInput);
    
        System.out.println("Enter the duration of the activity (in minutes): ");
        double duration = scan.nextDouble();
        scan.nextLine(); 
    
        System.out.println("Are you using equipment for this activity? (yes/no): ");
        String equipmentChoice = scan.nextLine().trim().toLowerCase();
    
            if (equipmentChoice.equals("yes")) {
    
                System.out.println("Select equipment from the following list:");
                for (int i = 0; i < equipment.size(); i++) {
                    System.out.println("[" + (i + 1) + "] " + equipment.get(i).getDescription());
                }
        
                System.out.print("Enter the number of the equipment you want to use: ");
                int number = scan.nextInt();
                scan.nextLine();  
        
                if (number > 0 && number <= equipment.size()) {
                    Equipment selectedEquipment = equipment.get(number - 1);
                    
                    PowActivity powActivity = new PowActivity(distance, description, modality, duration);
                    powActivity.chooseEquipment(selectedEquipment);
                    System.out.println("New Powered Activity created with equipment: " + selectedEquipment.getDescription());
                } else {
                    System.out.println("Invalid equipment choice! Creating a regular activity instead...");
                    Activity activity = new Activity(distance, description, modality, duration);
                    athlete.getActivities().add(activity);
                    System.out.println("New regular Activity");
                }
            } else {
                Activity activity = new Activity(distance, description, modality, duration);
                athlete.getActivities().add(activity);
                System.out.println("New regular Activity created");
            }
    }
    
    private void clearTerminal(){
        System.out.print('\u000c');

    }

}
