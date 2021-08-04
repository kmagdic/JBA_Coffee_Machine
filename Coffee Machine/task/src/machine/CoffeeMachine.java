package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int currentWater = 400;
    static int currentMilk = 540;
    static int currentCoffee = 120;
    static int disposableCups = 9;
    private static int currentEarnings = 550;


    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        displayCoffeeMachineStatus();

        System.out.println("\nWrite action (buy, fill, take):");
        String action = scanner.nextLine();

        if (action.equals("buy")) {
            processActionBuy();
        } else if (action.equals("fill")) {
            processActionFill();
        } else if (action.equals("take")) {
            processActionTake();
        }

        displayCoffeeMachineStatus();
    }


    private static void displayCoffeeMachineStatus() {
        System.out.println("\nThe coffee machine has: ");
        System.out.printf("%d ml of water\n", currentWater);
        System.out.printf("%d ml of milk\n", currentMilk);
        System.out.printf("%d ml of coffee beans\n", currentCoffee);
        System.out.printf("%d disposable cups\n", disposableCups);
        System.out.printf("$%d of money\n", currentEarnings);
    }

    private static void processActionBuy() {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: \n> ");
        int coffeeType = scanner.nextInt();
        CoffeeCup c = null;

        if(coffeeType == 1)
            c = new CoffeeCup(250, 0, 16, 4);
        else if(coffeeType == 2)
            c = new CoffeeCup(350, 75, 20, 7);
        else if(coffeeType == 3)
            c = new CoffeeCup(200, 100, 12, 6);


        if (c == null) {
            System.out.println("Not correct number");
        } else {
            if (currentWater < c.getWaterNeeded() || currentMilk < c.getMilkNeeded()
                    || currentCoffee < c.getCoffeeNeeded() || disposableCups == 0) {
                System.out.println("There is not enough ingredients to make a coffee. Please fill the coffee machine!");
            } else {
                currentWater -= c.getWaterNeeded();
                currentMilk -= c.getMilkNeeded();
                currentCoffee -= c.getCoffeeNeeded();
                currentEarnings += c.getCost();
                disposableCups--;
            }
        }
    }

    private static void processActionFill() {
        System.out.print("Write how many ml of water the coffee machine you want to add:  \n> ");
        currentWater = currentWater + scanner.nextInt();
        System.out.print("Write how many ml of milk the coffee machine you want to add:  \n> ");
        currentMilk = currentMilk + scanner.nextInt();
        System.out.print("Write how many grams of coffee beans the coffee machine you want to add: \n> ");
        currentCoffee = currentCoffee + scanner.nextInt();
        System.out.print("Write how many disposable cups of coffee you want to add: \n> ");
        disposableCups += scanner.nextInt();
    }

    private static void processActionTake() {
        System.out.println("I gave you $" + currentEarnings);
        currentEarnings = 0;
    }

}
