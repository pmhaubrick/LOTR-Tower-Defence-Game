package towerdefence;

/**
 * This is the class template for a Slingshot Tower.
 * 
 * @author pmh20
 *
 */
public class Slingshot extends Tower {

    protected final int sDamage = 1;
    protected final int sFireFrequency = 1;
    protected final int sRange = 40;


    /**
     * This constructor sets the staring values, including the selected position.
     * 
     * @param pos - The desired position to place the slingshot
     */
    public Slingshot(int pos) {
        damage = sDamage;
        position = pos;
        fireFrequency = sFireFrequency;
        range = sRange;
    }
}
