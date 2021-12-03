package ss2_vong_lap_trong_java.bai_tap.hien_thi_cac_loai_hinh;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        while(true) {
            while(choice != 0) {
                System.out.println("Bài tập hiển thị các hình"+
                        "\n1. In hình chữ nhật" +
                        "\n2. In hình tam giác vuông, có cạnh góc vuông ở botton-left" +
                        "\n3. In hình tam giác vuông, có cạnh góc vuông ở top-left" +
                        "\n4. In hình tam giác cân" +
                        "\n0. Exit");
                System.out.println("Enter your choice: ");
                choice = sc.nextInt();
                String sharp;
                int i;
                int j;
                switch(choice) {
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("No choice!");
                        break;
                    case 1:
                        System.out.println("In hình chữ nhật");
                        sharp = "";

                        for(i = 1; i <= 3; ++i) {
                            for(j = 1; j <= 7; ++j) {
                                sharp = sharp + " * ";
                            }

                            sharp = sharp + "\n";
                        }

                        System.out.println(sharp);
                        break;
                    case 2:
                        System.out.println("In hình tam giác vuông, có cạnh góc vuông ở botton-left");
                        sharp = "";

                        for(i = 1; i <= 5; ++i) {
                            for(j = 1; j <= i; ++j) {
                                sharp = sharp + " * ";
                            }

                            sharp = sharp + "\n";
                        }

                        System.out.println(sharp);
                        break;
                    case 3:
                        System.out.println("In hình tam giác vuông, có cạnh góc vuông ở top-left");
                        sharp = "";

                        for(i = 5; i >= 1; --i) {
                            for(j = 1; j <= i; ++j) {
                                sharp = sharp + " * ";
                            }

                            sharp = sharp + "\n";
                        }

                        System.out.println(sharp);
                        break;
                    case 4:
                        System.out.println("In hình tam giác cân");
                        sharp = "";

                }
            }

            return;
        }
    }
}
