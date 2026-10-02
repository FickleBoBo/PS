package day_04.BOJ_1919;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        char[] input2 = br.readLine().toCharArray();

        int[] cntArr = new int[26];
        for (char c : input) {
            cntArr[c - 'a']++;
        }
        for (char c : input2) {
            cntArr[c - 'a']--;
        }

        int sum = 0;
        for (int cnt : cntArr) {
            sum += Math.abs(cnt);
        }

        System.out.println(sum);
    }
}
