package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[]{10, 4, 6, 7, 8, 6, 0, 0, 0, 0};
        System.out.println("Mảng ban đầu có các phần từ sau: ");
        System.out.println(Arrays.toString(arr));
        System.out.println("Nhập số cần thêm vào mảng: ");
        int nhap = scanner.nextInt();

        int index;
        do {
            System.out.println("Nhập ví trí cần chèn trong mảng: ");
            index = scanner.nextInt();
            if (index <= 1 || index >= arr.length - 1) {
                System.out.println("Không chèn được phần từ vào mảng, vui lòng đổi vị trí cần chèn");
            }
        } while(index <= 1 || index >= arr.length - 1);

        for(int i = 0; i < arr.length; ++i) {
            if (index == i) {
                for(int j = arr.length - 1; j > i; --j) {
                    arr[j] = arr[j - 1];
                }

                arr[i] = nhap;
            }
        }

        System.out.println("Mảng sau khi chèn " + Arrays.toString(arr));
    }

    public static int[] addArr(int[] arr, int index, int nhap) {
        for(int j = arr.length - 1; j > index; --j) {
            arr[j] = arr[j - 1];
        }

        arr[index] = nhap;
        return arr;
    }
}
