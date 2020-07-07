package lesson3;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        LaptopServices laptopService = new LaptopServices();

        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------CHỨC NĂNG----------");
        System.out.println("1. Tìm kiếm laptop theo hãng sản xuất");
        System.out.println("2. Tìm kiếm laptop theo khoảng giá");
        System.out.println("3. Tìm kiếm laptop theo loại ổ cứng và hãng sản xuất");
        System.out.println("4. Tìm kiếm laptop theo kích thước màn hình");
        System.out.println("5. Tìm kiếm theo Ram laptop");
        System.out.println("6. Tìm kiếm theo CPU ");
        System.out.println("7. Tìm kiếm theo loại máy tính");
        System.out.println("8. Tìm kiếm theo card ");
        System.out.println("9. Tìm kiếm danh sách laptop bán chạy nhất");

        do {
            System.out.println("\nNhập lựa chọn:");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Nhập vào tên hãng :");
                    String maker = scanner.nextLine();
                    List<LaptopModel> laptopModels = laptopService.findAllByMaker(maker.trim().toUpperCase());

                    if (laptopModels == null || laptopModels.isEmpty()) {
                        System.out.println("Không tìm thấy ");
                    } else {
                        for (LaptopModel laptopModel : laptopModels) {
                            System.out.println("Tên sản phẩm: " + laptopModel.getName() + "  -  Mức giá: " + laptopModel.getPrice() + "VND");
                        }
                    }
                    break;

                case 2:
                    System.out.println("Nhập vào khoảng giá :");
                    System.out.println("Giá mim =: ");
                    Float priceFrom = scanner.nextFloat();
                    System.out.println("Giá max = ");
                    Float priceTo = scanner.nextFloat();

                    List<LaptopModel> laptopModels1;
                    if (priceFrom == null) {
                        priceFrom = 0.0f;
                    } else if (priceTo == null) {
                        priceTo = 9999999999.9f;
                    } else if (priceFrom == null && priceTo == null) {
                        priceFrom = 0.0f;
                        priceTo = 9999999999.9f;
                    }
                    laptopModels1 = laptopService.findAllByPrice(priceFrom, priceTo);

                    if (laptopModels1 == null || laptopModels1.isEmpty()) {
                        System.out.println("Không tìm thấy thông tin sản phẩm.");
                    } else {
                        for (LaptopModel laptopModel : laptopModels1) {
                            System.out.println("Tên sản phẩm: " + laptopModel.getName() + "  -  Mức giá: " + laptopModel.getPrice() + "VND");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Nhập vào tên hãng :");
                    String makers = scanner.nextLine();
                    System.out.println("Nhập vào dung lượng ổ cứng : ");
                    String gb = scanner.nextLine();

                    List<LaptopModel> laptopModels2 = laptopService.findAllByMakerAndSSD(makers.trim().toUpperCase(), gb);

                    if (laptopModels2 == null || laptopModels2.isEmpty()) {
                        System.out.println("Không tìm thấy thông tin ");
                    } else {
                        for (LaptopModel laptopModel : laptopModels2) {
                            String priceOfProduct = laptopModel.getPrice().toString();
                            System.out.println("Tên sản phẩm: " + laptopModel.getName() + "  -  Mức giá: " + priceOfProduct + "VND");
                        }
                    }
                    break;

                case 4 :
                    System.out.println("Nhập vào kích thước màn hình (inch) :");
                    String Screensize = scanner.nextLine();
                    List<LaptopModel> laptopModels3 = laptopService.findAllByScreensize(Screensize);
                    if(laptopModels3 == null || laptopModels3.isEmpty()){
                        System.out.println("Khong tim thấy thông tin ");
                    }
                    else {
                        for(LaptopModel laptopModel : laptopModels3){
                            System.out.println("Tên sản phẩm: " + laptopModel.getName() + "  -  Mức giá: " + laptopModel.getPrice() + "VND");
                        }
                    }
                    break;
                case 5 :
                    System.out.println("Nhập vào Ram laptop : ");
                    String Ram = scanner.nextLine();
                    List<LaptopModel> laptopModels4 = laptopService.findAllByRam(Ram);
                    if(laptopModels4 == null || laptopModels4.isEmpty()){
                        System.out.println("Khong tim thấy thông tin ");
                    }
                    else {
                        for(LaptopModel laptopModel : laptopModels4){
                            System.out.println("Tên sản phẩm: " + laptopModel.getName() + "  -  Mức giá: " + laptopModel.getPrice() + "VND");
                        }
                    }
                    break;
                case 6 :
                    System.out.println("Nhập vào CPU laptop : ");
                    String CPU = scanner.nextLine();
                    List <LaptopModel> laptopModels5 = laptopService.findAllByCPU(CPU);
                    if(laptopModels5 == null || laptopModels5.isEmpty()){
                        System.out.println("Khong tim thấy thông tin ");
                    }
                    else {
                        for(LaptopModel laptopModel : laptopModels5){
                            System.out.println("Tên sản phẩm: " + laptopModel.getName() + "  -  Mức giá: " + laptopModel.getPrice() + "VND");
                        }
                    }
                    break;
                case 7 :
                    System.out.println("Nhập vào loại laptop : ");
                    String Type = scanner.nextLine();
                    List <LaptopModel> laptopModels6 = laptopService.findAllByType(Type);
                    if(laptopModels6 == null || laptopModels6.isEmpty()){
                        System.out.println("Khong tim thấy thông tin ");
                    }
                    else {
                        for(LaptopModel laptopModel : laptopModels6){
                            System.out.println("Tên sản phẩm: " + laptopModel.getName() + "  -  Mức giá: " + laptopModel.getPrice() + "VND");
                        }
                    }
                    break;
                case 8 :
                    System.out.println("Nhập vào card laptop : ");
                    String Card = scanner.nextLine();
                    List <LaptopModel> laptopModels7 = laptopService.findAllByCard(Card);
                    if(laptopModels7 == null || laptopModels7.isEmpty()){
                        System.out.println("Khong tim thấy thông tin ");
                    }
                    else {
                        for(LaptopModel laptopModel : laptopModels7){
                            System.out.println("Tên sản phẩm: " + laptopModel.getName() + "  -  Mức giá: " + laptopModel.getPrice() + "VND");
                        }
                    }
                    break;
                case 9 :
                    List <LaptopModel> laptopModels8 = laptopService.findAllBySold();
                    for(LaptopModel laptopModel : laptopModels8){
                        System.out.println("Tên sản phẩm: " + laptopModel.getName() + "  -  Mức giá: " + laptopModel.getPrice() + "VND");
                    }
            }
        }while(true);
    }
}
