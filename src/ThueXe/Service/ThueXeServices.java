package ThueXe.Service;

import ThueXe.Model.DangKyCungCap;
import ThueXe.Model.DongXe;
import ThueXe.Model.HangXe;
import ThueXe.Model.NhaCungCap;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class ThueXeServices {
    private Connection connection1;

    public Connection getConnections() {
        try {
            connection1 = getConnection("jdbc:mysql://127.0.0.1:3306/thue_xe_cms", "root", "ngochoatuyen");
            return connection1;
        } catch (Exception e) {
            System.out.println("Loi khi connect database" + e);
        }
        return null;
    }

    public ThueXeServices() {
    }

    public ThueXeServices(Connection connection1) {
        this.connection1 = connection1;
    }

    public List<DongXe> chucnang1() {
        try {
            List<DongXe> dongXes = new ArrayList<>();
            String sql = "SELECT * FROM dongxe WHERE SoChoNgoi > 5";
            Statement statement = getConnections().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                DongXe dongXe = new DongXe();
                dongXe.setDongXe(resultSet.getString(1));
                dongXe.setHangXe(resultSet.getString(2));
                dongXe.setSoChoNgoi(resultSet.getInt(3));
                dongXes.add(dongXe);
            }
            return dongXes;
        } catch (Exception e) {
            System.out.println("Bi loi khi tim kiem ");
            return null;
        }
    }

    public List<NhaCungCap> chucnang2() {
        try {
            List<NhaCungCap> nhaCungCaps = new ArrayList<>();
            String sql = "SELECT ncc.* FROM dangkycungcap dkcc " +
                    "INNER JOIN nhacungcap ncc ON dkcc.MaNhaCC = ncc.MaNhaCC\n" +
                    "INNER JOIN mucphi mp ON dkcc.MaMP = mp.MaMP\n" +
                    "INNER JOIN dongxe dx ON dkcc.DongXe = dx.DongXe\n" +
                    "WHERE DONGIA = 15000 AND HangXe = 'Toyota'\n" +
                    "OR DONGIA = 20000 AND HangXe = 'KIA' ";
            Statement statement = getConnections().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                NhaCungCap nhaCungCap = new NhaCungCap();
                nhaCungCap.setMaNhaCC(resultSet.getString(1));
                nhaCungCap.setTenNhaCC(resultSet.getString(2));
                nhaCungCap.setDiaChi(resultSet.getString(3));
                nhaCungCap.setSDT(resultSet.getString(4));
                nhaCungCap.setMaSoThue(resultSet.getString(5));
                nhaCungCaps.add(nhaCungCap);

            }

            return nhaCungCaps;
        } catch (Exception e) {
            System.out.println("Bi loi khi tim kiem ");
            return null;
        }
    }

    public List<NhaCungCap> chucnang3() {
        try {
            List<NhaCungCap> nhaCungCaps = new ArrayList<>();
            String sql = "SELECT * FROM nhacungcap ORDER BY TenNhaCC ASC , MaSoThue DESC ";
            Statement statement = getConnections().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                NhaCungCap nhaCungCap = new NhaCungCap();
                nhaCungCap.setMaNhaCC(resultSet.getString(1));
                nhaCungCap.setTenNhaCC(resultSet.getString(2));
                nhaCungCap.setDiaChi(resultSet.getString(3));
                nhaCungCap.setSDT(resultSet.getString(4));
                nhaCungCap.setMaSoThue(resultSet.getString(5));
                nhaCungCaps.add(nhaCungCap);

            }
            return nhaCungCaps;

        } catch (Exception e) {
            System.out.println("Bi loi khi tim kiem ");
            return null;
        }
    }

    public List<NhaCungCap> chucnang4() {
        try {
            List<NhaCungCap> nhaCungCaps = new ArrayList<>();
            String sql = "SELECT dkcc.MaNhaCC , ncc.TenNhaCC,COUNT(TenNhaCC) AS 'SoLanDK' FROM dangkycungcap dkcc\n" +
                    "INNER JOIN nhacungcap ncc ON dkcc.MaNhaCC = ncc.MaNhaCC\n" +
                    "WHERE dkcc.NgayBatDauCungCap LIKE '%2015-11-20%'\n" +
                    "GROUP BY ncc.TenNhaCC";
            Statement statement = getConnections().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                NhaCungCap nhaCungCap = new NhaCungCap();
                nhaCungCap.setMaNhaCC(resultSet.getString(1));
                nhaCungCap.setTenNhaCC(resultSet.getString(2));
                nhaCungCap.setSoLanDK(resultSet.getInt(3));
                nhaCungCaps.add(nhaCungCap);
            }
            return nhaCungCaps;
        } catch (Exception e) {
            System.out.println("Bi Loi khi tim kiem ");
            return null;
        }

    }

    public List<HangXe> chucnang5() {
        try {
            List<HangXe> hangXes = new ArrayList<>();
            String sql = "SELECT distinct HangXe FROM dongxe ";
            Statement statement = getConnections().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                HangXe hangXe = new HangXe();
                hangXe.setHangXe(resultSet.getString(1));
                hangXes.add(hangXe);
            }
            return hangXes;
        } catch (Exception e) {
            System.out.println("Bi loi khi tim kiem ");
            return null;
        }
    }

    public List<DangKyCungCap> chucnang6() {
        try {
            List<DangKyCungCap> dangKyCungCaps = new ArrayList<>();
            String sql = "SELECT dkcc.MaDKCC,ncc.MaNhaCC,ncc.TenNhaCC,ncc.DiaChi,ncc.MaSoThue,ldv.TenLoaiDV,mp.DonGia\n" +
                    "FROM nhacungcap ncc\n" +
                    "LEFT JOIN dangkycungcap dkcc ON dkcc.MaNhaCC = ncc.MaNhaCC\n" +
                    "LEFT JOIN loaidichvu ldv ON dkcc.MaLoaiDV = ldv.MaLoaiDV\n" +
                    "LEFT JOIN mucphi mp ON dkcc.MaMP = mp.MaMP\n" +
                    "LEFT JOIN dongxe dx ON dkcc.DongXe = dx.DongXe";
            Statement statement = getConnections().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                DangKyCungCap dangKyCungCap = new DangKyCungCap();
                dangKyCungCap.setMaDangKyCungCap(resultSet.getString(1));
                dangKyCungCap.setMaNhaCungCap(resultSet.getString(2));
                dangKyCungCap.setTenNhaCungCap(resultSet.getString(3));
                dangKyCungCap.setDiaChiNhaCungCap(resultSet.getString(4));
                dangKyCungCap.setMaSoThueNhaCungCap(resultSet.getString(5));
                dangKyCungCap.setTenLoaiDichVu(resultSet.getString(6));
                dangKyCungCap.setDonGia(resultSet.getInt(7));
                dangKyCungCaps.add(dangKyCungCap);
            }
            return dangKyCungCaps;
        } catch (Exception e) {
            System.out.println("Bi loi khi tim kiem ");
            return null;
        }
    }
    public List<NhaCungCap> chucnang7(){
        try{
            List<NhaCungCap> nhaCungCaps = new ArrayList<>();
            String sql = "SELECT DISTINCT ncc.MaNhaCC,ncc.TenNhacc,ncc.DiaChi,ncc.SoDT,ncc.MaSoThue,dkcc.DongXe \n" +
                    " FROM dangkycungcap dkcc \n" +
                    "INNER JOIN nhacungcap ncc ON dkcc.MaNhaCC = ncc.MaNhaCC \n" +
                    "WHERE dkcc.dongxe = 'CERATO' OR dkcc.dongxe = 'Hiace'";
            Statement statement = getConnections().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                NhaCungCap nhaCungCap = new NhaCungCap();
                nhaCungCap.setMaNhaCC(resultSet.getString(1));
                nhaCungCap.setTenNhaCC(resultSet.getString(2));
                nhaCungCap.setDiaChi(resultSet.getString(3));
                nhaCungCap.setSDT(resultSet.getString(4));
                nhaCungCap.setMaSoThue(resultSet.getString(5));
                nhaCungCap.setDongXe(resultSet.getString(6));
                nhaCungCaps.add(nhaCungCap);
            }
            return nhaCungCaps;
        }catch (Exception e ){
            System.out.println("Bi loi khi tim tiem  ");
            return null;
        }
    }
    public List<NhaCungCap> chucnang8(){
        try {
            List<NhaCungCap> nhaCungCaps = new ArrayList<>();
            String sql = "SELECT ncc.MaNhaCC, ncc.TenNhaCC, ncc.DiaChi, ncc.SoDT, ncc.MaSoThue\n" +
                    "FROM nhacungcap ncc\n" +
                    "LEFT JOIN dangkycungcap dkcc ON ncc.MaNhaCC = dkcc.MaNhaCC\n" +
                    "WHERE dkcc.MaNhaCC IS NULL;\n";
            Statement statement = getConnections().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                NhaCungCap nhaCungCap = new NhaCungCap();
                nhaCungCap.setMaNhaCC(resultSet.getString(1));
                nhaCungCap.setTenNhaCC(resultSet.getString(2));
                nhaCungCap.setDiaChi(resultSet.getString(3));
                nhaCungCap.setSDT(resultSet.getString(4));
                nhaCungCap.setMaSoThue(resultSet.getString(5));
                nhaCungCaps.add(nhaCungCap);

            }

            return nhaCungCaps;
        } catch (Exception e) {
            System.out.println("Bi loi khi tim kiem ");
            return null;
        }
    }
}

