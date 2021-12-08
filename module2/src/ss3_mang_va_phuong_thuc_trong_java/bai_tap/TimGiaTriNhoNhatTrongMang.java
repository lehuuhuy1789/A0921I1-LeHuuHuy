package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int[]array;
        do {
            System.out.print("Nhập size: ");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size không thể vượt quá 20");
        } while (size > 20);
        array=new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Nhập phần từ ở vị trí " + i  + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.println("Mảng vừa nhập có các phần tử sau: "+ Arrays.toString(array));
        int result = findMin(array);
        System.out.println("Giá trị phần tử thấp nhất trong mảng là: "+result);
    }
    public static int findMin(int[]arr){
        int min = arr[0];
        for (int i=1;i<arr.length;i++){
            if (min>arr[i]){
                min = arr[i];
            }
        }
        return min;
    }
}
