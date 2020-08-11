package ThueXe;

import ThueXe.Model.DangKyCungCap;
import ThueXe.Model.DongXe;
import ThueXe.Model.HangXe;
import ThueXe.Model.NhaCungCap;
import ThueXe.Service.ThueXeServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ThueXeServices thueXeServices = new ThueXeServices();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------CHỨC NĂNG----------");
        System.out.println("1. Liệt kê những dòng xe có số chỗ ngồi trên 5 chỗ");
        System.out.println("2. Liệt kê thông tin của các nhà cung cấp ĐÃ TỪNG đăng ký cung cấp những dòng xe\n" +
                "thuộc hãng xe “Toyota” với mức phí có đơn giá là 15.000 VNĐ/km hoặc những dòng xe\n" +
                "thuộc hãng xe “KIA” với mức phí có đơn giá là 20.000 VNĐ/km");
        System.out.println("3. Liệt kê thông tin toàn bộ nhà cung cấp được sắp xếp tăng dần theo tên nhà cung\n" +
                "cấp và giảm dần theo mã số thuế");
        System.out.println("4. Đếm số lần đăng ký cung cấp phương tiện tương ứng cho từng nhà cung cấp với\n" +
                "yêu cầu chỉ đếm cho những nhà cung cấp thực hiện đăng ký cung cấp có ngày bắt đầu\n" +
                "cung cấp là “20/11/2015”");
        System.out.println(" 5. Liệt kê tên của toàn bộ các hãng xe có trong cơ sở dữ liệu với yêu cầu mỗi hãng xe\n" +
                "chỉ được liệt kê một lần");
        System.out.println("6. Liệt kê MaDKCC, MaNhaCC, TenNhaCC, DiaChi, MaSoThue, TenLoaiDV, DonGia,\n" +
                "HangXe, NgayBatDauCC, NgayKetThucCC của tất cả các lần đăng ký cung cấp phương\n" +
                "tiện với yêu cầu những nhà cung cấp nào chưa từng thực hiện đăng ký cung cấp phương\n" +
                "tiện thì cũng liệt kê thông tin những nhà cung cấp đó ra");
        System.out.println("7. Liệt kê thông tin của các nhà cung cấp đã từng đăng ký cung cấp phương tiện\n" +
                "thuộc dòng xe “Hiace” hoặc từng đăng ký cung cấp phương tiện thuộc dòng xe “Cerato”");
        System.out.println("8. Liệt kê thông tin của các nhà cung cấp chưa từng thực hiện đăng ký cung cấp\n" +
                "phương tiện lần nào cả.");
        do {
            System.out.println("\nNhập lựa chọn:");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 :
                    List<DongXe> dongXes = new ArrayList<>();
                dongXes = thueXeServices.chucnang1();
                for (DongXe xe : dongXes) {
                    System.out.println(xe.toString());

                }
                break;
                case 2 :
                    List<NhaCungCap> nhaCungCaps = new ArrayList<>();
                    nhaCungCaps = thueXeServices.chucnang2();
                    for(NhaCungCap ncc : nhaCungCaps){
                        System.out.println(ncc.toString());
                    }
                    break;
                case 3 : List<NhaCungCap> nhaCungCaps1 = new ArrayList<>();
                    nhaCungCaps1 = thueXeServices.chucnang3();
                    for(NhaCungCap ncc  : nhaCungCaps1){
                        System.out.println(ncc.toString());
                    }
                    break;
                case 4 :
                    List <NhaCungCap> nhaCungCaps2 = new ArrayList<>();
                    nhaCungCaps2 = thueXeServices.chucnang4();
                    for(NhaCungCap ncc : nhaCungCaps2){
                        System.out.println("MaCC : " + ncc.getMaNhaCC() + "  ,TenNCC : " + ncc.getTenNhaCC() + " ,SoLanDK" + ncc.getSoLanDK());
                    }
                    break;
                case 5:
                    List<HangXe> hangXes = new ArrayList<>();
                    hangXes = thueXeServices.chucnang5();
                    for(HangXe hx : hangXes){
                        System.out.println("HangXe : " + hx.getHangXe());
                    }
                    break;
                case 6 :
                    List<DangKyCungCap> dangKyCungCaps = new ArrayList<>();
                    dangKyCungCaps = thueXeServices.chucnang6();
                    for(DangKyCungCap dkcc : dangKyCungCaps ){
                        System.out.println(dkcc.toString());
                    }
                    break;
                case 7 :
                    List<NhaCungCap> nhaCungCaps3 = new ArrayList<>();
                    nhaCungCaps3 = thueXeServices.chucnang7();
                    for(NhaCungCap ncc : nhaCungCaps3){
                        System.out.println(ncc.toString());
                    }
                    break;
                case 8 :
                    List <NhaCungCap> nhaCungCaps4 = new ArrayList<>();
                    nhaCungCaps4 = thueXeServices.chucnang8();
                    for(NhaCungCap ncc : nhaCungCaps4){
                        System.out.println(ncc.toString());
                    }
                    break;
            }

        }while(true);
    }
}
