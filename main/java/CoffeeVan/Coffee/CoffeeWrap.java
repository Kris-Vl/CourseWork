package CoffeeVan.Coffee;

public enum CoffeeWrap {
    Паперове(10, 2, 3),
    Скляне(25, 3, 7),
    Пластикове(15, 5, 5);

    private final int volume;
    private final int wrapVolume;
    private final double cost;


    CoffeeWrap(int volume, int wrapVolume, double cost) {
        this.volume = volume;
        this.wrapVolume = wrapVolume;
        this.cost = cost;
    }

    public int getWrapVolume()
    {
        return this.wrapVolume;
    }

    public double getCost()
    {
        return cost;
    }

    public int getVolume()
    {
        return volume;
    }
}
