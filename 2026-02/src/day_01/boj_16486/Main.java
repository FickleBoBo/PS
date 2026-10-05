package day_01.boj_16486;

import java.io.*;

public class Main {

    static final double PI = 3.141592;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int d1 = Integer.parseInt(br.readLine());
        int d2 = Integer.parseInt(br.readLine());
        System.out.println(d1 * 2 + 2 * d2 * PI);
    }
}
