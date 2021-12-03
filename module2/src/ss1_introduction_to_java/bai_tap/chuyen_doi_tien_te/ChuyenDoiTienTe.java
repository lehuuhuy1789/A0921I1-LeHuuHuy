package ss1_introduction_to_java.bai_tap.chuyen_doi_tien_te;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        double usd;
        double vnd = 23000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập số tiền USD: ");
        usd = scanner.nextDouble();
        double chuyenDoi = usd * vnd;
        System.out.println("Giá trị VND sau khi chuyển đổi là: " + chuyenDoi);
    }
}
