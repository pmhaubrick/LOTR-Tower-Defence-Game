package towerdefence;

/**
 * This is the class template for a Elephant Enemy.
 * 
 * @author pmh20
 *
 */
public class Elephant extends Enemy {

    protected final int eHealth = 10;
    protected final double eSpeed = 0.5;


    /**
     * This constructor sets the staring values, including the selected position.
     */
    public Elephant() {
        health = eHealth;
        floatpos = 0;
        position = 0;
        speed = eSpeed;
    }
}
