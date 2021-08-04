package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private int currentWater;
    private int currentMilk;
    private int currentCoffee;
    private int disposableCups;
    private int currentEarnings;

    public CoffeeMachine(int currentWater, int currentMilk, int currentCoffee, int disposableCups, int currentEarnings) {
        this.currentWater = currentWater;
        this.currentMilk = currentMilk;
        this.currentCoffee = currentCoffee;
        this.disposableCups = disposableCups;
        this.currentEarnings = currentEarnings;
    }


    private void printCoffeeMachineStatus() {
        System.out.println("\nThe coffee machine has: ");
        System.out.printf("%d ml of water\n", currentWater);
        System.out.printf("%d ml of milk\n", currentMilk);
        System.out.printf("%d ml of coffee beans\n", currentCoffee);
        System.out.printf("%d disposable cups\n", disposableCups);
        System.out.printf("$%d of money\n", currentEarnings);
    }

    private boolean canMakeCoffeeCup(CoffeeCup c) {
        return currentWater >= c.getWaterNeeded() &&
                currentMilk >= c.getMilkNeeded() &&
                currentCoffee >= c.getCoffeeNeeded() &&
                disposableCups > 0;
    }

    private void makeCoffeeCup(CoffeeCup c) {
        currentWater -= c.getWaterNeeded();
        currentMilk -= c.getMilkNeeded();
        currentCoffee -= c.getCoffeeNeeded();
        disposableCups --;
        currentEarnings += c.getCost();
    }




    /// static methods for main process

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);

        machine.printCoffeeMachineStatus();

        System.out.println("\nWrite action (buy, fill, take):");
        String action = scanner.nextLine();

        if (action.equals("buy")) {
            processActionBuy(machine);
        } else if (action.equals("fill")) {
            processActionFill(machine);
        } else if (action.equals("take")) {
            processActionTake(machine);
        }

        machine.printCoffeeMachineStatus();
    }



    private static void processActionBuy(CoffeeMachine machine) {
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
            if(!machine.canMakeCoffeeCup(c)) {
                System.out.println("There is not enough ingredients to make a coffee. Please fill the coffee machine!");
            } else {
                machine.makeCoffeeCup(c);

            }
        }
    }


    private static void processActionFill(CoffeeMachine machine) {
        System.out.print("Write how many ml of water the coffee machine you want to add:  \n> ");
        machine.currentWater = machine.currentWater + scanner.nextInt();
        System.out.print("Write how many ml of milk the coffee machine you want to add:  \n> ");
        machine.currentMilk = machine.currentMilk + scanner.nextInt();
        System.out.print("Write how many grams of coffee beans the coffee machine you want to add: \n> ");
        machine.currentCoffee = machine.currentCoffee + scanner.nextInt();
        System.out.print("Write how many disposable cups of coffee you want to add: \n> ");
        machine.disposableCups += scanner.nextInt();
    }

    private static void processActionTake(CoffeeMachine machine) {
        System.out.println("I gave you $" + machine.currentEarnings);
        machine.currentEarnings = 0;
    }

}
