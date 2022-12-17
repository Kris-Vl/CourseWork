package CoffeeVan;

import java.sql.SQLException;

public class CoffeeVan {
    private static int totalVolume;
    public static int getTotalVolume()
    {
        return totalVolume;
    }

    public CoffeeVan(int totalVolume) throws SQLException
    {
        CoffeeVan.totalVolume = totalVolume;
    }
}