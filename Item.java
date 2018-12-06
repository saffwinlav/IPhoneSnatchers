package iphonesnatchers;

/**
 *
 * @author Nick Lance and Saffy winton
 */
abstract public class Item {
    char label;
    Location loc;
    public Item(char label, Location loc){
        this.loc = loc;
        this.label = label;
    }
    public Location getLoc(){
        return this.loc;
    }
    public void setLoc(Location loc){
        this.loc = loc;
    }
    public char getLabel(){
        return this.label;
    }
    public void setLabel(char label){
        this.label = label;
    }
    public boolean canBePlaced(Item[][] board){
        return board[loc.getY()][loc.getX()] == null && loc.getX() < 8 && loc.getY() < 8
                && loc.getX() >= 0 && loc.getY() >= 0;
    }
}
