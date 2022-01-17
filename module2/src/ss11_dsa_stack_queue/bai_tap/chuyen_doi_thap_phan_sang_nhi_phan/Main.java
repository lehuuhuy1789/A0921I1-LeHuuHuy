package ss11_dsa_stack_queue.bai_tap.chuyen_doi_thap_phan_sang_nhi_phan;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Stack<Integer> stacks = new Stack();
        Scanner scanner = new Scanner(System.in);

        int decimal;
        do {
            System.out.println("Vui lòng nhập số nguyên dương bất kì cần chuyển qua hệ nhị phân");
            decimal = scanner.nextInt();
        } while(decimal < 0);

        System.out.println("Số nhị phân của " + decimal + " là: ");

        while(decimal != 0) {
            int phanDu = decimal % 2;
            stacks.push(phanDu);
            decimal /= 2;
        }

        while(!stacks.isEmpty()) {
            System.out.print(stacks.pop());
        }

    }
}
