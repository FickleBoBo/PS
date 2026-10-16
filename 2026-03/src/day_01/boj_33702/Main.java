package day_01.boj_33702;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        if (k % 2 != 0) {
            System.out.println(8);
        } else {
            System.out.println(0);
        }
    }
}
