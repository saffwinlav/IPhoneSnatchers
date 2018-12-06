
package iphonesnatchers;

public class Location {
    private int x;
    private int y;
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getY(){
        return this.y;
    }
    public int getX(){
        return this.x;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public String toString(){
        return "X = " + x + ", Y = " + y;
    }
}
