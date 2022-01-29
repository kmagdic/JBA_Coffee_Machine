package machine;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ConsoleMain {
    static Scanner scanner = new Scanner(System.in);
    static String configFileName = "coffee_machine_status.txt";
    static String historyFileName = "coffee_machine_history.txt";

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
        loadCoffeeMachineStatusFromFile(machine, configFileName);
        saveHistoryActionToFile("Started, status: " + machine);

        do {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");

            String action = scanner.nextLine();

            switch (action) {
                case "remaining":
                    printCoffeeMachineStatus(machine);
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
                    saveCoffeeMachineStatusToFile(machine, configFileName);
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
                c = new CoffeeCup("Espresso", 250, 0, 16, 4);
                break;
            case 2:
                c = new CoffeeCup("Latte", 350, 75, 20, 7);
                break;
            case 3:
                c = new CoffeeCup("Cappuccino", 200, 100, 12, 6);
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
            saveHistoryActionToFile("Bought cup: " + c, historyFileName);
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
        saveHistoryActionToFile("Filled, current status:  " + machine, historyFileName);
    }

    private static void processActionTake(CoffeeMachine machine) {
        System.out.println("I gave you $" + machine.getCurrentEarnings());
        machine.setCurrentEarnings(0);
        saveHistoryActionToFile("Money taken, current status: " + machine, historyFileName);
    }

    private static void printCoffeeMachineStatus(CoffeeMachine machine) {
        System.out.println("\nThe coffee machine has: ");
        System.out.printf("%d ml of water\n", machine.getCurrentWater());
        System.out.printf("%d ml of milk\n", machine.getCurrentMilk());
        System.out.printf("%d ml of coffee beans\n", machine.getCurrentCoffee());
        System.out.printf("%d disposable cups\n", machine.getDisposableCups());
        System.out.printf("$%d of money\n", machine.getCurrentEarnings());
    }

    /**
     * Reads from file
     * File format (2 lines):
     * Water, Milk, Coffee, Cups, Money
     * {water}, {milk}, {coffee}, {cups}, {money}
     *
     *
     * Example:
     * Water, Milk, Coffee, Cups, Money
     * 1000, 1200, 800, 10, 200
     *
     * @param machine
     * @param fileName
     */
    private static void loadCoffeeMachineStatusFromFile(CoffeeMachine machine, String fileName) {
        try {
            Scanner fileScanner = new Scanner(new FileReader(new File(fileName)));
            fileScanner.useDelimiter(", ");

            // read header line
            fileScanner.nextLine();

            machine.setCurrentWater(fileScanner.nextInt());
            machine.setCurrentMilk(fileScanner.nextInt());
            machine.setCurrentCoffee(fileScanner.nextInt());
            machine.setDisposableCups(fileScanner.nextInt());
            machine.setCurrentEarnings(fileScanner.nextInt());
        } catch (FileNotFoundException e) {
            System.out.println("Coffee machine file doesn't exists!");

        } catch (Exception e) {
            System.out.println("Input file is not in right format!");
        }

    }

    public static void saveCoffeeMachineStatusToFile(CoffeeMachine machine, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("Water, Milk, Coffee, Cups, Money\n");
            writer.write(machine.getCurrentWater() + ", " + machine.getCurrentMilk() + ", " +
                             machine.getCurrentCoffee() + ", " + machine.getDisposableCups() + ", " + machine.getCurrentEarnings());

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void saveHistoryActionToFile(String text) {
        saveHistoryActionToFile(text, historyFileName);
    }

    public static void saveHistoryActionToFile(String text, String fileName) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");


            FileWriter writer = new FileWriter(fileName, true);
            writer.write(sdf.format(new java.util.Date()) + " " + text + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
