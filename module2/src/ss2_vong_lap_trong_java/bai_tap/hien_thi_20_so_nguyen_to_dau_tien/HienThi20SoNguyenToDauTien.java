package ss2_vong_lap_trong_java.bai_tap.hien_thi_20_so_nguyen_to_dau_tien;

import java.util.Scanner;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào số lượng nguyên tố: ");
        int numbers = scanner.nextInt();
        int count = 0;
        int n = 2;

        String daySo;
        for(daySo = ""; count < numbers; ++n) {
            boolean flag = true;
            if (n < 2) {
                flag = false;
            } else {
                for(int i = 2; i < n; ++i) {
                    if (n % i == 0) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                daySo = daySo + n + ",";
                ++count;
            }
        }

        System.out.println("Dãy số nguyên tố là " + daySo);
    }
}
