package day_03.boj_9659;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        if (n % 2 != 0) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
