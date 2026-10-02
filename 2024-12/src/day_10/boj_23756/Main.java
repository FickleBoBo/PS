package day_10.BOJ_23756;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int A0 = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            int An = Integer.parseInt(br.readLine());

            sum += Math.min(((An + 360) - A0) % 360, ((A0 + 360) - An) % 360);
            A0 = An;
        }

        System.out.println(sum);
    }
}
