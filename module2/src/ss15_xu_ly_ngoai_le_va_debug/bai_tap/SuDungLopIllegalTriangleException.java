package ss15_xu_ly_ngoai_le_va_debug.bai_tap;

import java.util.Scanner;

public class SuDungLopIllegalTriangleException {
    public static void main(String[] args) {
        float a, b, c;
        System.out.println("Nhập độ dài 3 cạnh của tam giác:");
        Scanner input = new Scanner(System.in);
        a = input.nextFloat();
        b = input.nextFloat();
        c = input.nextFloat();
        try {
            checkTriangle(a, b, c);
        } catch (IllegalTriangleException e) {
            System.err.println(e.getMessage());
        }

    }

    public static void checkTriangle(float a, float b, float c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Độ dài của một cạnh phải lớn hơn 0");
        } else if (a + b < c || b + c < a || a + c < b) {
            throw new IllegalTriangleException("Đây không phải là một tam giác");
        } else {
            System.out.println("Đây là một tam giác");
        }
    }
    public static class IllegalTriangleException extends Exception {
        public IllegalTriangleException(String message) {
            super(message);
        }
    }
}
