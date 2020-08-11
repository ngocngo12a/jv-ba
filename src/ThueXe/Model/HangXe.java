package ThueXe.Model;

public class HangXe {
    private  String HangXe;

    @Override
    public String toString() {
        return "HangXe{" +
                "HangXe='" + HangXe + '\'' +
                '}';
    }

    public String getHangXe() {
        return HangXe;
    }

    public void setHangXe(String hangXe) {
        HangXe = hangXe;
    }

    public HangXe() {
    }

    public HangXe(String hangXe) {
        HangXe = hangXe;
    }
}
