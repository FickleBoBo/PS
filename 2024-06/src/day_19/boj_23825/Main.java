package day_19.BOJ_B4_23825;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        System.out.println(N > M ? M / 2 : N / 2);
    }
}
