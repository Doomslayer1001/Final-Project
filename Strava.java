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
    private Athlete athlete;
    private Scanner scan =new Scanner(System.in);
    public Strava()
    {
        athletes = new HashMap<>();
        accounts = new HashMap<>();
    }

    public void startStrava(){
        mainMenu();
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
        
        
        Equipment chosen = null;
        while(chosen == null){
            System.out.println("Choose an equipment");
            System.out.println("1. Bike");
            System.out.println("2. Skate");
            System.out.println("3. Poll");
            System.out.println("please choose an equipment");
            int value = scan.nextInt();
            scan.nextLine();
            if (value == 1 ){
                chosen = bike;
                System.out.println(bike);
                mainMenu();
                scan.close();
            }
            else if( value == 2){
                chosen = skate;
                System.out.println(skate);
                mainMenu();
                scan.close();
            }
            else if (value == 3){
                chosen = poll;
                System.out.println(poll);
                mainMenu();
                scan.close();
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
                Choice();
            } else if (menu == 3) {
                logIn();
                
            } else if (menu == 4) {
                getDetailsMenu();
            } else if (menu == 5) {
                System.out.println("Thank you for using our service.");
                
            } else {
                System.out.println("Invalid input");
            }
        
        
    }
    
    public void newAthleteStrava(){

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

       Athlete newAthlete = new Athlete(name, gender, weight, height, yearOfBirth);
       System.out.println("You just added an athlete " + newAthlete);

        
         int newId = giveId();
        athletes.put(newId, newAthlete);
        accounts.put(newAthlete, password);
        System.out.println("Athlete added with ID: " + newId);
        mainMenu();

    }


    public void newEquipmentStrava(){

            
    } 

    public void logIn(){
    System.out.println("-------------------------------------------");
    boolean loggedIn = false;

    while (loggedIn==false) {
        System.out.print("Username: ");
        String username = scan.next(); 
        System.out.print("Password: ");
        String password = scan.next(); 


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
    
    public void myAccount(Athlete athlete){
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
                athlete.addActivity();                
            } else if (menu == 2) {
                athlete.displayAllMyActivities();
            } else if (menu == 3) {
                athlete.getTotalDistance();
                
            } else if (menu == 4) {
                athlete.getTotalCaloriesBurned();
            } else if (menu == 5) {
               athlete.getAthleteInfo();
            } else if (menu == 0) {
                done=true;   
            } else {
                System.out.println("Invalid input");
            }
        }
        mainMenu();
    }  

    public void getDetailsMenu(){
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
    
    public void clearTerminal(){
                System.out.print('\u000c');

    }

}
