package day_15.BOJ_31611;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        if (x % 7 == 2) System.out.println(1);
        else System.out.println(0);
    }
}
