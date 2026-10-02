package day_31.BOJ_1157;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        int[] cntArr = new int[26];

        for (char c : input) {
            cntArr[Character.toLowerCase(c) - 'a']++;
        }

        int max = 0;
        int maxCnt = 0;
        char maxChar = '?';
        for (int i = 0; i < cntArr.length; i++) {
            if (cntArr[i] > max) {
                max = cntArr[i];
                maxCnt = 1;
                maxChar = (char) (i + 'A');
            } else if (cntArr[i] == max) {
                maxCnt++;
            }
        }

        if (maxCnt == 1) System.out.println(maxChar);
        else System.out.println("?");
    }
}
