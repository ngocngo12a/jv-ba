package ThueXe.Model;

public class DongXe {
    private String DongXe;
    private String HangXe;
    private int SoChoNgoi;

    public DongXe() {
    }

    public DongXe(String dongXe, String hangXe, int soChoNgoi) {
        DongXe = dongXe;
        HangXe = hangXe;
        SoChoNgoi = soChoNgoi;
    }

    @Override
    public String toString() {
        return "DongXe{" +
                "DongXe='" + DongXe + '\'' +
                ", HangXe='" + HangXe + '\'' +
                ", SoChoNgoi=" + SoChoNgoi +
                '}';
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

    public int getSoChoNgoi() {
        return SoChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        SoChoNgoi = soChoNgoi;
    }
}
