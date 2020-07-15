package lesson3.Services;

import lesson3.Model.Counter;
import lesson3.Model.LaptopModel;
import lesson3.Model.Statistic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;


public class LaptopServices {
    private Connection connection;
    public Connection getConnections() {
        try{
            connection = getConnection("jdbc:mysql://127.0.0.1:3306/store_cms_plusplus","root","ngochoatuyen");
            return connection;
        }
        catch (Exception e){
            System.out.println("Loi khi connect database" + e);
        }
        return null;
}

    public LaptopServices() {
    }

    public LaptopServices(Connection connection) {
        this.connection = connection;
    }
    public List<LaptopModel> searchLaptop(String maker, Float fromPrice, Float toPrice, String cpu, String ram, String card, Float screeenSize) {
        String sql = "SELECT * FROM laptop WHERE TRUE ";
        if (maker != null) {
            sql += " AND maker = '" + maker + "'";
        }
        if (fromPrice != null) {
            sql += " AND price >= " + fromPrice;
        }
        if (toPrice != null) {
            sql += " AND price <= " + toPrice;
        }
        if (cpu != null) {
            sql += " AND cpu LIKE '%" + cpu + "%'";
        }
        if (ram != null) {
            sql += " AND ram = '" + ram + "'";
        }
        if (card != null) {
            sql += " AND card = '" + card + "'";
        }
        if (screeenSize != null) {
            sql += " AND screen_size = '" + screeenSize + "'";
        }

        return queryDB(sql);
    }
    public List<Counter> GetCounterByMaker(){
        try {
            List<Counter> counters = new ArrayList<>();

            String sql = "SELECT maker,COUNT(*) AS quantity FROM laptop GROUP BY maker ORDER BY quantity DESC ";
            Statement statement = getConnections().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Counter counter = new Counter(
                        resultSet.getString(1),resultSet.getInt(2)
                );
                counters.add(counter);
            }
            return counters;
        }catch (Exception e){
            System.out.println("" +e);
            return null;
        }


    }
    public List<Statistic>  getStatisticByMaker(){
        try{
            List<Statistic> statistics = new ArrayList<>();
            String sql = "SELECT maker, sum(sold) AS sold, sum(price*sold) AS totalMoney FROM store_cms_plusplus.laptop GROUP BY maker ORDER BY sold DESC";
            Statement statement = getConnections().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Statistic statistic = new Statistic();
                statistic.setMaker(resultSet.getString(1));
                statistic.setSold(resultSet.getInt(2));
                statistic.setTotalMoney(resultSet.getInt(3));
                statistics.add(statistic);
            }
            return statistics;
        }catch (Exception e){
            System.out.println("" +e);
            return null;
        }
    }
    public List<LaptopModel> queryDB(String sql) {
        try {
            List<LaptopModel> laptopModels = new ArrayList<>();
            Statement statement = getConnections().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                LaptopModel laptopModel = new LaptopModel(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getFloat(10),
                        resultSet.getString(11),
                        resultSet.getString(12),
                        resultSet.getFloat(13),
                        resultSet.getInt(14),
                        resultSet.getTimestamp(15),
                        resultSet.getTimestamp(16)
                );
                laptopModels.add(laptopModel);
            }
            return laptopModels;
        } catch (Exception e) {
            System.out.println("Lỗi ------  " + e);
        }
        return null;
    }
}