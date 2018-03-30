package towerdefence;

/**
 * This is the class template for a DwarfAxeman Tower.
 * 
 * @author pmh20
 *
 */
public class DwarfAxeman extends Tower {

    protected final int dDamage = 7;
    protected final int dFireFrequency = 4;
    protected final int dRange = 3;


    /**
     * This constructor sets the initial values, including the position.
     * 
     * @param pos - The desired position to place the DwarfAxeman
     */
    public DwarfAxeman(int pos) {
        damage = dDamage;
        position = pos;
        fireFrequency = dFireFrequency;
        range = dRange;
    }
}
