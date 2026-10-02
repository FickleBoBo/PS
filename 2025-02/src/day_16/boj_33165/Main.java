package day_16.BOJ_33165;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int V = Integer.parseInt(br.readLine());

        System.out.println(T * V);
    }
}
