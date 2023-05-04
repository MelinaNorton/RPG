import java.util.ArrayList;
// Class the create room objects
public class Room {
    String name;
    ArrayList <String> exits = new ArrayList <String> ();
    ArrayList <Interactable> interactables = new ArrayList <Interactable> ();
// method to name room
    public void setRoomName(String roomName){
        this.name = roomName;
    }
// method to set room name
    public String getRoomName(){
        return this.name;
    }
// method to give exits
    public void setExits(String exit){
        this.exits.add(exit);
    }
// method to get exits
    public ArrayList <String> getExits(){
        return this.exits;
    }
// method to set interactables
    public void setInteractables(Interactable interactable){
        interactables.add(interactable);
    }
// method to get interactables
    public ArrayList <Interactable> getInteractable(){
        return this.interactables;
    }
// method called when entering a room; prints out the room's info
    public void printRoomInfo(){
        char userInput = 'z';
        boolean isNotValid = true;
        System.out.println("");
        System.out.println(this.getRoomName() + ":");
        System.out.println("ACTIONS: ");
        for (Interactable interactable : interactables) {
        System.out.println(" " + interactable.getInteractableName());
        }
    }
}