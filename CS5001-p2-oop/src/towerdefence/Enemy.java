package towerdefence;

import java.util.ArrayList;


/**
 * This is the Enemy Super-class, giving a template.
 * 
 * @author pmh20
 *
 */
public class Enemy {

    protected int health;
    protected int position;
    protected double speed;
    protected float floatpos;


    /**
     * Gets health.
     * 
     * @return health - The current health of the current enemy object
     */
    public int getHealth() {
        return health;
    }


    /**
     * Gets position.
     * 
     * @return position - The current health of the current enemy object
     */
    public int getPosition() {
        return position;
    }


    /**
     * Hits tower.
     * 
     * @param t - A reference to the specific Tower object that is to perform a hit on an enemy
     */
    public void hit(Tower t) {
        if (position <= t.position) {
            health -= t.getDamage();
        }
    }


    /**
     * Advances Enemy positions.
     */
    public void advance() {
        floatpos += speed;
        position = (int) Math.floor(floatpos);
    }


    /**
     * (non-Javadoc).
     * @see java.lang.Object#toString()
     * @return towerStats - A string with the relevant stats used for debugging
     */
    public String toString() {
        String towerStats = "Health: " + health + "  Position: " + position;
        return towerStats;
    }


    /**
     * Finds the closest Enemy.
     * 
     * @param tower - A reference to the specific Tower object that is that is looking for its closest enemy
     * @param enemies - A reference to the ArrayList storing the enemies (to locate the closest one)
     * @return closest - An integer value, representing the index for the closest enemy in the ArrayList
     */
    public static int closestEnemy(Tower tower, ArrayList<Enemy> enemies) {
        int closest = 0;
        int closestPos = 0;

        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).getPosition() > closestPos && enemies.get(i).getPosition() < tower.getPosition()) {
                closestPos = enemies.get(i).getPosition();
                closest = i;
            }
        }

        return closest;
    }


    /**
     * Checks if enemy is in range.
     * 
     * @param tower - A reference to the specific Tower object that is that is looking for any enemies in range (must not have passed the Tower)
     * @param enemies - A reference to the ArrayList storing the enemies (to check if any are in range)
     * @return boolean - Representing if there is indeed an enemy that the Tower is able to shoot
     */
    public static boolean isAnEnemyInRange(Tower tower, ArrayList<Enemy> enemies) {
        boolean isEnemy = true;
        for (Enemy e : enemies) {
            if (e.getPosition() <= tower.getPosition() && (tower.getPosition() - e.getPosition()) <= tower.getRange()) {
                isEnemy = true;
                break;
            } else {
                isEnemy = false;
            }
        }
        return isEnemy;
    }
}
