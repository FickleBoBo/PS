package day_03.boj_31611;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        System.out.println(x % 7 == 2 ? 1 : 0);
    }
}
