package ss11_dsa_stack_queue.bai_tap.kiem_tra_dau_ngoac_trong_stack;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public Main() {
    }

    private static boolean checkBracket(String input) {
        Stack<String> bStack = new Stack();
        String[] arr = input.split("");
        int left = 0;
        boolean res = false;

        for(int i = 0; i < arr.length; ++i) {
            if (arr[i].equals("(")) {
                if (i != 0 && !arr[i - 1].equals("+") && !arr[i - 1].equals("-") && !arr[i - 1].equals("*") && !arr[i - 1].equals("/")) {
                    return false;
                }

                bStack.push(arr[i]);
                ++left;
            } else if (arr[i].equals(")")) {
                if (left == 0) {
                    return false;
                }

                bStack.pop();
            }
        }

        if (bStack.isEmpty()) {
            return true;
        } else {
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập biểu thức cần kiểm tra");
        String input = scanner.nextLine();
        System.out.println(checkBracket(input));
    }
}
