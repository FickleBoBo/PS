package day_22.boj_2577;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int res = a * b * c;
        int[] cnt = new int[10];

        while (res > 0) {
            cnt[res % 10]++;
            res /= 10;
        }

        for (int x : cnt) {
            System.out.println(x);
        }
    }
}
