package day_19.BOJ_16486;

import java.io.*;

public class Main {

    private static final double PI = 3.141592;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int d1 = Integer.parseInt(br.readLine());
        int d2 = Integer.parseInt(br.readLine());

        System.out.println(2 * d1 + PI * 2 * d2);
    }
}
