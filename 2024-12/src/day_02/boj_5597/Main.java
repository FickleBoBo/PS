package day_02.BOJ_5597;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] checked = new boolean[1 + 30];
        for (int i = 0; i < 28; i++) {
            checked[Integer.parseInt(br.readLine())] = true;
        }

        for (int i = 1; i <= 30; i++) {
            if (!checked[i]) {
                System.out.println(i);
            }
        }
    }
}
