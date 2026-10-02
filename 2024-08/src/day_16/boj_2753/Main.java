package day_16.BOJ_B5_2753;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(br.readLine());

        System.out.println((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)) ? 1 : 0);
    }
}
