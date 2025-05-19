import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Strava class has the main methods to manage and show
 * different activities like running, walking, swimming, and cycling.
 * It helps record and work with fitness data from the user.
 *
 * @author Laura,Danush and Kenny-jhon
 * @version 1.0
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
        equipment = new ArrayList<>();
        
        Equipment bike = new Equipment("Bike", 1.5);
        equipment.add(bike);
        Equipment skate = new Equipment("Skate",4.5);  //equipment by default
        equipment.add(skate);
        Equipment poll = new Equipment("Poll (depending on the weight of the person)", 0);
        equipment.add(poll);
        Equipment shoes = new Equipment("Shoes" , 1.2);
        equipment.add(shoes);
        
        Athlete athlete1 = new Athlete("Alice", Gender.FEMALE, 60.5, 165.0, 2002);
        int id1 = giveId(); // from your method
        athletes.put(id1, athlete1);
        accounts.put(athlete1, "alice123");
        Athlete athlete2 = new Athlete("Ben", Gender.MALE, 75.0, 180.0, 1998);
        int id2 = giveId();
        athletes.put(id2, athlete2);
        accounts.put(athlete2, "ben123");
        Athlete athlete3 = new Athlete("Charlie", Gender.OTHER, 68.2, 172.5, 2000);
        int id3 = giveId();
        athletes.put(id3, athlete3);
        accounts.put(athlete3, "charlie123");
        
        athlete1.getActivities().add(new Activity(5.0, "Morning walk in the park", Modality.WALKING, 45));
        athlete1.getActivities().add(new Activity(2.5, "Short swim session", Modality.SWIMMING, 30));
        athlete1.getActivities().add(new Activity(8.0, "Weekend bike ride", Modality.BIKING, 60));
        athlete1.getActivities().add(new Activity(3.0, "Evening jog", Modality.RUNNING, 35));
        athlete1.getActivities().add(new Activity(10.0, "Charity run", Modality.RUNNING, 70)); 
        PowActivity alicePow1 = new PowActivity(4.0, "Running in the park", Modality.RUNNING, 30);
        alicePow1.chooseEquipment(shoes);
        athlete1.getActivities().add(alicePow1);
        
        PowActivity alicePow2 = new PowActivity(6.0, "Skating downtown", Modality.BIKING, 40);
        alicePow2.chooseEquipment(skate);
        athlete1.getActivities().add(alicePow2);
        
        athlete2.getActivities().add(new Activity(20.0, "Long cycling tour", Modality.BIKING, 90));
        athlete2.getActivities().add(new Activity(4.0, "Afternoon jog", Modality.RUNNING, 40));
        athlete2.getActivities().add(new Activity(1.0, "Pool laps", Modality.SWIMMING, 25));
        athlete2.getActivities().add(new Activity(6.0, "Brisk walk with dog", Modality.WALKING, 50));
        athlete2.getActivities().add(new Activity(7.5, "Run in the forest", Modality.RUNNING, 55));
        athlete2.getActivities().add(new Activity(3.2, "Light walk", Modality.WALKING, 30));
        PowActivity benPow1 = new PowActivity(18.0, "Mountain biking session", Modality.BIKING, 70);
        benPow1.chooseEquipment(bike);
        athlete2.getActivities().add(benPow1);

        athlete3.getActivities().add(new Activity(10.0, "City bike commute", Modality.BIKING, 40));
        athlete3.getActivities().add(new Activity(5.0, "Beach walk", Modality.WALKING, 60));
        athlete3.getActivities().add(new Activity(3.0, "Sprint practice", Modality.RUNNING, 25));
        athlete3.getActivities().add(new Activity(2.5, "Swim training", Modality.SWIMMING, 35));
        athlete3.getActivities().add(new Activity(12.0, "Biking uphill", Modality.BIKING, 70));
        athlete3.getActivities().add(new Activity(4.2, "Relaxed jog", Modality.RUNNING, 38));
        athlete3.getActivities().add(new Activity(2.0, "Warm-up walk", Modality.WALKING, 20));   
        PowActivity charliePow1 = new PowActivity(5.5, "Jogging with ski poles", Modality.RUNNING, 35);
        charliePow1.chooseEquipment(poll);
        athlete3.getActivities().add(charliePow1);
        
        PowActivity charliePow2 = new PowActivity(11.0, "City bike race", Modality.BIKING, 55);
        charliePow2.chooseEquipment(bike);
        athlete3.getActivities().add(charliePow2);
        
        System.out.println("Default athletes and equipment have been created, please close this terminal and call the startStrava method.");
    }
    
    /**
     * Main method that allows to run this project outside of bluejay
     */
    public static void main(String[] args){
        (new Strava()).startStrava();
    }
   
    /**
     * Starts the Strava app by clearing the screen and showing the main menu.
     */
    public void startStrava(){
        clearTerminal();
        mainMenu();
    }
    
    /**
     * Shows a list of all athletes added so far,
     * displaying their ID and name.
     */
    private void listAllAthletes()
    {
        System.out.println("Found athletes are: "); 
        // display all athletes
        for (Integer id: athletes.keySet()){
            System.out.println("Id: " +id + " Name: "+ athletes.get(id));
        }
    }
    
    /**
     * Creates and returns a new ID for a new athlete.
     * 
     * @return a unique ID number.
     */
    private int giveId(){
        idAthletes++;    
        return idAthletes;    
    }
    
    /**
     * Shows the menu and runs what the user picks,
     * like adding an athlete or logging in.
     */
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
                newEquipmentStrava();
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
    
    /**
     * Lets the user create a new athlete by entering name, gender,
     * weight, height, year of birth, and a password. Then saves the
     * athlete with a new ID.
     */
        private void newAthleteStrava(){

      System.out.println("Enter athlete's name:");
       String name = scan.nextLine();
     
       Gender gender = null;
       while(gender == null){
       
       System.out.println("Enter athlete's gender(MALE,FEMALE,OTHER):");
       String genderInput = scan.nextLine().toUpperCase();
       try{
       gender = Gender.valueOf(genderInput);
    } catch ( IllegalArgumentException e){
        System.out.println("Invalid gender.Please enter MALE,FEMALE, or OTHER.");
    }
    } 
       
       
       double weight = -1;
       while( weight <= 0){

       System.out.print("Enter athlete's weight (kg): ");
       weight = scan.nextDouble();
       
       if (weight <= 0){
           System.out.println("Weight must be a positive number. Please try again.");
       }
     }
    
       double height = -1;
       while( height <= 0){
       System.out.print("Enter athlete's height (cm): ");
        height = scan.nextDouble();
        
    
        if (weight <= 0){
            System.out.println("Height must be a positive number. Please try again.");
        }
        
        
     }

      int yearOfBirth = -1;
    int currentYear = 2025;
    while (yearOfBirth < 1900 || yearOfBirth > currentYear) {
        System.out.print("Enter athlete's year of birth: ");
        yearOfBirth = scan.nextInt();
        if (yearOfBirth < 1900 || yearOfBirth > currentYear) {
            System.out.println("Year of birth must be between 1900 and " + currentYear + ". Please try again.");
        }
     }       
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
    
    /**
     * Lets the user create a new athlete by entering name, gender,
     * weight, height, year of birth, and a password. Then saves the
     * athlete with a new ID.
     */
    private void newEquipmentStrava(){
        System.out.println("Enter the name of the equipment you would like to use");
        String name = scan.nextLine();
        
        System.out.println("Enter the equipment's weight");
        double weight = scan.nextDouble();
        
        Equipment newEquip = new Equipment(name,weight);
        equipment.add(newEquip);
        
        System.out.println("new equipement added: " + newEquip );
        mainMenu();
        clearTerminal();
    }
   
    /**
     * Lets a user log in by entering a username and password.
     * If correct, it opens their account menu.
     */
   private void logIn() {
    System.out.println("-------------------------------------------");
    boolean loggedIn = false;

    while (!loggedIn) {
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
                return; 
            }
        }

        
        System.out.println("Invalid username or password.");
        
        
        boolean validChoice = false;
        while (!validChoice) {
            System.out.println("Would you like to try again or return to the main menu?");
            System.out.println("[1] Try again");
            System.out.println("[2] Return to main menu");
            System.out.print("Enter your choice between 1 or 2: ");
            int choice = scan.nextInt();
            scan.nextLine(); 

            if (choice == 1) {
                validChoice = true; 
            } else if (choice == 2) {
                clearTerminal();
                mainMenu(); 
                return; 
            } else {
                System.out.println("This not a valid choice. Please enter 1 or 2."); 
            }
        }
    }
    }

    /**
     * Shows options for the logged-in athlete like adding activities,
     * seeing total distance, calories, or profile.
     *
     * @param athlete the logged-in user
     */
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
                    double tDistance=athlete.getTotalDistance();  
                    System.out.println("My total distance: "+tDistance+" km");
                } else if (menu == 4) {
                    clearTerminal();
                    double tCalories= athlete.getTotalCaloriesBurned();
                     System.out.println("My total of burned calories: "+tCalories);
                } else if (menu == 5) {
                   clearTerminal(); 
                   athlete.getAthleteInfo();
                } else if (menu == 0) {
                    done=true;   
                } else {
                    System.out.println("Invalid input");
                }
        }
        clearTerminal();
        mainMenu();
    }  

    /**
     * Shows a menu to list details like all athletes, activities,
     * or equipment.
     */
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
            System.out.println("[5] List all equipment");
            System.out.println("[0] Back");
            
            int value = scan.nextInt();
            if(value == 1){
              clearTerminal();  
              listAllAthletes();
            }
            else if(value == 2){
                clearTerminal();
                allActivity();
            }
            else if(value == 3){
                clearTerminal();
                listActivityAthlete();
            }
            else if(value == 4){
               clearTerminal();
               listActiviyModality();
            }
            
            else if(value == 0){
                clearTerminal();
                mainMenu();
                break;
            }
            else if(value ==5){
                clearTerminal();
                ListEquipment();
            }
            else{
                System.out.println("Invalid input");
            }
        }
    }
    
    /**
     * Adds a new activity for the given athlete. 
     * The user can enter details like distance, time, and equipment.
     *
     * @param athlete the user who is doing the activity
     */
    private void addActivity(Athlete athlete){

        double distance = -1;
        while( distance <= 0){
        System.out.println("Enter the distance of the activity (in km): ");
        
        distance = scan.nextDouble(); 
        if (distance <= 0){
           System.out.println("Distance must be a positive number. Please try again.");
       }
    }
    
        scan.nextLine();
        System.out.println("Enter a description for the activity: ");
        String description = scan.nextLine();
    
        
        Modality modality= null;
        while(modality == null){
        System.out.println("Enter the modality (WALKING,RUNNING, CYCLING, SWIMMING): ");
        String modalityInput = scan.nextLine().toUpperCase();
        
        try{
         modality = Modality.valueOf(modalityInput);
    }
    catch( IllegalArgumentException e){
    System.out.println("Invalid modality.Please enter WALKING,RUNNING, CYCLING,or SWIMMING.");
    }
    }
        
          double duration = -1;
          while ( duration <= 0){
         System.out.println("Enter the duration of the activity (in minutes): ");
         duration = scan.nextDouble();
         
         if (distance <= 0){
             System.out.println("Duration must be a positive number. Please try again.");
         }
         
    }
        scan.nextLine();
    
     System.out.println("Are you using equipment for this activity? (yes/no): ");
String equipmentChoice = scan.nextLine().trim().toLowerCase();


while (!equipmentChoice.equals("yes") && !equipmentChoice.equals("no")) {
    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
    equipmentChoice = scan.nextLine().trim().toLowerCase();
}

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
        athlete.getActivities().add(powActivity);
        clearTerminal();
        System.out.println("New Powered Activity created with equipment: " + selectedEquipment.getDescription());
    } else {
        System.out.println("Invalid equipment choice! Creating a regular activity instead...");
        Activity activity = new Activity(distance, description, modality, duration);
        athlete.getActivities().add(activity);
        clearTerminal();
        System.out.println("New regular Activity created");
    }
} else {
    Activity activity = new Activity(distance, description, modality, duration);
    athlete.getActivities().add(activity);
    clearTerminal();
    System.out.println("New regular Activity created");
}

    }
    
    /**
     * Shows a list of all equipment that has been added.
     */
    private void ListEquipment(){
       System.out.println("List of all equipment"); 
       if(equipment.isEmpty()){
         System.out.println("no available equiment");
       }
       else{
           for(Equipment eq : equipment){
               System.out.println(eq);
           }
       }
    }
    
    /**
     * Shows all activities from all athletes.
     */
    private void allActivity(){
        System.out.println("List of all activity");
        for(Athlete athlete : athletes.values()){
            System.out.println("Athlete: " + athlete.getName());
            athlete.displayAllMyActivities(); 
            System.out.println();
        }
    }
    
    /**
     * Shows all activities for a given athlete by name.
     */
    private void listActivityAthlete(){
        scan.nextLine();
        
        System.out.println("Enter athlete name: ");
        String name = scan.nextLine().trim();
        
        boolean found = false;
        
        for(Integer id : athletes.keySet()){
            Athlete athlete = athletes.get(id);
            if(athlete.getName().equalsIgnoreCase(name)){
                System.out.println("Activity for: " + athlete.getName());
                athlete.displayAllMyActivities(); 
                found = true;
                break;
            }
        }
        if(!found){
                System.out.println("Athlete not found.");
            }
    }
    
    /**
     * Shows all activities of a certain type (like RUNNING or SWIMMING).
     */
    private void listActiviyModality(){
        scan.nextLine();
        
        System.out.println("Enter modality(WALKING,RUNNING,CYCLING,SWIMMING): ");
        String modalityInput = scan.nextLine().trim().toUpperCase();
        Modality chosenModality= null;
        for (Modality m : Modality.values()) {
        if (m.name().equalsIgnoreCase(modalityInput)) {
            chosenModality = m;
            break;
        }
        }
        
        if(chosenModality == null){
            System.out.println("Invalid modality entered");
            return;
        }
        
        boolean found = false;
        
        for(Integer id : athletes.keySet()){
            Athlete athlete = athletes.get(id);
            for (Activity activity : athlete.getActivities()){
                if (activity.getModality() == chosenModality){
                    if(!found){
                        System.out.println("Activities with modality: " + chosenModality);
                        found = true;
                    }
                    System.out.println("Athlete: " + athlete.getName() + "_" + activity);
                }
            }
        }
        if(!found){
            System.out.println("No activities found for modality: " + modalityInput);
        }
    }
    
    /**
     * Clears the terminal screen.
     */
    private void clearTerminal(){
        System.out.print('\u000c');

    }

}
