package day_24.boj_20492;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println((n / 100 * 78) + " " + (n / 100 * 80 + n / 100 * 78 * 20 / 100));
    }
}
