package towerdefence;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class is used for creating a new account object. It stores a balance,
 * and handles all money issues, such as purchasing Towers using the in-game shop.
 * 
 * @author pmh20
 *
 */
public class BankAccount {

    private static final int SLINGSHOT_COST = 300;
    private static final int CATAPULT_COST = 500;
    private static final int DWARF_COST = 1200;
    private static final int ELF_COST = 1500;
    protected static final double EURO_EXCHANGE = 1.12;

    protected int balance;


    /**
     * Constructor used to initialise the balance to starting budget.
     * 
     * @param bal - Used to initialise the balance
     */
    public BankAccount(int bal) {
        balance = bal;
    }


    /**
     * Gets the balance of an account object (this game only uses 1 account anyway).
     * 
     * @return balance - Returns the current bank balance
     */
    public int getBalance() {
        return balance;
    }


    /**
     * This method is in charge of asking the user all the buying questions, and then dealing with the answers, placing Towers when necessary.
     * It also corrects the balance when something is bought.
     * 
     * @param currentBalance - Value of the current balance
     * @param towers - A reference to the ArrayList storing the Towers (to allow the adding of new Towers if any are bought)
     * @param ts - The index value of the current game-loop time-step
     */
    public void checkAccountAndBuy(int currentBalance, ArrayList<Tower> towers, int ts) {
        System.out.println(" || Current Bank Account Balance: £" + Game.armyFundsAccount.getBalance() + "  (€" + (int) (Game.armyFundsAccount.getBalance() * EURO_EXCHANGE) + ") ||\n");
        System.out.println(" Before the wave begins, would you like to purchase and place any defences?\n Please type: \"Yes\" or \"No\", or \"Y\" or \"N\"  -  (Not case sensitive)\n");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine().toLowerCase();
        if (choice.equals("yes") || choice.equals("y")) {
            System.out.println("\n View the shop below, then enter the letter that corresponds with your choice.\n");
            System.out.println(" |     ITEM     |  PRICE  | DAMAGE | RELOAD TIME |    RANGE    |   To buy, enter:   |");
            System.out.println(" ¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
            System.out.println(" |   Slingshot  |   £300  |  1 dmg |  1 timestep |     40      |         \"S\"        |");
            System.out.println(" |   Catapult   |   £500  |  5 dmg |  3 timestep |     80      |         \"C\"        |");
            System.out.println(" | Dwarf Axeman |  £1200  |  7 dmg |  4 timestep |      3      |         \"D\"        |");
            System.out.println(" |  Elf Bowman  |  £1500  |  3 dmg |  2 timestep |  Unlimited  |         \"E\"        |\n\n");

            String item = scan.nextLine().toLowerCase();
            System.out.println("\n Enter the position you would like to place this Tower.\n Please enter an integer between 1 and the legth of the corridor (" + Game.CORRIDOR_LENGTH + ").\n");
            String newPos = scan.nextLine().toLowerCase();
            if (item.equals("s") && Integer.parseInt(newPos) - 1 < Game.CORRIDOR_LENGTH) {
                towers.add(new Slingshot(Integer.parseInt(newPos)));
                Game.armyFundsAccount.balance -= SLINGSHOT_COST;
                System.out.println("\n Your selected Tower has been added.\n\n Press enter to continue.\n");
            } else if (item.equals("c") && Integer.parseInt(newPos) - 1 < Game.CORRIDOR_LENGTH && Game.armyFundsAccount.balance >= CATAPULT_COST) {
                towers.add(new Catapult(Integer.parseInt(newPos)));
                Game.armyFundsAccount.balance -= CATAPULT_COST;
                System.out.println("\n Your selected Tower has been added.\n\n Press enter to continue.\n");
            } else if (item.equals("d") && Integer.parseInt(newPos) - 1 < Game.CORRIDOR_LENGTH && Game.armyFundsAccount.balance >= DWARF_COST) {
                towers.add(new DwarfAxeman(Integer.parseInt(newPos)));
                Game.armyFundsAccount.balance -= DWARF_COST;
                System.out.println("\n Your selected Tower has been added.\n\n Press enter to continue.\n");
            } else if (item.equals("e") && Integer.parseInt(newPos) - 1 < Game.CORRIDOR_LENGTH && Game.armyFundsAccount.balance >= ELF_COST) {
                towers.add(new ElfBowman(Integer.parseInt(newPos)));
                Game.armyFundsAccount.balance -= ELF_COST;
                System.out.println("\n Your selected Tower has been added.\n\n Press enter to continue.\n");
            } else if (item.equals("s") && Integer.parseInt(newPos) - 1 < Game.CORRIDOR_LENGTH && Game.armyFundsAccount.balance < SLINGSHOT_COST
                    || item.equals("c") && Integer.parseInt(newPos) - 1 < Game.CORRIDOR_LENGTH && Game.armyFundsAccount.balance < CATAPULT_COST
                    || item.equals("d") && Integer.parseInt(newPos) - 1 < Game.CORRIDOR_LENGTH && Game.armyFundsAccount.balance < DWARF_COST
                    || item.equals("e") && Integer.parseInt(newPos) - 1 < Game.CORRIDOR_LENGTH && Game.armyFundsAccount.balance < ELF_COST) {
                System.out.println("\n Are you trying to get away with paying less?\n Did you think I wouldn't notice?\n Now you've missed your chance to buy 'till next time!\n");
                System.out.println(" Press enter to continue.\n");
            }
            scan.nextLine();
        }
    }
}
