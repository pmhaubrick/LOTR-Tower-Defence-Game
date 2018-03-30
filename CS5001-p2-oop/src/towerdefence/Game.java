package towerdefence;

import java.util.ArrayList;


/**
 * Main game class. Includes main() which contains the game loop.
 * 
 * @author pmh20
 *
 */
public class Game {

    private static int timeStep = 0;
    protected static final int CORRIDOR_LENGTH = 150;
    private static final int STARTING_BALANCE = 750;
    private static final int TIMESTEPS_TO_WIN_GAME = 500;
    private static final int PRICE_ON_RATS_HEAD = 5;
    private static final int PRICE_ON_ELEPHANTS_HEAD = 40;
    private static final int PRICE_ON_URUKHAIS_HEAD = 100;
    private static final int PRICE_ON_ORCS_HEAD = 50;
    private static final int WAVE_LENGTH = 25;

    protected static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    protected static ArrayList<Tower> towers = new ArrayList<Tower>();
    protected static BankAccount armyFundsAccount = new BankAccount(STARTING_BALANCE);
    private static boolean gameOver = false;
    protected static int waveCounter = 1;


    /**
     * Main executed game loop, calling all methods.
     * 
     * @param args - There are no args taken for this game. All decisions will be made via questions in the console
     */
    public static void main(String[] args) {

        System.out.println("\n\n ____________________________________\n |||-----BATTLE FOR RIVENDELL-----|||\n\n\n Task: Hold off Sauron's legions untill reinforcements arrive.\n\n");

        while (timeStep < TIMESTEPS_TO_WIN_GAME) {

            if (timeStep % WAVE_LENGTH == 0) {
                System.out.println("\n |---- WAVE: " + waveCounter + " ----|   (Beat 20 waves to win)\n");
                armyFundsAccount.checkAccountAndBuy(armyFundsAccount.getBalance(), towers, timeStep);
                SpawnEnemies.addEnemies();
                waveCounter++;
            }
            System.out.println("\n || Timestep: " + (timeStep + 1) + " ||\n");
            System.out.println(" || Current Bank Account Balance: £" + armyFundsAccount.getBalance() + "  (€" + (int) (armyFundsAccount.getBalance() * BankAccount.EURO_EXCHANGE) + ") ||\n");
            Debug.allObjectsToString(timeStep, enemies, towers, armyFundsAccount);
            ShowGame.showGame(CORRIDOR_LENGTH, enemies, towers);
            advance();
            if (gameOver) {
                break;
            }
            timeStep++;
        }
        System.out.println("\n");
        System.out.println("__________________________________________________________________________________________");
        if (timeStep >= TIMESTEPS_TO_WIN_GAME - 1) {
            System.out.println(" CONGRATULATIONS!!!!!!!!!!!!! You have WON the game. Many Forrest Elf reinforcements have\n arrived from neighbouring woods "
                    + "(the Trollshaws, just to the west).\n\n Your territory is now safe! Sauron's armies have lost this battle, but not yet the war.\n\n "
                    + "Await the sequel (\"BATTLE FOR RIVENDELL 2\") to find out.\n\n\n\n");
        } else {
            System.out.println(" I am very sorry, but your territory has been invaded and you have therefore lost the game.\n\n Uruk Hai have invaded Rivendell and slaughtered "
                    + "many innocent Elf families.\n\n The Orcs report back to Sauron, who revels in your inadequate battle strategies, which may have brought the fall of"
                    + " Middle Earth.\n\n Await the sequel (\"BATTLE FOR RIVENDELL 2\") to find out what will happen next.\n\n\n\n");
        }
    }


    /**
     * Advances the game each timestep.
     */
    public static void advance() {

        for (Enemy e : enemies) {
            e.advance();
            if (e.getPosition() > CORRIDOR_LENGTH) {
                gameOver = true;
            }
        }

        for (Tower t : towers) {
            if (t.willFire(timeStep)) {
                if (Enemy.isAnEnemyInRange(t, enemies) && enemies.size() > 0) {
                    int closest = Enemy.closestEnemy(t, enemies);
                    enemies.get(closest).hit(t);
                    if (enemies.get(closest).getHealth() <= 0) {
                        if (enemies.get(closest) instanceof Elephant) {
                            armyFundsAccount.balance += PRICE_ON_ELEPHANTS_HEAD;
                        } else if (enemies.get(closest) instanceof Rat) {
                            armyFundsAccount.balance += PRICE_ON_RATS_HEAD;
                        } else if (enemies.get(closest) instanceof Orc) {
                            armyFundsAccount.balance += PRICE_ON_ORCS_HEAD;
                        } else if (enemies.get(closest) instanceof UrukHai) {
                            armyFundsAccount.balance += PRICE_ON_URUKHAIS_HEAD;
                        }
                        enemies.remove(closest);
                    }
                }
            }
        }
    }
}
