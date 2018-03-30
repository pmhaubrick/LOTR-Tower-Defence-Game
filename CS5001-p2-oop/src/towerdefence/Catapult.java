package towerdefence;

/**
 * This is the class template for a Catapult Tower.
 * 
 * @author pmh20
 *
 */
public class Catapult extends Tower {

    protected final int cDamage = 5;
    protected final int cFireFrequency = 3;
    protected final int cRange = 80;


    /**
     * This constructor sets the starting values, including the provided position.
     * 
     * @param pos - The desired position to place the catapult
     */
    public Catapult(int pos) {
        damage = cDamage;
        position = pos;
        fireFrequency = cFireFrequency;
        range = cRange;
    }
}
