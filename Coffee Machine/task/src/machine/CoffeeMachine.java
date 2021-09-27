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

    public void printCoffeeMachineStatus() {
        System.out.println("\nThe coffee machine has: ");
        System.out.printf("%d ml of water\n", currentWater);
        System.out.printf("%d ml of milk\n", currentMilk);
        System.out.printf("%d ml of coffee beans\n", currentCoffee);
        System.out.printf("%d disposable cups\n", disposableCups);
        System.out.printf("$%d of money\n", currentEarnings);
    }

    public boolean canMakeCoffeeCup(CoffeeCup c) {
        return currentWater >= c.getWaterNeeded() &&
                currentMilk >= c.getMilkNeeded() &&
                currentCoffee >= c.getCoffeeNeeded() &&
                disposableCups > 0;
    }

    public void makeCoffeeCup(CoffeeCup c) {
        currentWater -= c.getWaterNeeded();
        currentMilk -= c.getMilkNeeded();
        currentCoffee -= c.getCoffeeNeeded();
        disposableCups--;
        currentEarnings += c.getCost();
    }

    public int getCurrentWater() {
        return currentWater;
    }

    public void setCurrentWater(int currentWater) {
        this.currentWater = currentWater;
    }

    public int getCurrentMilk() {
        return currentMilk;
    }

    public void setCurrentMilk(int currentMilk) {
        this.currentMilk = currentMilk;
    }

    public int getCurrentCoffee() {
        return currentCoffee;
    }

    public void setCurrentCoffee(int currentCoffee) {
        this.currentCoffee = currentCoffee;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public void setDisposableCups(int disposableCups) {
        this.disposableCups = disposableCups;
    }

    public int getCurrentEarnings() {
        return currentEarnings;
    }

    public void setCurrentEarnings(int currentEarnings) {
        this.currentEarnings = currentEarnings;
    }
}
