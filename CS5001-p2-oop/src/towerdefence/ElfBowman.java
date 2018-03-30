package towerdefence;

/**
 * This is the class template for a ElfBowman Tower.
 * 
 * @author pmh20
 *
 */
public class ElfBowman extends Tower {

    protected final int eDamage = 3;
    protected final int eFireFrequency = 2;
    protected final int eRange = Game.CORRIDOR_LENGTH;


    /**
     * This constructor sets the staring values, including the selected position.
     * 
     * @param pos - The desired position to place the DwarfAxeman
     */
    public ElfBowman(int pos) {
        damage = eDamage;
        position = pos;
        fireFrequency = eFireFrequency;
        range = eRange;
    }
}
