package machine;

public class CoffeeCup {

    int waterNeeded;
    int milkNeeded;
    int coffeeNeeded;
    int cost;


    public CoffeeCup(int waterNeeded, int milkNeeded, int coffeeNeeded, int cost) {
        this.waterNeeded = waterNeeded;
        this.milkNeeded = milkNeeded;
        this.coffeeNeeded = coffeeNeeded;
        this.cost = cost;
    }

    public int getWaterNeeded() {
        return waterNeeded;
    }



    public int getMilkNeeded() {
        return milkNeeded;
    }


    public int getCoffeeNeeded() {
        return coffeeNeeded;
    }


    public int getCost() {
        return cost;
    }

}
