package day_05.BOJ_B4_13136;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long R = sc.nextLong();
        long C = sc.nextLong();
        long N = sc.nextLong();
        System.out.println(((R+N-1)/N) * ((C+N-1)/N));
    }
}
