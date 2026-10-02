package day_31.BOJ_5585;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int change = 1000 - Integer.parseInt(br.readLine());

        int cnt = (change / 500) + (change % 500 / 100) + (change % 100 / 50) + (change % 50 / 10) + (change % 10 / 5) + (change % 5);

        System.out.println(cnt);
    }
}
