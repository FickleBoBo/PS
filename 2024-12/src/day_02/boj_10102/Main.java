package day_02.BOJ_10102;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        char[] vote = br.readLine().toCharArray();
        int[] cntArr = new int[128];

        for (char c : vote) {
            cntArr[c]++;
        }

        if (cntArr['A'] > cntArr['B']) {
            System.out.println("A");
        } else if (cntArr['A'] < cntArr['B']) {
            System.out.println("B");
        } else {
            System.out.println("Tie");
        }
    }
}
