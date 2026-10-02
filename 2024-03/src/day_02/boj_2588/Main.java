package day_02.BOJ_B3_2588;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a*(b%10));
        System.out.println((a*(b%100-b%10))/10);
        System.out.println((a*(b-b%100))/100);
        System.out.println(a*b);

        sc.close();
    }
}
