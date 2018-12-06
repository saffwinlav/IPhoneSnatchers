package iphonesnatchers;

/**
 *
 * @author Nick Lance and Saffy winton
 */
public class Genius extends Item{
    private boolean hasBeenMoved;
    private final int seeingDistance;
    
    public Genius(int distance) {
    	super('G', null);
    	this.seeingDistance = distance;
    }
    public Genius(Location loc, int distance) {
        super('G', loc);
        this.seeingDistance = distance;
        this.hasBeenMoved = false;
    }

    Genius(Genius genius) {
        super('G', genius.getLoc());
        this.seeingDistance = genius.getSeeingDistance();
    }
    
    public boolean getHasBeenMoved(){
        return this.hasBeenMoved;
    }
    public void setHasBeenMoved(boolean hasBeenMoved){
        this.hasBeenMoved = hasBeenMoved;
    }
    
    public int getSeeingDistance(){
        return this.seeingDistance;
    }
    
}
