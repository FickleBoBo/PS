package day_21.boj_23795;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        while (true) {
            int x = Integer.parseInt(br.readLine());
            if (x == -1) break;
            sum += x;
        }

        System.out.println(sum);
    }
}
