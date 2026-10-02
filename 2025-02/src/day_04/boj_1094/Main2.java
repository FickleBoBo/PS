package day_04.BOJ_1094;

import java.io.*;

public class Main_Bitmask {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        System.out.println(Integer.bitCount(X));
    }
}
