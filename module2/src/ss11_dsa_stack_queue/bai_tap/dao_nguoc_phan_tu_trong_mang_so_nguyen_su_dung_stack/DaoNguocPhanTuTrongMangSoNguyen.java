package ss11_dsa_stack_queue.bai_tap.dao_nguoc_phan_tu_trong_mang_so_nguyen_su_dung_stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DaoNguocPhanTuTrongMangSoNguyen {
    public DaoNguocPhanTuTrongMangSoNguyen() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack();
        System.out.println("Nhập số lượng phần tử cần truyền vào mảng");
        int n = scanner.nextInt();
        System.out.println("nhập lần lượt các phần tử của mảng");
        int[] array = new int[n];

        int i;
        for(i = 0; i < n; ++i) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Mảng vừa nhập có các phần từ");
        System.out.println(Arrays.toString(array));

        for(i = 0; i < array.length; ++i) {
            stack.push(array[i]);
        }

        while(!stack.isEmpty()) {
            for(i = 0; i < array.length; ++i) {
                array[i] = (Integer)stack.pop();
            }
        }

        System.out.println("Mảng sau khi đảo ngược phần tử: ");
        System.out.println(Arrays.toString(array));
    }
}
