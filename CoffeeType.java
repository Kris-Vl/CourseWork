package CoffeeVan.Coffee;

public enum CoffeeType {
    Арабіка(5),
    Робуста(10),
    Ліберіка(15),
    Ексцельса(12),
    Медельїн(7);

    private final double cost;
    CoffeeType(double cost){
        this.cost = cost;
    }

    public double getCost()
    {
        return cost;
    }

}
