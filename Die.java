package iphonesnatchers;
/**
 * Simulates a Die object with a possibility of multiple sides.
 */

//saffy as driver
public class Die {

    private int face;
    private int sides;

    /**
     * Constructors
     */
    public Die() {
        face = 1;
        sides = 6;
    }
    public Die(int sides) {
        face = 1;
        this.sides = sides;
    }

    /**
     * Get the current face value of the die
     *
     * @return current face value of the die
     */
    public int getFace() {
        return face;
    }

    /**
     * Simulate the roll of the die
     *
     * @return new face value of the die
     */
    public int roll() {
        face = (int) (Math.random() * this.sides) + 1;
        return face;
    }

}
