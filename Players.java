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
public class Players {
    private Location location;
    
    public Players(Location loc){
        this.location = loc;
    }
    public Location getLocation(){
        return this.location;
    }
    
    public void setLocation(Location loc){
        this.location = loc;
    }
    public boolean canMove(Location loc){
        return false;
    }
}
