package day_14.boj_23037;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int sum = 0;

        for (char c : s.toCharArray()) {
            int d = c - '0';
            sum += d * d * d * d * d;
        }

        System.out.println(sum);
    }
}
