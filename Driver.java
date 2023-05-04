import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
// main class that interacts with the user/ calls the necessary methods to set up the game
public class Driver {

    public static void endScreen(){
        System.out.println("");
        System.out.println("THANKS FOR PLAYING!");
    }
//method to make the map.txt file when called, as well as update the player's location
    public static void mapWriter(String userExitChoice){
        String fileName = "MAP.txt";
            FileOutputStream fileStream = null;
            try {
                fileStream = new FileOutputStream(fileName);
            }   
            catch (FileNotFoundException e) {
                System.out.println("Cannot find " + fileName);
            }
            PrintWriter outFS = new PrintWriter(fileStream);
            outFS.println("Your Location: " + userExitChoice);
            outFS.println("------------------------------------------");
            outFS.println("|  LOBBY  |                |             |");
            outFS.println("|                          |   POWER     |");
            outFS.println("|_   _____|    CARDIO         LIFTING    |");
            outFS.println("| LOCKER |      ROOM       |    ROOM     |");
            outFS.println("|  ROOM  |                 |             |");
            outFS.println("|________|___   ___________|________   __|");
            outFS.println("|  SMOO- |                      |        |");
            outFS.println("|  THIE  |        MACHINE       |  DINGY |");
            outFS.println("|   BAR            ROOM         | CLOSET |");
            outFS.println("|        |                               |");
            outFS.println("|        |                      |        |");
            outFS.println("------------------------------------------");
            outFS.close();
    }
// method to print/ carry out the intro scene
    public static void introScene(Scanner scnr) {
        char userInput = 'z';
        boolean valid = true;
        boolean haveNotEntered = true;
        System.out.println("One normal day in the City...");
        System.out.println("");
        System.out.println("Mordecai: Were almost there I think... are you sure this is a good idea? Just because you were too short for Eileen doesn't mean that you need to give into toxic societal standards for men.");
        System.out.println("");
        System.out.println("CHOOSE AN ACTION: ");
        System.out.println("a. Rigby: HM! HM! HM! I'll show her just how much of a high-value man I am!");
        System.out.println("b. Rigby: hey I'm not short! Your tape measure is screwed up!");
        while (valid) {
            userInput = scnr.next().charAt(0);
                if(userInput == 'a') {
                    System.out.println("");
                    System.out.println("Mordecai: Sure dude. You do that.");
                    valid = false;
                }  
                else if(userInput == 'b') {
                    System.out.println("");
                    System.out.println("Mordecai: Hey man don't insult my measure like that. Not cool.");
                    valid = false;
                }
                else {
                    System.out.println("");
                    System.out.println("Invalid input.");
                }
            }
            System.out.println("");
            
            valid = true;
            
                    System.out.println("*They walk up to a large, sprawling building near the edge of the city...*");
                    System.out.println("");
                    while (haveNotEntered) {
                        System.out.println("ACTIONS: "); 
                        System.out.println("a. Read Sign  b. Punch Mordecai c. Enter");
                        userInput = scnr.next().charAt(0);
                        if(userInput == 'a'){
                            System.out.println("");
                            System.out.println("The sign reads: SIGMALAND");
                            System.out.println("");
                            System.out.println("Make Another Choice: ");
                        }
                        else if (userInput == 'b'){
                            System.out.println("");
                            System.out.println("Mordecai: Ow.");
                            System.out.println("");
                            System.out.println("Make Another Choice: ");
                        }
                        else if(userInput == 'c') {
                            System.out.println("");
                            System.out.println("Rigby: Enough fooling around! Skips reccomended this place, and I'm not leaving until I'm YOLKED!");
                            System.out.println("");
                            haveNotEntered = false;
                        }
                        else {
                            System.out.println("");
                            System.out.println("Invalid input.");
                        }
                }
        }
// main mathod
public static void main(String[] args) {
    boolean wantsToPlayMore = true;
// initializing the necessary variables
    Scanner scnr = new Scanner(System.in);
    boolean validPlayChoice = true;
    boolean isPlaying = true;
    boolean validAction = true;
    String roomName = "";
    String exit = "";
    char userInput = 'z';
    String userInputString = "";
    boolean valid = true;
    String userExitChoice = "";
    HashMap<String, Room> map = new HashMap<String, Room> ();
    String interactableNameChoice = "";
    String interactableDialogueChoice = "";
    String characterDialogueChoice = "";
    String characterNameChoice = "";
    String validInput = "";
    boolean openedDoor = false;
    Room selectedExit = new Room();
    boolean natty = true;
    boolean validResponse = true;
    Room selectedHash = new Room();
// creating each room, assigning them a name and description, assigning and initializing them each their interactables, and adding them to a hashmap
    Room lobby = new Room();
    roomName = "Lobby";
    lobby.setRoomName(roomName);
    exit = "Cardio Room";
    lobby.setExits(exit);
    exit = "Locker Room";
    lobby.setExits(exit);
    Interactable proteinGumballMachine = new Interactable ();
    interactableNameChoice = "Protein Gumball Machine";
    proteinGumballMachine.setInteractableName(interactableNameChoice);
    interactableDialogueChoice = "A gumball machine filled with macro- friendly balls. Imagine if Benson saw this; that would be kinda messed up I think.";
    proteinGumballMachine.setinteractableDialogue(interactableDialogueChoice);
    lobby.setInteractables(proteinGumballMachine);
    Interactable scale = new Interactable ();
    interactableNameChoice = "Scale";
    scale.setInteractableName(interactableNameChoice);
    interactableDialogueChoice = "A high- tech scale to do your weigh- ins on. I won't use it cus I don't want to embarrass all these tiny scrubs.";
    scale.setinteractableDialogue(interactableDialogueChoice);
    lobby.setInteractables(scale);
    map.put(roomName, lobby);

    Room lockerRoom = new Room();
    roomName = "Locker Room";
    lockerRoom.setRoomName(roomName);
    exit = "Lobby";
    lockerRoom.setExits(exit);
    Interactable pictureMirror = new Interactable();
    interactableNameChoice = "Picture Mirror";
    pictureMirror.setInteractableName(interactableNameChoice);
    interactableDialogueChoice = "A mirror with adjustable light bulbs to take pump picks with. I wont take any so I don't embarrass these tiny scrubs.";
    pictureMirror.setinteractableDialogue(interactableDialogueChoice);
    lockerRoom.setInteractables(pictureMirror);
    Interactable bathroomStall = new Interactable();
    interactableNameChoice = "Bathroom Stall";
    bathroomStall.setInteractableName(interactableNameChoice);
    interactableDialogueChoice = "There's only one stall here? There must be somewhere else they're using their budget...";
    bathroomStall.setinteractableDialogue(interactableDialogueChoice);
    lockerRoom.setInteractables(bathroomStall);
     map.put(roomName, lockerRoom);

    Room cardioRoom = new Room();
    roomName = "Cardio Room";
    cardioRoom.setRoomName(roomName);
    exit = "Lobby";
    cardioRoom.setExits(exit);
    exit = "Power Lifting Room";
    cardioRoom.setExits(exit);
    exit = "Machine Room";
    cardioRoom.setExits(exit);
    Interactable treadmills = new Interactable();
    interactableNameChoice = "Treadmills";
    treadmills.setInteractableName(interactableNameChoice);
    interactableDialogueChoice = "A row of state-of-the-art treadmills. Too bad that noob don't know cardio kills your gains.";
    treadmills.setinteractableDialogue(interactableDialogueChoice);
    cardioRoom.setInteractables(treadmills);
     map.put(roomName, cardioRoom);

    Room powerLiftingRoom = new Room();
    roomName = "Power Lifting Room";
    powerLiftingRoom.setRoomName(roomName);
    exit = "Dingy Closet";
    powerLiftingRoom.setExits(exit);
    exit = "Cardio Room";
    powerLiftingRoom.setExits(exit);
    Interactable deadliftPlatform = new Interactable();
    interactableNameChoice = "Deadlift Platform";
    deadliftPlatform.setInteractableName(interactableNameChoice);
    interactableDialogueChoice = "A typical deadlift platform. The guy using it is trying to pull 500kgs with his back completely curved.";
    deadliftPlatform.setinteractableDialogue(interactableDialogueChoice);
    powerLiftingRoom.setInteractables(deadliftPlatform);
    Interactable squatRacks = new Interactable ();
    interactableNameChoice = "Squat Racks";
    squatRacks.setInteractableName(interactableNameChoice);
    interactableDialogueChoice = "A typical squat rack. I bet my max is somehwere around 700kgs, give or take one.";
    squatRacks.setinteractableDialogue(interactableDialogueChoice);
    powerLiftingRoom.setInteractables(squatRacks);
    Interactable hoodedFigure = new Interactable ();
    interactableNameChoice = "???";
    hoodedFigure.setInteractableName(interactableNameChoice);
    interactableDialogueChoice = "It doesn't usually feel like this... Something is wrong...";
    hoodedFigure.setinteractableDialogue(interactableDialogueChoice);
    powerLiftingRoom.setInteractables(hoodedFigure);
    map.put(roomName, powerLiftingRoom);

    Room machineRoom = new Room();
    roomName = "Machine Room";
    machineRoom.setRoomName(roomName);
    exit = "Smoothie Bar";
    machineRoom.setExits(exit);
    exit = "Cardio Room";
    machineRoom.setExits(exit);
    Interactable cableMachine = new Interactable ();
    interactableNameChoice = "Cable Machine";
    cableMachine.setInteractableName(interactableNameChoice);
    interactableDialogueChoice = "a typical cable machine with an assortment of attatchments. I don't know any excersizes using it so I bet it's not very important.";
    cableMachine.setinteractableDialogue(interactableDialogueChoice);
    machineRoom.setInteractables(cableMachine);
    Interactable legPress = new Interactable ();
    interactableNameChoice = "Leg Press";
    legPress.setInteractableName(interactableNameChoice);
    interactableDialogueChoice = "A typical leg press machine. That man is doing 16 plates with almost no ROM.";
    legPress.setinteractableDialogue(interactableDialogueChoice);
    machineRoom.setInteractables(legPress);
    map.put(roomName, machineRoom);

    Room smoothieBar = new Room();
    roomName = "Smoothie Bar";
    smoothieBar.setRoomName(roomName);
    exit = "Machine Room";
    smoothieBar.setExits(exit);
    Interactable shelf = new Interactable();
    interactableNameChoice = "Shelf";
    shelf.setInteractableName(interactableNameChoice);
    interactableDialogueChoice = "A shelf with an an assortment of supplements. Maybe I'll buy some Ashwaganda.";
    shelf.setinteractableDialogue(interactableDialogueChoice);
    smoothieBar.setInteractables(shelf);
     map.put(roomName, smoothieBar);

     Room dingyCloset = new Room();
     roomName = "Dingy Closet";
     dingyCloset.setRoomName(roomName);
     exit = "Power Lifting Room";
     dingyCloset.setExits(exit);
     Interactable needle = new Interactable();
     interactableNameChoice = "Needle";
     needle.setInteractableName(interactableNameChoice);
     interactableDialogueChoice = "The label is a little smudged, but I think it says TRENBOLYN.";
     needle.setinteractableDialogue(interactableDialogueChoice);
// creating each character, giving them each their respective name and description
     Characters brandon = new Characters();
     characterNameChoice = "Brandon";
     brandon.setCharacterName(characterNameChoice);
     characterDialogueChoice = "Hey dudes! Welcome to SigmaLand, where weak beta losers like you can become jacked and Sigma (for $79.99 a month.) Take this day pass to see if you can handle it first before getting a membership, because you can’t cancel it until you die or something."; 
     brandon.setCharacterDialogue(characterDialogueChoice);

    Characters creepyOldMan = new Characters();
    characterNameChoice = "Creepy Old Man";
    creepyOldMan.setCharacterName(characterNameChoice);
    characterDialogueChoice = "heya boys :)";
    creepyOldMan.setCharacterDialogue(characterDialogueChoice);

    Characters personOnAllFours = new Characters();
    characterNameChoice = "Four Runner";
    personOnAllFours.setCharacterName(characterNameChoice);
    characterDialogueChoice = "hrrmpf...mrrmph...";
    personOnAllFours.setCharacterDialogue(characterDialogueChoice);

    Characters deadlifter = new Characters();
    characterNameChoice = "Deadlifter";
    deadlifter.setCharacterName(characterNameChoice);
    characterDialogueChoice = "AAAAUUGHHHHHHHHHHHHHHH";
    deadlifter.setCharacterDialogue(characterDialogueChoice);

    Characters legPressPerson = new Characters();
    characterNameChoice = "Egolifter";
    legPressPerson.setCharacterName(characterNameChoice);
    characterDialogueChoice = "UMPH!! UMPH!! HMPH!!!";
    legPressPerson.setCharacterDialogue(characterDialogueChoice);

    Characters skips = new Characters ();
    characterNameChoice = "Skips";
    skips.setCharacterName(characterNameChoice);
    characterDialogueChoice = "...";
    skips.setCharacterDialogue(characterDialogueChoice);

    Characters nattilante = new Characters();
    characterNameChoice = "Nattilante";
    nattilante.setCharacterName(characterNameChoice);
    characterDialogueChoice = "Theres no use in trying to escape now! I'm afraid your fate is sealed. \n As for your friend, I wouldn't waste your energy trying to save him. He gets what he deserves for being a fake natty.";
    nattilante.setCharacterDialogue(characterDialogueChoice);
// game starts
    System.out.println("WELCOME TO: NATTYQUEST!");
    System.out.println("Would you like to begin your adventure?:");
    System.out.println("a.Yes  b.No");
    while (validPlayChoice) {
        char userIntroChoice = scnr.next().charAt(0);
        if (userIntroChoice != 'a' && userIntroChoice != 'b') {
            System.out.println("");
            System.out.println("Invalid Input.");
        }
        else if (userIntroChoice == 'b') {
            System.exit(0);
        }
        else if(userIntroChoice == 'a'){
            validPlayChoice = false;
        }
    }
    introScene(scnr);
    System.out.println("Room: Lobby");
    System.out.println("A typical gym lobby. It honestly looks like a Planet Fitness knockoff...");
    System.out.println("");
    System.out.println("CHOOSE ACTION: ");
    System.out.println("a. Talk to Brandon");
    System.out.println("b. Load Map");
    while (valid) {
        userInput = scnr.next().charAt(0);
        if (userInput != 'a' && userInput != 'b'){
            System.out.println("");
            System.out.println("Invalid Input.");
        }
        else if (userInput == 'a') {
            System.out.println("");
            System.out.println("Brandon: " + brandon.getCharacterDialogue());
            System.out.println("OBJECTIVE: Explore SIGMALAND!");
            System.out.println("");
            valid = false;
        }
        else {
            userExitChoice = "Lobby";
            mapWriter(userExitChoice);
            System.out.println("");
            System.out.println("CHOOSE ANOTHER ACTION: ");
        }
    }
    ArrayList <String> exitsTemp = new ArrayList <String> ();
    exitsTemp = lobby.getExits();
    System.out.println("Rigby: Sick! Let's go in!");
    System.out.println("");
    System.out.println("ACTIONS: ");
    for (int i=0; i < exitsTemp.size(); i ++) {
        System.out.println(" " + exitsTemp.get(i));
    }
    System.out.print(" TYPE CHOICE: ");
    scnr.nextLine();
    userExitChoice = scnr.nextLine();
    boolean userInputIsNotValid = true;
// large loop that keeps recieving the user's exit choices and printing out the approproate info given the input is valid and the game is not over
    while (isPlaying) {
        validAction = true;
    while (userInputIsNotValid) {
        if ((userExitChoice.equalsIgnoreCase("lobby")) || (userExitChoice.equalsIgnoreCase("locker room")) || (userExitChoice.equalsIgnoreCase("cardio room")) || (userExitChoice.equalsIgnoreCase("power lifting room")) || (userExitChoice.equalsIgnoreCase("machine room")) || (userExitChoice.equalsIgnoreCase("smoothie bar")) || (userExitChoice.equalsIgnoreCase("dingy closet"))) {
            validInput = userExitChoice;
            userInputIsNotValid = false;
        }
        else {
            System.out.println("");
            System.out.println("Invalid Exit.");
            System.out.print("TYPE CHOICE: ");
            userExitChoice = scnr.nextLine();
        }
    }
    userInputIsNotValid = true;
// if statement for entering the lobby
        if (validInput.equalsIgnoreCase("lobby")) {
            selectedHash = map.get("Lobby");
            selectedHash.printRoomInfo();
            exitsTemp = lobby.getExits();
            for (int i=0; i < exitsTemp.size(); i ++) {
                System.out.println(" " + exitsTemp.get(i));
            }
            System.out.println(" Map");
            System.out.print("TYPE CHOICE: ");
            while (validAction) {
                userInputString = scnr.nextLine();
                System.out.println("");
                if (userInputString.equalsIgnoreCase("protein gumball machine")) {
                    System.out.println("Rigby: " + proteinGumballMachine.getinteractableDialogue());
                    System.out.println("");
                    System.out.print("CHOOSE ANOTHER ACTION: ");
                }
                else if (userInputString.equalsIgnoreCase("cardio room")) {
                    userExitChoice = "Cardio Room";
                    validAction = false;
                }
                else if (userInputString.equalsIgnoreCase("locker room")) {
                    userExitChoice = "Locker Room";
                    validAction = false;
                }
                else if (userInputString.equalsIgnoreCase("scale")) {
                    System.out.println("Rigby: " + scale.getinteractableDialogue());
                    System.out.println("");
                    System.out.print("CHOOSE ANOTHER ACTION: ");
                }
                else if (userInputString.equalsIgnoreCase("map")) {
                    mapWriter(userExitChoice);
                    System.out.print("CHOOSE ANOTHER ACTION: ");
                }
                else {
                    System.out.println("Indavlid Input.");
                    System.out.print("TYPE A VALID CHOICE: ");
                }
            }
        }
// if statement for entering the locker room
        else if (validInput.equalsIgnoreCase("locker room")) {
             selectedHash = map.get("Locker Room");
            selectedHash.printRoomInfo();
            exitsTemp = lockerRoom.getExits();
            for (int i=0; i < exitsTemp.size(); i ++) {
                System.out.println(" " + exitsTemp.get(i));
            }
            System.out.println(" Map");
            System.out.print(" TYPE CHOICE: ");
            while (validAction) {
                userInputString = scnr.nextLine();
                if (userInputString.equalsIgnoreCase("picture mirror")) {
                    System.out.println("");
                    System.out.println("Rigby: " + pictureMirror.getinteractableDialogue());
                    System.out.println("");
                    System.out.println("Mordecai: Dude stop posing and look behind you. Who is that?");
                    System.out.println("");
                    System.out.println("Creepy Old Man: " + creepyOldMan.getCharacterDialogue());
                    System.out.println("");
                    System.out.println("Rigby: ...");
                    System.out.println("");
                    System.out.print("CHOOSE ANOTHER ACTION: ");
                }
                else if (userInputString.equalsIgnoreCase("lobby")) {
                    userExitChoice = "Lobby";
                    validAction = false;
                }
                else if (userInputString.equalsIgnoreCase("bathroom stall")) {
                    System.out.println("");
                    System.out.println("Mordecai: " + bathroomStall.getinteractableDialogue());
                    System.out.println("");
                    System.out.print(" CHOOSE ANOTHER ACTION: ");
                }
                else if (userInputString.equalsIgnoreCase("map")) {
                    mapWriter(userExitChoice);
                    System.out.print("CHOOSE ANOTHER ACTION: ");
                }
                else {
                    System.out.println("Indavlid Input.");
                    System.out.print("TYPE A VALID CHOICE: ");
                }
            }
        }
// if statement for entering the cardio room
        else if (validInput.equalsIgnoreCase("cardio room")) {
            selectedHash = map.get("Cardio Room");
            selectedHash.printRoomInfo();
            exitsTemp = cardioRoom.getExits();
            for (int i=0; i < exitsTemp.size(); i ++) {
                System.out.println(" " + exitsTemp.get(i));
            }
            System.out.println(" Map");
            System.out.print(" TYPE CHOICE: ");
            while (validAction) {
                userInputString = scnr.nextLine();
                if (userInputString.equalsIgnoreCase("treadmills")) {
                    System.out.println("");
                    System.out.println("Rigby: " + treadmills.getinteractableDialogue());
                    System.out.println("");
                    System.out.println("Runner: " + personOnAllFours.getCharacterDialogue());
                    System.out.println("");
                    System.out.println("Mordecai: I don't think people usually run on all fours like that. Maybe let's leave him alone");
                    System.out.println("");
                    System.out.print("CHOOSE ANOTHER ACTION: ");
                }
                else if (userInputString.equalsIgnoreCase("lobby")) {
                    userExitChoice = "Lobby";
                    validAction = false;
                }
                else if (userInputString.equalsIgnoreCase("machine room")) {
                    userExitChoice = "Machine Room";
                    validAction = false;
                }
                else if (userInputString.equalsIgnoreCase("power lifting room")){
                    userExitChoice = "Power Lifting Room";
                    validAction = false;
                }
                else if (userInputString.equalsIgnoreCase("map")) {
                    mapWriter(userExitChoice);
                    System.out.println("");
                    System.out.print("CHOOSE ANOTHER ACTION: ");
                }
                else {
                    System.out.println("");
                    System.out.println("Invalid Input.");
                    System.out.print("TYPE A VALID CHOICE: ");
                }
            }
        }
// if statement for entering the power lifting room
        else if (validInput.equalsIgnoreCase("power lifting room")) {
             selectedHash = map.get("Power Lifting Room");
            selectedHash.printRoomInfo();
            exitsTemp = powerLiftingRoom.getExits();
            for (int i=0; i < exitsTemp.size(); i ++) {
                System.out.println(" " + exitsTemp.get(i));
            }
            System.out.println(" Map");
            System.out.print(" TYPE CHOICE: ");
            while (validAction) {
                userInputString = scnr.nextLine();
                if (userInputString.equalsIgnoreCase("squat racks")) {
                    System.out.println("");
                    System.out.println("Rigby: " + squatRacks.getinteractableDialogue());
                    System.out.println("");
                    System.out.println("Mordecai: Dude your canonically like two feet tall.");
                    System.out.println("");
                    System.out.print("CHOOSE ANOTHER ACTION: ");
                }
                else if (userInputString.equalsIgnoreCase("dingy closet")) {
                    userExitChoice = "dingy closet";
                    validAction = false;
                }
                else if (userInputString.equalsIgnoreCase("cardio room")) {
                    userExitChoice = "cardio room";
                    validAction = false;
                }
                else if (userInputString.equalsIgnoreCase("deadlift platform")) {
                    System.out.println("");
                    System.out.println("Mordecai: " + deadliftPlatform.getinteractableDialogue());
                    System.out.println("");
                    System.out.println("Deadlifter: " + deadlifter.getCharacterDialogue());
                    System.out.println("");
                    System.out.println("Rigby: Nah you don't know what you're talking about. His form is great!");
                    System.out.println("");
                    System.out.print("CHOOSE ANOTHER ACTION: ");
                }
// important if statement that opens the dingycloset once ran
                else if (userInputString.equalsIgnoreCase("???")) {
                    System.out.println("");
                    System.out.println("???: " + hoodedFigure.getinteractableDialogue());
                    System.out.println("");
                    System.out.println("Rigby: Hey man, you good?");
                    System.out.println("");
                    System.out.println("Mordecai: Wait, dude- that's Skips!");
                    System.out.println("");
                    System.out.println("???: *looks over and skips away towards the Dingy Closet*");
                    openedDoor = true;
                    System.out.println("NEW OBJECTIVE: Follow SKIPS!");
                    System.out.println("");
                    System.out.print("CHOOSE ANOTHER ACTION: ");
                }
                else if (userInputString.equalsIgnoreCase("Map")){
                    mapWriter(userExitChoice);
                    System.out.println("");
                    System.out.print("CHOOSE ANOTHER ACTION: ");
                }
                else {
                    System.out.println("Indavlid input.");
                    System.out.print("TYPE A VALID CHOICE: ");
                }
            }
        }
// if statement for entering the machine room
        else if (validInput.equalsIgnoreCase("machine room")) {
             selectedHash = map.get("Machine Room");
            selectedHash.printRoomInfo();
            exitsTemp = machineRoom.getExits();
            for (int i=0; i < exitsTemp.size(); i ++) {
                System.out.println(" " + exitsTemp.get(i));
            }
            System.out.println(" Map");
            System.out.print(" TYPE CHOICE: ");
            while (validAction) {
                userInputString = scnr.nextLine();
                if (userInputString.equalsIgnoreCase("leg press")) {
                    System.out.println("");
                    System.out.println("Mordecai: " + legPress.getinteractableDialogue());
                    System.out.println("");
                    System.out.println("Leg Presser: " + legPressPerson.getCharacterDialogue());
                    System.out.println("");
                    System.out.print("CHOOSE ANOTHER ACTION: ");
                }
                else if (userInputString.equalsIgnoreCase("smoothie bar")) {
                    userExitChoice = "smoothie bar";
                    validAction = false;
                }
                else if (userInputString.equalsIgnoreCase("cardio room")) {
                    userExitChoice = "cardio room";
                    validAction = false;
                }
                else if (userInputString.equalsIgnoreCase("cable machine")) {
                    System.out.println("");
                    System.out.println("Rigby: " + cableMachine.getinteractableDialogue());
                    System.out.println("");
                    System.out.print("CHOOSE ANOTHER ACTION: ");
                }
                else if (userInputString.equalsIgnoreCase("map")) {
                    mapWriter(userExitChoice);
                    System.out.println("");
                    System.out.print("CHOOSE ANOTHER ACTION: ");
                }
                else {
                    System.out.println("Indavlid input.");
                    System.out.print("TYPE A VALID CHOICE: ");
                }
            }
        }
// if statement for entering the smoothie bar
        else if (validInput.equalsIgnoreCase("smoothie bar")) {
            selectedHash = map.get("Smoothie Bar");
            selectedHash.printRoomInfo();
            exitsTemp = smoothieBar.getExits();
            for (int i=0; i < exitsTemp.size(); i ++) {
                System.out.println(" " + exitsTemp.get(i));
            }
            System.out.println(" Map");
            System.out.print(" TYPE CHOICES: ");
            while (validAction) {
                userInputString = scnr.nextLine();
                if (userInputString.equalsIgnoreCase("shelf")) {
                    System.out.println("");
                    System.out.println("Rigby: " + shelf.getinteractableDialogue());
                    System.out.println("");
                    System.out.print("CHOOSE ANOTHER ACTION: ");
                }
                else if (userInputString.equalsIgnoreCase("machine room")) {
                    userExitChoice = "machine room";
                    validAction = false;
                }
                else if (userInputString.equalsIgnoreCase("map")) {
                    mapWriter(userExitChoice);
                    System.out.print("CHOOSE ANOTHER ACTION: ");
                }
                else {
                    System.out.println("Indavlid input.");
                    System.out.print("TYPE A VALID CHOICE: ");
                }
            }
        }
// if statement for entering the dingy closet
// final scene/ boss
        else if (validInput.equalsIgnoreCase("dingy closet")) {
            if (openedDoor) {
                System.out.println("");
                System.out.println("Rigby: What is that?");
                System.out.println("");
// the code forks here, where if you choose to take the steroid you get the bad ending, and vice versa
                System.out.println("ACTIONS:");
                System.out.println(" Needle");
                System.out.print(" TYPE CHOICE: ");
                userInputString = scnr.nextLine();
            if (userInputString.equalsIgnoreCase("needle")) {
                System.out.println("");
                System.out.println("Mordecai: " + needle.getinteractableDialogue());
                System.out.println("");
                System.out.println("Rigby: I don't like how Skips was acting... maybe I should take it. Just to be safe");
                System.out.println("");
                System.out.println("Use TRENBOLYN?: ");
                System.out.println("a. Yes");
                System.out.println("b. No");
                while (validAction) {
                char userNatty = scnr.next().charAt(0);
                    if (userNatty == 'a') {
                        System.out.println("");
                        System.out.println("Mordecai: This seems like such a bad idea man.");
                        System.out.println("");
                        System.out.println("Rigby: PSSHH! Being natty is for losers!");
                        natty = false;
                        validAction = false;
                    }
                    else if (userNatty == 'b') {
                        System.out.println("");
                        System.out.println("Rigby: I don't care what's behind this door, being natty is more important!");
                        natty = true;
                        validAction = false;
                    }
                    else {
                        System.out.println("");
                        System.out.println(" Invalid Input.");
                    }
                }
            }
            validAction = true;
               System.out.println("*The two enter the closet into a huge, dark room. A large glass screen covers the back wall. There seems to be a nefarious character on the other side...");
               System.out.println("");
               System.out.println("Mordecai: Bro, look! It's Skips!");
               System.out.println("");
               System.out.println("*In the corner of the room lies curled up in a ball Skips, muttering to himself*");
               System.out.println("");
               System.out.println("???: MWAHAHAHA!");
               System.out.println("");
               System.out.println("Ribgy: What was that? I wanna leave dude.");
               System.out.println("");
               System.out.println("ACTIONS:");
               System.out.println(" Power Lifting Room");
               System.out.print(" TYPE CHOICE: ");
               scnr.nextLine();
               String userCantLeave = scnr.nextLine();
               System.out.println("");
               System.out.println("Rigby: The door is locked...");
               System.out.println("");
               System.out.println("???: " + nattilante.getCharacterDialogue());
               System.out.println("");
               System.out.println("Mordecai: What? Skips would never lie about being natty?! Who even are you?");
               System.out.println("");
               System.out.println("Nattilante: I am the Nattilante, and I exist to protect this dimension from people who threaten the Natty Balance. \n You should thank me, your friend here almost broke the Space Time Nattinuum with his LIES.");
// this code runs if the user decided not to be natty
               if (!natty) {
                System.out.println("");
                System.out.println("*Wow, I dont feel so good. Everythings gettuing fuzzy...*");
                System.out.println("");
                System.out.println("Nattilante: How are you feeling, Rigby?");
                System.out.println("");
                System.out.println("ACTIONS: ");
                System.out.println("a. I'm feeling just fine, thanks for asking NattiLAMEte!");
                System.out.println("b. punch Mordecai");
                while (validAction) {
                    userInput = scnr.next().charAt(0);
                    if (userInput == 'a') {
                        System.out.println("");
                        System.out.println("Nattilante: Are you sure? Because I saw in the CCTV that you took my syringe of experimental RoidRage serum. It's ok if you forget, memory loss is a common side effect.");
                        validAction = false;
                    }
                    else if (userInput == 'b') {
                        System.out.println("");
                        System.out.println("Mordecai: ow.");
                         System.out.println("");
                        System.out.println("Make Another Choice: ");
                        System.out.println("ACTIONS: ");
                        System.out.println("a. I'm feeling just fine, thanks for asking NattiLAMEte!");
                        System.out.println("b. Punch Mordecai");
                    }
                    else {
                        System.out.println("");
                        System.out.println("Invalid input.");
                    }
               }
               System.out.println("");
               System.out.println("Mordecai: What did you do to my friend?? Rigby we need to- ");
               System.out.println("");
               System.out.println("*You are filled with a blind rage, and feeling SWOLE*");
               System.out.println("NEW OBJECTIVE: Kill MORDECAI and SKIPS!");
               System.out.println("");
               System.out.println("ACTIONS: ");
               System.out.println("a. KILL MORDECAI");
               System.out.println("b. KILL SKIPS");
                boolean kill = true;
                boolean mordecaiIsAlive = true;
                boolean skipsIsAlive = true;
                while (mordecaiIsAlive || skipsIsAlive) {
                char userKillChoice = scnr.next().charAt(0);
                    if (userKillChoice == 'a') {
                        System.out.println("");
                        System.out.println("*You have lost all free will and succumbed to RoidRage. You charge Mordecai.");
                        mordecaiIsAlive = false;
                        System.out.print("MAKE ANOTHER CHOICE:");
                        System.out.println("");
                        System.out.println("ACTIONS: ");
                        System.out.println("b. KILL SKIPS");
                    }
                    else if (userKillChoice == 'b') {
                        System.out.println("");
                        System.out.println("*You have lost all free will and succumbed to RoidRage. You charge Skips.");
                        System.out.println("");
                        System.out.println("*Skips puts up a fight*");
                        System.out.println("");
                        while (skipsIsAlive) {
                        System.out.println("ACTIONS:");
                        System.out.println("a. Hit him with a left");
                        System.out.println("b. Hit him with a right");
                            char userFightChoice = scnr.next().charAt(0);
                            if (userFightChoice == 'a') {
                                System.out.println("");
                                System.out.println("You hit Skips with a lethal Left.");
                                System.out.println("");
                                skipsIsAlive = false;
                                System.out.println("MAKE ANOTHER CHOICE:");
                                System.out.println("ACTIONS: ");
                                System.out.println("a. KILL MORDECAI");

                            }
                            else if (userFightChoice == 'b') {
                                System.out.println("");
                                System.out.println("You hit skips with a hard Right. Looks like he only needs one Left go down.");
                                System.out.println("MAKE ANOTHER CHOICE: ");
                                System.out.println("");
                            }
                        }
                    }
                    else {
                        System.out.println("");
                        System.out.println("Invalid input");
                        userKillChoice = scnr.next().charAt(0);
                    }
                }
                System.out.println("");
                System.out.println("*You have a moment of clarity within your deteriorating mind*");
                System.out.println("");
                System.out.println("Rigby: Im so swole... but at what cost...");
                System.out.println("");
                System.out.println("Nattilante: MWAHAHAHAH! I'm sorry about your friends, Rigby. I will stay here in SIGMALAND to take down every roid user, one at a time");
                System.out.println("");
                System.out.println("ACTIONS: ");
                System.out.println("a. Punch Mordecai");
                System.out.println("b. Accept Fate");
                validAction = true;
                while (validAction) {
                    userInput = scnr.next().charAt(0);
                    if (userInput != 'b' && userInput != 'a') {
                        System.out.println("Invalid input.");
                    }
                    else if (userInput == 'a') {
                        System.out.println("");
                        System.out.println("*Theres no more Mordecai to punch :(*");
                        System.out.println("");
                        System.out.println("Make Another Choice: ");
                        System.out.println("ACTIONS: ");
                        System.out.println("a. Punch Mordecai");
                        System.out.println("b. Accept Fate");
                    }
                    else if (userInput == 'b') {
                        System.out.println("");
                        System.out.println("*You curl up into a ball in the corner of the room, forever a pawn in the Nattilante's evil scheme*");
                        validAction = false;
                    }
               }
                isPlaying = false;
            }
// This code runs if they decide to stay natty
            else {
                System.out.println("");
                System.out.println("Rigby: We need to save Skips, fake natty or not!");
                System.out.println("Rigby charges Skips");
                System.out.println("");
                System.out.println("NEW OBJECTIVE: Save SKIPS and DEFEAT the NATTILANTE");
                System.out.println("a. Pinch his vagus nerve");
                System.out.println("b. Hamboning");
                boolean validFightChoice = true;
                while (validFightChoice) {
                    char userFightChoice2 = scnr.next().charAt(0);
                    if (userFightChoice2 != 'a' && userFightChoice2 != 'b') {
                        System.out.println("");
                        System.out.println("Invalid input.");
                    }
                    else if (userFightChoice2 == 'a') {
                        System.out.println("");
                        System.out.println("*You charge Skips and pinch his vagus nerve, causing him to faint.");
                        validFightChoice = false;
                    }
                    else if (userFightChoice2 == 'b') {
                        System.out.println("");
                        System.out.println("*You valiantly hambone*");
                        System.out.println("*It is not very effective*");
                         System.out.println("");
                        System.out.println("Mordecai: Bro that never works");
                         System.out.println("");
                        System.out.println("CHOOSE ANOTHER ACTION: ");
                    }
                }
                System.out.println("");
                System.out.println("Rigby: Now it's your turn!");
                System.out.println("");
                System.out.println("Mordecai: Yeah!");
                System.out.println("");
                System.out.println("*The dynamic duo advance on the now very scared Nattilante*");
                System.out.println("");
                System.out.println("Rigby: Jump on my big juicy traps and break the window with your beak!");
                System.out.println("");
                System.out.println("Mordecai: HM! HM! HM!");
                System.out.println("");
                System.out.println("ACTIONS: ");
                System.out.println("a. Perform sick maneuver");
                validFightChoice = true;
                while (validFightChoice) {
                    char userFightChoice = scnr.next().charAt(0);
                    if (userFightChoice != 'a') {
                        System.out.println("");
                        System.out.println("Invalid input.");
                    }
                    else {
                        System.out.println("");
                        System.out.println("*Sick maneuver completed*");
                        System.out.println("*The glass crashes in, and the Nattilante cowers in the corner*");
                         System.out.println("");
                        validFightChoice = false;
                    }
                }
                validFightChoice = true;
                System.out.println("ACTIONS: ");
                System.out.println("a. Finish this once and for all.");
                System.out.println("b. Punch Mordecai");
                while (validFightChoice) {
                    char userFightChoice = scnr.next().charAt(0);
                    if (userFightChoice != 'a' && userFightChoice != 'b') {
                        System.out.println("");
                        System.out.println("Invalid input.");
                    }
                    else if (userFightChoice == 'a') {
                        System.out.println("");
                        System.out.println("Rigby: meh! meh!");
                        System.out.println("*You slap his face. It is not very effective*");
                        System.out.println("");
                        System.out.println("Mordecai:*sigh* Let me handle this");
                        System.out.println("*Mordecai delivers a swift hook, and the Nattilante faints");
                        validFightChoice = false;
                    }
                    else if (userFightChoice == 'b') {
                        System.out.println("");
                        System.out.println("Mordecai: Ow.");
                         System.out.println("");
                         System.out.println("Make Another Choice: ");
                    }
                }
                System.out.println("");
                System.out.println("Rigby: What just fell out of his pocket conveniently?");
                System.out.println("");
                System.out.println("ACTIONS:");
                System.out.println("Syringe");
                System.out.print("TYPE CHOICE: ");
                validAction = true;
                while (validAction) {
                    scnr.nextLine();
                    userInputString = scnr.nextLine();
                    if (!userInputString.equalsIgnoreCase("syringe")) {
                        System.out.println("");
                        System.out.println("Invalid input.");
                    }
                    else {
                        System.out.println("");
                        System.out.println("Mordecai: It says ROIDRAGE ANTIDOTE. Give it to Skips!");
                        validAction = false;
                    }
                }
                System.out.println("");
                System.out.println("Rigby: On it!");
                System.out.println("");
                System.out.println("*The three were able to escape the gym and reverse the effects of the Nattilante's serum on Skips*");
                System.out.println("The Nattilante was turned into the authorities, and Skips resolved to never be a fake natty again.");
                isPlaying = false;
            }
        }
        else {
            System.out.println("");
            System.out.println("Rigby: Huh. This room is locked");
            userExitChoice = "power lifting room";
        }
    }
    }
    endScreen();
    }
}