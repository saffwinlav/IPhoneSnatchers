package iphonesnatchers;
/**
 * 
 * @author Nick Lance and Saffy winton
 */
public class Theif extends Item{
    
    private int detectionMeter;
    private boolean hasKey;
    private boolean hasBoxCutter;
    private boolean enteredDoor;
    public Theif(Location loc) {
        super('T', loc);
        this.detectionMeter = 0;
        this.hasKey = false;
        this.hasBoxCutter = false;
        this.enteredDoor = false;
    }
    public Theif(Theif player){
        super('T', player.getLoc());
        this.detectionMeter = player.getDetectionMeter();
        this.hasKey = player.getHasKey();
        this.hasBoxCutter = player.getHasBoxCutter();
        this.enteredDoor = player.getEnteredDoor();
        
    }
    
    public int getDetectionMeter(){
        return this.detectionMeter;
    }
    
    public boolean getHasKey(){
        return this.hasKey;
    }
    
    public boolean getHasBoxCutter(){
        return this.hasBoxCutter;
    }
    
    public void setDetectionMeter(int n){
        this.detectionMeter = n;
    }
    
    public void setHasKey(boolean hasKey){
        this.hasKey = hasKey;
    }
    
    public void setEnteredDoor(boolean enteredDoor){
        this.enteredDoor = enteredDoor;
    }
    
    public boolean getEnteredDoor(){
        return this.enteredDoor;
    }
    
    public void setHasBoxCutter(boolean hasBoxCutter){
        this.hasBoxCutter = hasBoxCutter;
    }
    
}
