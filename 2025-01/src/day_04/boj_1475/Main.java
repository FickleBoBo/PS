package day_04.BOJ_1475;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        int[] cntArr = new int[10];
        for (char c : input) {
            cntArr[c - '0']++;
        }

        int tmp = (cntArr[6] + cntArr[9] + 1) / 2;
        cntArr[6] = cntArr[9] = tmp;

        int max = 0;
        for (int cnt : cntArr) {
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}
