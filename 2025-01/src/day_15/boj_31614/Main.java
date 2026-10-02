package day_15.BOJ_31614;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int H = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        System.out.println(H * 60 + M);
    }
}
