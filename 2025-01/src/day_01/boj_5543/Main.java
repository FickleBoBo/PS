package day_01.BOJ_5543;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int minHamburger = Integer.MAX_VALUE;
        int minBeverage = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            int hamburger = Integer.parseInt(br.readLine());
            minHamburger = Math.min(minHamburger, hamburger);
        }

        for (int i = 0; i < 2; i++) {
            int beverage = Integer.parseInt(br.readLine());
            minBeverage = Math.min(minBeverage, beverage);
        }

        System.out.println(minHamburger + minBeverage - 50);
    }
}
