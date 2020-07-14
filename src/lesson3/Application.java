package lesson3;

import lesson3.Model.Counter;
import lesson3.Model.LaptopModel;
import lesson3.Services.LaptopServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        LaptopServices laptopService = new LaptopServices();

        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------CHỨC NĂNG----------");
        System.out.println("Bấm phím 1 để tìm kiếm laptop");
        System.out.println("Bấm phím 2 để thống kê số lượng máy tính giảm  dần  ");
        do {
            System.out.println("\nNhập lựa chọn:");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:

                    List<LaptopModel> laptopModels = new ArrayList<>();
                    laptopModels = laptopService.searchLaptop("ACER",15000000.0f,20000000.0f,null,null,null,null);

                    if (laptopModels == null || laptopModels.isEmpty()) {
                        System.out.println("Không tìm thấy thông tin sản phẩm.");
                    } else {
                        for (LaptopModel laptopModel : laptopModels) {
                            System.out.println(laptopModel.getName());
                        }
                    }
                case 2:
                    List <Counter> counters = new ArrayList<>();
                    counters = laptopService.GetCounterByMaker();
                    if (counters == null || counters.isEmpty()) {
                        System.out.println("Không tìm thấy thông tin sản phẩm.");
                    } else {
                        for (Counter laptopModel : counters) {
                            System.out.println(laptopModel.getMaker() +" "+ laptopModel.getQuantity());
                        }
                    }
            }
        }while(true);
    }
}
