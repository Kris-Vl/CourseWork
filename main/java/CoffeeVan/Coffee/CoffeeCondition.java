package CoffeeVan.Coffee;

public enum CoffeeCondition {
    Зернова(2),
    Мелена(4),
    Розчинна(5);

    private final double cost;

    CoffeeCondition(double cost)
    {
        this.cost = cost;
    }

    public double getCost()
    {
        return cost;
    }
}
