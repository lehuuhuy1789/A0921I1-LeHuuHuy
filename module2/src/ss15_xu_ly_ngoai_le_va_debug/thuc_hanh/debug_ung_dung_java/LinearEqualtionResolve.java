package ss15_xu_ly_ngoai_le_va_debug.thuc_hanh.debug_ung_dung_java;

import java.util.Scanner;

public class LinearEqualtionResolve {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("a*x+b=0");
        System.out.println("Enter the constaint");
        Scanner scanner=new Scanner(System.in);
        System.out.print("a= ");
        double a= scanner.nextDouble();
        System.out.print("b= ");
        double b= scanner.nextDouble();

        if(a!=0)
        {
            System.out.println("the solution: "+ (-b/a));
        }
        else
        {
            if(b==0) System.out.println("Many solution!");
            else System.out.println("No solution!");
        }
    }
}
