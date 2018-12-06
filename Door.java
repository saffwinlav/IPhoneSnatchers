/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iphonesnatchers;

/**
 *
 * @author Nick Lance and Saffy winton
 */
public class Door extends Item{
    private boolean isOpen;
    
    public Door(Location loc) {
        super('D', loc);
        this.isOpen = false;
    }
    public void setIsOpen(boolean unlock){
        isOpen = unlock;
    }
    public boolean getIsOpen(){
        return this.isOpen;
    }
    public boolean canBePlaced(Item[][] board, Door door){
        if( board[loc.getY()][loc.getX()] == null) {
        return true;
        } else if (board[loc.getY()][loc.getX()] == keyExists(loc)) {
        	return true;
        } else if (board[loc.getY()][loc.getX()] == doorExists(loc) && (door.isOpen == true)) {
        return true;
    } return false;
    }
	private Item doorExists(Location loc) {
		// TODO Auto-generated method stub
		return null;
	}
	private Item keyExists(Location loc) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
