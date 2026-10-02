package day_08.BOJ_10039;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int score = Integer.parseInt(br.readLine());
            sum += Math.max(score, 40);
        }

        System.out.println(sum / 5);
    }
}
