package day_03.BOJ_23037;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        int sum = 0;
        for (char c : input) {
            sum += (int) Math.pow(c - '0', 5);
        }

        System.out.println(sum);
    }
}
