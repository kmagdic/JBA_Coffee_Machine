package machine;

public class CoffeeCup {
    String name;
    int waterNeeded;
    int milkNeeded;
    int coffeeNeeded;
    int cost;


    public CoffeeCup(String name, int waterNeeded, int milkNeeded, int coffeeNeeded, int cost) {
        this.name = name;
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

    @Override
    public String toString() {
        return "CoffeeCup{" +
                "name='" + name + '\'' +
                ", waterNeeded=" + waterNeeded +
                ", milkNeeded=" + milkNeeded +
                ", coffeeNeeded=" + coffeeNeeded +
                ", cost=" + cost +
                '}';
    }
}
