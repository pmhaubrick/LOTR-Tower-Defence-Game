package towerdefence;

/**
 * Tower class template.
 * 
 * @author pmh20
 *
 */
public class Tower {

    protected int damage;
    protected int position;
    protected int fireFrequency;
    protected int range;


    /**
     * Returns damage.
     * 
     * @return damage - The damage of current object
     */
    public int getDamage() {
        return damage;
    }


    /**
     * Returns pos.
     * 
     * @return position - The position of current object
     */
    public int getPosition() {
        return position;
    }


    /**
     * Returns is fires.
     * 
     * @param timeStep - The current game-loop time-step
     * @return boolean - Stating whether the Tower is loaded and ready to fire again
     */
    public boolean willFire(int timeStep) {
        return (timeStep % fireFrequency == 0);
    }


    /**
     * Returns ramge.
     * 
     * @return range - The range that the current tower can fire
     */
    public int getRange() {
        return range;
    }


    /**
     * Returns stats.
     * 
     * @param timeStep - The current game-loop time-step
     * @return towerStats - A string with the relevant stats used for debugging
     */
    public String toString(int timeStep) {
        String towerStats = "Damage: " + damage + "  Position: " + position + "  Will Fire?: " + willFire(timeStep);
        return towerStats;
    }
}
