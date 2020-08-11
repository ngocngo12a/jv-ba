package ThueXe.Model;

public class NhaCungCap {
    private String MaNhaCC;
    private String TenNhaCC;
    private String DiaChi;
    private String SDT;
    private String MaSoThue;
    private  int SoLanDK;
    private String DongXe;

    @Override
    public String toString() {
        return "NhaCungCap{" +
                "MaNhaCC='" + MaNhaCC + '\'' +
                ", TenNhaCC='" + TenNhaCC + '\'' +
                ", DiaChi='" + DiaChi + '\'' +
                ", SDT='" + SDT + '\'' +
                ", MaSoThue='" + MaSoThue + '\'' +
                ", SoLanDK=" + SoLanDK +
                ", DongXe='" + DongXe + '\'' +
                '}';
    }

    public String getMaNhaCC() {
        return MaNhaCC;
    }

    public void setMaNhaCC(String maNhaCC) {
        MaNhaCC = maNhaCC;
    }

    public String getTenNhaCC() {
        return TenNhaCC;
    }

    public void setTenNhaCC(String tenNhaCC) {
        TenNhaCC = tenNhaCC;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMaSoThue() {
        return MaSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        MaSoThue = maSoThue;
    }

    public int getSoLanDK() {
        return SoLanDK;
    }

    public void setSoLanDK(int soLanDK) {
        SoLanDK = soLanDK;
    }

    public String getDongXe() {
        return DongXe;
    }

    public void setDongXe(String dongXe) {
        DongXe = dongXe;
    }

    public NhaCungCap(String maNhaCC, String tenNhaCC, String diaChi, String SDT, String maSoThue, int soLanDK, String dongXe) {
        MaNhaCC = maNhaCC;
        TenNhaCC = tenNhaCC;
        DiaChi = diaChi;
        this.SDT = SDT;
        MaSoThue = maSoThue;
        SoLanDK = soLanDK;
        DongXe = dongXe;
    }

    public NhaCungCap() {
    }
}
