package DataBase;

import CoffeeVan.Coffee.Coffee;
import CoffeeVan.Coffee.CoffeeCondition;
import CoffeeVan.Coffee.CoffeeType;
import CoffeeVan.Coffee.CoffeeWrap;
import CoffeeVan.CoffeeVan;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {
    private static Connection connection;

    public DBHandler() throws SQLException, IOException {
        String User = "root";
        String Password = "kris4826";
        String Host = "localhost";
        String Port = "3306";
        String DatabaseName = "CoffeeVan";
        String ConnactionString = "jdbc:mysql://" + Host + ":" + Port + "/" + DatabaseName;
        try {
            connection = DriverManager.getConnection(ConnactionString, User, Password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static CoffeeVan van;
    static {
        try {
            van = new CoffeeVan(1000);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Coffee> getCoffee() throws SQLException, IOException {
        List<Coffee> coffee = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select CoffeeType, CoffeeCondition, CoffeeWrap from Coffee;");
        while (resultSet.next())
        {
            CoffeeType name = CoffeeType.valueOf(resultSet.getString(1));
            CoffeeCondition condition = CoffeeCondition.valueOf(resultSet.getString(2));
            CoffeeWrap wrap = CoffeeWrap.valueOf(resultSet.getString(3));
            coffee.add(new Coffee(name, condition, wrap));
        }
        return coffee;
    }

    public static String getUsedVolume() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select sum(Volume) as UsedVolume from Coffee;");
        resultSet.next();
        return resultSet.getString("UsedVolume");
    }

    public static String getCost() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select sum(Cost) as ProductCost from Coffee"+";");
        resultSet.next();
        return resultSet.getString("ProductCost");
    }

    private static boolean IfStorageFull(double volume) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select sum(Volume) as UsedVolume FROM Coffee"+";");
        resultSet.next();
        double usedvol = resultSet.getDouble("UsedVolume");
        return usedvol + volume <= van.getTotalVolume();
    }

    public static boolean deleteCoffee(Coffee coffee){
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from Coffee where CoffeeType = '" + coffee.getName() +
                    "' and CoffeeCondition = '" + coffee.getCondition() + "' and CoffeeWrap = '" + coffee.getWrap() + "';");
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public static boolean addCoffee(Coffee coffee){
        try {
            Statement statement = connection.createStatement();
            if(IfStorageFull(coffee.getVolume())) {
                statement.executeUpdate("insert into Coffee(CoffeeType, CoffeeCondition, CoffeeWrap, Volume, Cost) " +
                        "values('" + coffee.getName() + "','" + coffee.getCondition() + "','" + coffee.getWrap() + "', "
                        + coffee.getVolume() + ", " + coffee.getCost() + ");");
                return true;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    public static List<Coffee> SortbyName() throws SQLException {
        List<Coffee> coffee = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select CoffeeType, CoffeeCondition, CoffeeWrap from CoffeeVan.Coffee order by Coffee.CoffeeType");
        while (resultSet.next())
        {
            CoffeeType name = CoffeeType.valueOf(resultSet.getString(1));
            CoffeeCondition condition = CoffeeCondition.valueOf(resultSet.getString(2));
            CoffeeWrap wrap = CoffeeWrap.valueOf(resultSet.getString(3));
            coffee.add(new Coffee(name, condition, wrap));
        }
        return coffee;
    }

    public static List<Coffee> SortbyVolume() throws SQLException {
        List<Coffee> coffee = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select CoffeeType, CoffeeCondition, CoffeeWrap from Coffee order by Coffee.Volume desc;");
        while (resultSet.next())
        {
            CoffeeType name = CoffeeType.valueOf(resultSet.getString(1));
            CoffeeCondition condition = CoffeeCondition.valueOf(resultSet.getString(2));
            CoffeeWrap wrap = CoffeeWrap.valueOf(resultSet.getString(3));
            coffee.add(new Coffee(name, condition, wrap));
        }
        return coffee;
    }

    public static List<Coffee> SortbyCost() throws SQLException {
        List<Coffee> coffee = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select CoffeeType, CoffeeCondition, CoffeeWrap from Coffee order by Coffee.Cost desc;");
        while (resultSet.next())
        {
            CoffeeType name = CoffeeType.valueOf(resultSet.getString(1));
            CoffeeCondition condition = CoffeeCondition.valueOf(resultSet.getString(2));
            CoffeeWrap wrap = CoffeeWrap.valueOf(resultSet.getString(3));
            coffee.add(new Coffee(name, condition, wrap));
        }
        return coffee;
    }

    public static List<Coffee> FindbyVolume(int min, int max) throws SQLException {
        List<Coffee> coffee = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select CoffeeType, CoffeeCondition, CoffeeWrap from Coffee "
                + "where Volume > " + min + " and Volume < " + max + ";");
        while (resultSet.next())
        {
            CoffeeType name = CoffeeType.valueOf(resultSet.getString(1));
            CoffeeCondition condition = CoffeeCondition.valueOf(resultSet.getString(2));
            CoffeeWrap wrap = CoffeeWrap.valueOf(resultSet.getString(3));
            coffee.add(new Coffee(name, condition, wrap));
        }
        return coffee;
    }

    public static List<Coffee> FindbyCost(double min, double max) throws SQLException {
        List<Coffee> coffee = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select CoffeeType, CoffeeCondition, CoffeeWrap from Coffee "
                + "where Cost > " + min + " and Cost < " + max + ";");
        while (resultSet.next())
        {
            CoffeeType name = CoffeeType.valueOf(resultSet.getString(1));
            CoffeeCondition condition = CoffeeCondition.valueOf(resultSet.getString(2));
            CoffeeWrap wrap = CoffeeWrap.valueOf(resultSet.getString(3));
            coffee.add(new Coffee(name, condition, wrap));
        }
        return coffee;
    }
}
