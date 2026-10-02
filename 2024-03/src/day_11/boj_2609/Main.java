package day_11.BOJ_B1_2609;

import java.util.Scanner;

public class Main {

    static int gcd = -1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        GCD(a, b);
        int lcm = (int) a * b / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    // 유클리드 호제법(완전 못짬)
    private static void GCD(int a, int b) {
        if (a >= b) {
           if(a % b == 0) gcd = b;
           else GCD(a % b, b);
        }
        else{
            if(b % a == 0) gcd = a;
            else GCD(a, b % a);
        }
    }
}
