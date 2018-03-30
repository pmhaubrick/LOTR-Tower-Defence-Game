package towerdefence;

/**
 * This is the class template for a Rat Enemy.
 * 
 * @author pmh20
 *
 */
public class Rat extends Enemy {

    protected final int rHealth = 1;
    protected final int rSpeed = 2;


    /**
     * This constructor sets the staring values.
     */
    public Rat() {
        health = rHealth;
        floatpos = 0;
        position = 0;
        speed = rSpeed;
    }
}
