package day_15.BOJ_30030;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int B = Integer.parseInt(br.readLine());

        System.out.println(B / 11 * 10);
    }
}
