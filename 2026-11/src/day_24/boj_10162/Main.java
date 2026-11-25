package day_24.boj_10162;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int a = t / 300;
        t %= 300;

        int b = t / 60;
        t %= 60;

        int c = t / 10;
        t %= 10;

        if (t == 0) {
            System.out.println(a + " " + b + " " + c);
        } else {
            System.out.println(-1);
        }
    }
}
