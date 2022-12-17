package CoffeeVan.Coffee;

public class Coffee {

    private final CoffeeType name;
    private final CoffeeCondition condition;
    private final CoffeeWrap wrap;
    private final int volume;
    private final double cost;

    public Coffee(CoffeeType name, CoffeeCondition condition, CoffeeWrap wrap)
    {
        this.name = name;
        this.condition = condition;
        this.wrap = wrap;
        this.volume = wrap.getWrapVolume() + wrap.getVolume();
        this.cost = name.getCost() * wrap.getVolume() + condition.getCost() + wrap.getCost();
    }

    public String getName() { return String.valueOf(name); }
    public String getCondition() { return String.valueOf(condition); }
    public  String getWrap() { return String.valueOf(wrap); }
    public int getVolume()
    {
        return volume;
    }

    public double getCost()
    {
        return cost;
    }

    public String toString() {
        return String.format("( %8s, %7s, %7s %4s %4s)",
                this.name, this.condition, this.wrap,
                this.volume, this.cost);
    }
}
