package day_02.BOJ_B2_5585;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 1000 - Integer.parseInt(br.readLine());

        int coin500 = N / 500;
        int coin100 = N % 500 / 100;
        int coin50 = N % 100 / 50;
        int coin10 = N % 50 / 10;
        int coin5 = N % 10 / 5;
        int coin1 = N % 5;

        System.out.println(coin500 + coin100 + coin50 + coin10 + coin5 + coin1);
    }
}
