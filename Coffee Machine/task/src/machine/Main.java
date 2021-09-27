package machine;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);

        do {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");

            String action = scanner.nextLine();

            switch (action) {
                case "remaining":
                    machine.printCoffeeMachineStatus();
                    break;
                case "buy":
                    processActionBuy(machine);
                    break;
                case "fill":
                    processActionFill(machine);
                    break;
                case "take":
                    processActionTake(machine);
                    break;
                case "exit":
                    System.exit(0);
            }

        } while(true);
    }

    private static void processActionBuy(CoffeeMachine machine) {
        CoffeeCup c;
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: \n> ");

        String action = scanner.nextLine();
        if(action.equals("back")) {
            return;
        }
        int actionInt = Integer.parseInt(action);

        switch (actionInt) {
            case 1:
                c = new CoffeeCup(250, 0, 16, 4);
                break;
            case 2:
                c = new CoffeeCup(350, 75, 20, 7);
                break;
            case 3:
                c = new CoffeeCup(200, 100, 12, 6);
                break;
            default:
                System.out.println("Number entered is not correct!");
                return;
        }


        if (!machine.canMakeCoffeeCup(c)) {
            System.out.println("There is not enough ingredients to make a coffee. Please fill the coffee machine!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            machine.makeCoffeeCup(c);
        }
    }

    private static void processActionFill(CoffeeMachine machine) {
        System.out.print("Write how many ml of water the coffee machine you want to add:  \n> ");
        machine.setCurrentWater( machine.getCurrentWater() + scanner.nextInt());
        System.out.print("Write how many ml of milk the coffee machine you want to add:  \n> ");
        machine.setCurrentMilk( machine.getCurrentMilk() + scanner.nextInt());
        System.out.print("Write how many grams of coffee beans the coffee machine you want to add: \n> ");
        machine.setCurrentCoffee( machine.getCurrentCoffee() + scanner.nextInt());
        System.out.print("Write how many disposable cups of coffee you want to add: \n> ");
        machine.setDisposableCups( machine.getDisposableCups() + scanner.nextInt());
    }

    private static void processActionTake(CoffeeMachine machine) {
        System.out.println("I gave you $" + machine.getCurrentEarnings());
        machine.setCurrentEarnings(0);
    }
}
