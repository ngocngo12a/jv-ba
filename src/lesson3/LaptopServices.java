package lesson3;

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

    public List<LaptopModel> findAllByMaker(String maker) {
        try {
            List<LaptopModel> laptopModels = new ArrayList<>();
            Statement statement = getConnections().createStatement();
            ResultSet rs = statement.executeQuery("select * from laptop WHERE maker = '" + maker + "'   ");
            while (rs.next()) {
                LaptopModel laptopModel = new LaptopModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getFloat(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getFloat(13),
                        rs.getInt(14),
                        rs.getTimestamp(15),
                        rs.getTimestamp(16)
                );
                laptopModels.add(laptopModel);

            }
            return laptopModels;
        }catch( Exception e){
            System.out.println("Loi khi tim kiem san pham bang maker");
        }
        return null;

    }
    public List<LaptopModel> findAllByPrice(Float priceFrom, Float priceTo) {
        try {
            List<LaptopModel> laptopModels = new ArrayList<>();
            Statement statement = getConnections().createStatement();
            String sql = "SELECT * FROM laptop WHERE price BETWEEN '" + priceFrom + "'" + "AND '" + priceTo + "'";
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
            System.out.println("Loi khi tim kiem bang price" + e);
        }
        return null;
    }
    public List<LaptopModel> findAllByMakerAndSSD(String maker, String gb) {
        try {
            List<LaptopModel> laptopModels = new ArrayList<>();
            Statement statement = getConnections().createStatement();
            String sql = "SELECT * FROM laptop WHERE maker = '" + maker + "'" + "AND ( ssd = '" + gb + "' " + "OR hdd = '"+ gb + "'" +") ";
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
            System.out.println("loi khi tim kiem theo o cung va maker" + e);
        }
        return null;
    }
    public List<LaptopModel> findAllByScreensize(String Screensize){
        try {
            List<LaptopModel> laptopModels = new ArrayList<>();
            Statement statement = getConnections().createStatement();
            String sql = "SELECT * FROM laptop WHERE screen_size = '" + Screensize + "' ";
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
            System.out.println("Lỗi khi tìm kiếm theo screenSize" + e);
        }
        return null;
    }
    public List<LaptopModel> findAllByRam (String ram){
        try {
            List<LaptopModel> laptopModels = new ArrayList<>();
            Statement statement = getConnections().createStatement();
            String sql = "SELECT * FROM laptop WHERE ram = '" + ram + "' ";
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
            System.out.println("Lỗi khi tìm kiếm theo ram" + e);
        }
        return null;
    }
    public List <LaptopModel> findAllByCPU (String CPU){
        try {
            List<LaptopModel> laptopModels = new ArrayList<>();
            Statement statement = getConnections().createStatement();
            String sql = "SELECT * FROM laptop WHERE cpu = '" + CPU + "' ";
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
            System.out.println("Lỗi khi tìm kiếm theo CPU " + e);
        }
        return null;
    }
    public List<LaptopModel> findAllByType(String Type){
        try {
            List<LaptopModel> laptopModels = new ArrayList<>();
            Statement statement = getConnections().createStatement();
            String sql = "SELECT * FROM laptop WHERE type = '" + Type + "' ";
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
            System.out.println("Lỗi khi tìm kiếm theo type " + e);
        }
        return null;
    }
    public List<LaptopModel> findAllByCard(String Card){
        try {
            List<LaptopModel> laptopModels = new ArrayList<>();
            Statement statement = getConnections().createStatement();
            String sql = "SELECT * FROM laptop WHERE card = '" + Card + "' ";
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
            System.out.println("Lỗi khi tìm kiếm theo card " + e);
        }
        return null;
    }
    List <LaptopModel> findAllBySold(){
        try {
            List<LaptopModel> laptopModels = new ArrayList<>();
            Statement statement = getConnections().createStatement();
            String sql = "SELECT * FROM laptop ORDER BY `sold` DESC ";
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
            System.out.println("Lỗi khi tìm kiếm theo sold " + e);
        }
        return null;
    }

}