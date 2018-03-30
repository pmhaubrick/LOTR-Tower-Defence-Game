package towerdefence;

import java.util.ArrayList;


/**
 * This class was for debugging in early stages, and then was used in the game display to view all stats.
 * 
 * @author pmh20
 *
 */
public class Debug {

    /**
     * This method calls the toString() methods from the 2 Super-classes, for all the enemies/Towers, and prints them to the screen.
     * 
     * @param ts - The index value of the current game-loop time-step
     * @param enemies - A reference to the ArrayList storing the enemies (to use toString to find stats for all enemies)
     * @param towers - A reference to the ArrayList storing the Towers (to use toString to find stats for all towers)
     * @param b -  - A reference to the bank account object to allow the method to find the current balance
     */
    public static void allObjectsToString(int ts, ArrayList<Enemy> enemies, ArrayList<Tower> towers, BankAccount b) {

        int i = 0;
        for (Tower t : towers) {
            System.out.println(" Tower " + (i + 1) + " -   " + t.toString(ts));
            i++;
        }

        System.out.println();

        int j = 0;
        for (Enemy e : enemies) {
            System.out.println(" Enemy " + (j + 1) + " -   " + e.toString());
            j++;
        }
    }
}
