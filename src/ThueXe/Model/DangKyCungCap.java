package ThueXe.Model;

import java.util.Date;

public class DangKyCungCap {
    private String MaDangKyCungCap;
    private Integer SoLuongXeDangKy;
    private String MaLoaiDichVu;
    private String DongXe;
    private String HangXe;
    private String MaMucPhi;
    private Integer DonGia;
    private Integer SoLanDangKy;
    private String MaNhaCungCap;
    private String TenNhaCungCap;
    private String DiaChiNhaCungCap;
    private String MaSoThueNhaCungCap;
    private String TenLoaiDichVu;
    private String SoDienThoai;
    private Date NgayBatDauCungCap;
    private Date NgayKetThucCungCap;

    public DangKyCungCap() {
    }

    @Override
    public String toString() {
        return "DangKyCungCap{" +
                "MaDangKyCungCap='" + MaDangKyCungCap + '\'' +
                ", SoLuongXeDangKy=" + SoLuongXeDangKy +
                ", MaLoaiDichVu='" + MaLoaiDichVu + '\'' +
                ", DongXe='" + DongXe + '\'' +
                ", HangXe='" + HangXe + '\'' +
                ", MaMucPhi='" + MaMucPhi + '\'' +
                ", DonGia=" + DonGia +
                ", SoLanDangKy=" + SoLanDangKy +
                ", MaNhaCungCap='" + MaNhaCungCap + '\'' +
                ", TenNhaCungCap='" + TenNhaCungCap + '\'' +
                ", DiaChiNhaCungCap='" + DiaChiNhaCungCap + '\'' +
                ", MaSoThueNhaCungCap='" + MaSoThueNhaCungCap + '\'' +
                ", TenLoaiDichVu='" + TenLoaiDichVu + '\'' +
                ", SoDienThoai='" + SoDienThoai + '\'' +
                ", NgayBatDauCungCap=" + NgayBatDauCungCap +
                ", NgayKetThucCungCap=" + NgayKetThucCungCap +
                '}';
    }

    public String getMaDangKyCungCap() {
        return MaDangKyCungCap;
    }

    public void setMaDangKyCungCap(String maDangKyCungCap) {
        MaDangKyCungCap = maDangKyCungCap;
    }

    public Integer getSoLuongXeDangKy() {
        return SoLuongXeDangKy;
    }

    public void setSoLuongXeDangKy(Integer soLuongXeDangKy) {
        SoLuongXeDangKy = soLuongXeDangKy;
    }

    public String getMaLoaiDichVu() {
        return MaLoaiDichVu;
    }

    public void setMaLoaiDichVu(String maLoaiDichVu) {
        MaLoaiDichVu = maLoaiDichVu;
    }

    public String getDongXe() {
        return DongXe;
    }

    public void setDongXe(String dongXe) {
        DongXe = dongXe;
    }

    public String getHangXe() {
        return HangXe;
    }

    public void setHangXe(String hangXe) {
        HangXe = hangXe;
    }

    public String getMaMucPhi() {
        return MaMucPhi;
    }

    public void setMaMucPhi(String maMucPhi) {
        MaMucPhi = maMucPhi;
    }

    public Integer getDonGia() {
        return DonGia;
    }

    public void setDonGia(Integer donGia) {
        DonGia = donGia;
    }

    public Integer getSoLanDangKy() {
        return SoLanDangKy;
    }

    public void setSoLanDangKy(Integer soLanDangKy) {
        SoLanDangKy = soLanDangKy;
    }

    public String getMaNhaCungCap() {
        return MaNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        MaNhaCungCap = maNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return TenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        TenNhaCungCap = tenNhaCungCap;
    }

    public String getDiaChiNhaCungCap() {
        return DiaChiNhaCungCap;
    }

    public void setDiaChiNhaCungCap(String diaChiNhaCungCap) {
        DiaChiNhaCungCap = diaChiNhaCungCap;
    }

    public String getMaSoThueNhaCungCap() {
        return MaSoThueNhaCungCap;
    }

    public void setMaSoThueNhaCungCap(String maSoThueNhaCungCap) {
        MaSoThueNhaCungCap = maSoThueNhaCungCap;
    }

    public String getTenLoaiDichVu() {
        return TenLoaiDichVu;
    }

    public void setTenLoaiDichVu(String tenLoaiDichVu) {
        TenLoaiDichVu = tenLoaiDichVu;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public Date getNgayBatDauCungCap() {
        return NgayBatDauCungCap;
    }

    public void setNgayBatDauCungCap(Date ngayBatDauCungCap) {
        NgayBatDauCungCap = ngayBatDauCungCap;
    }

    public Date getNgayKetThucCungCap() {
        return NgayKetThucCungCap;
    }

    public void setNgayKetThucCungCap(Date ngayKetThucCungCap) {
        NgayKetThucCungCap = ngayKetThucCungCap;
    }

    public DangKyCungCap(String maDangKyCungCap, Integer soLuongXeDangKy, String maLoaiDichVu, String dongXe, String hangXe, String maMucPhi, Integer donGia, Integer soLanDangKy, String maNhaCungCap, String tenNhaCungCap, String diaChiNhaCungCap, String maSoThueNhaCungCap, String tenLoaiDichVu, String soDienThoai, Date ngayBatDauCungCap, Date ngayKetThucCungCap) {
        MaDangKyCungCap = maDangKyCungCap;
        SoLuongXeDangKy = soLuongXeDangKy;
        MaLoaiDichVu = maLoaiDichVu;
        DongXe = dongXe;
        HangXe = hangXe;
        MaMucPhi = maMucPhi;
        DonGia = donGia;
        SoLanDangKy = soLanDangKy;
        MaNhaCungCap = maNhaCungCap;
        TenNhaCungCap = tenNhaCungCap;
        DiaChiNhaCungCap = diaChiNhaCungCap;
        MaSoThueNhaCungCap = maSoThueNhaCungCap;
        TenLoaiDichVu = tenLoaiDichVu;
        SoDienThoai = soDienThoai;
        NgayBatDauCungCap = ngayBatDauCungCap;
        NgayKetThucCungCap = ngayKetThucCungCap;
    }
}
