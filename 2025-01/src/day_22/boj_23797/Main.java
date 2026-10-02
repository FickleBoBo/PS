package day_22.BOJ_23797;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        int startP = 0;
        int startK = 0;
        int pIdx = 0;
        int kIdx = 0;

        for (char c : input) {
            if (c == 'P') {
                if (kIdx == 0) pIdx++;
                else kIdx--;
            } else {
                if (pIdx == 0) kIdx++;
                else pIdx--;
            }

            startP = Math.max(startP, pIdx);
            startK = Math.max(startK, kIdx);
        }

        System.out.println(startP + startK);
    }
}
