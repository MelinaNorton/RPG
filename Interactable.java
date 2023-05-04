// method to create interactables
public class Interactable {
    String interactableName;
    String interactableDialogue;
// method to set their names
    public void setInteractableName(String interactableNameChoice){
        this.interactableName = interactableNameChoice;
    }
// method to get their names
    public String getInteractableName(){
        return this.interactableName;
    }
// method to set their dialogues
    public void setinteractableDialogue(String interactableDialogueChoice){
        this.interactableDialogue = interactableDialogueChoice;
    }
// method to get their dialogues
    public String getinteractableDialogue(){
        return this.interactableDialogue;
    }
}