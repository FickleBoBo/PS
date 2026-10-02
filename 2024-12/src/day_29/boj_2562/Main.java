package day_29.BOJ_2562;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int order = 0;

        for (int i = 1; i <= 9; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > max) {
                max = num;
                order = i;
            }
        }

        System.out.println(max);
        System.out.println(order);
    }
}
