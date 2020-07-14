package lesson3.Model;

public class Statistic {
    private String maker;
    private int sold;
    private int totalMoney;

    public Statistic() {
    }

    public Statistic(String maker, int sold, int totalMoney) {
        this.maker = maker;
        this.sold = sold;
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "maker='" + maker + '\'' +
                ", sold=" + sold +
                ", totalMoney=" + totalMoney +
                '}';
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getTotalMoney() {
        return this.totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }
}
