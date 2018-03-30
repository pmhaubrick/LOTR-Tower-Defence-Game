package towerdefence;

/**
 * This is the class template for an Orc Enemy.
 * 
 * @author pmh20
 *
 */
public class Orc extends Enemy {

    protected final int oHealth = 5;
    protected final int oSpeed = 3;


    /**
     * This constructor sets the staring values.
     */
    public Orc() {
        health = oHealth;
        floatpos = 0;
        position = 0;
        speed = oSpeed;
    }

}
