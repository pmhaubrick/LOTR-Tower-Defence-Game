package towerdefence;

import java.util.ArrayList;


/**
 * Visualises the Game.
 * 
 * @author pmh20
 *
 */
public class ShowGame {

    /**
     * Shows the game in the console.
     * 
     * @param corLength - The length of the corridor, for visually displaying the game correctly
     * @param enemies - A reference to the ArrayList storing the enemies (to display all the enemies (their type and health)
     * @param towers - A reference to the ArrayList storing the Towers (to display all the towers (their type and damage)
     */
    public static void showGame(int corLength, ArrayList<Enemy> enemies, ArrayList<Tower> towers) {

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < corLength; j++) {
                System.out.print("W");
            }
            System.out.println();
        }

        for (Tower t : towers) {
            for (int spaces = 0; spaces < t.getPosition(); spaces++) {
                System.out.print(" ");
            }
            if (t instanceof Catapult) {
                System.out.println("C[" + t.getDamage() + "DMG]");
            } else if (t instanceof Slingshot) {
                System.out.println("S[" + t.getDamage() + "DMG]");
            } else if (t instanceof DwarfAxeman) {
                System.out.println("D[" + t.getDamage() + "DMG]");
            } else if (t instanceof ElfBowman) {
                System.out.println("E[" + t.getDamage() + "DMG]");
            }
        }

        for (int j = 0; j < corLength; j++) {
            System.out.print("_");
        }
        System.out.println();

        for (Enemy e : enemies) {
            if (e.getPosition() >= 0) {
                for (int spaces = 0; spaces < e.getPosition(); spaces++) {
                    System.out.print(" ");
                }
                if (e instanceof Elephant) {
                    System.out.println("e(" + e.getHealth() + "hp)");
                } else if (e instanceof Rat) {
                    System.out.println("r(" + e.getHealth() + "hp)");
                } else if (e instanceof Orc) {
                    System.out.println("o(" + e.getHealth() + "hp)");
                } else if (e instanceof UrukHai) {
                    System.out.println("u(" + e.getHealth() + "hp)");
                }
            }
        }

        if (enemies.size() == 0) {
            System.out.println();
            System.out.println();
            System.out.println();
        } else if (enemies.size() == 1) {
            System.out.println();
            System.out.println();
        } else if (enemies.size() == 2) {
            System.out.println();
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < corLength; j++) {
                System.out.print("W");
            }
            System.out.println();
        }
        System.out.println();
    }
}
