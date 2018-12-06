package iphonesnatchers;
public class Key extends Item{

    public Key(Location loc){
        super('K', loc);
    }
    public boolean canBePlaced(Item[][] board){
        if( board[loc.getY()][loc.getX()] == null) {
        return true;
        } else if (board[loc.getY()][loc.getX()] == keyExists(loc)) {
        	return true;
        }
        return false;
    }
	private Item keyExists(Location loc) {
		// TODO Auto-generated method stub
		return null;
	}
}
