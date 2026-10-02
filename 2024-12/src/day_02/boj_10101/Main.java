package day_02.BOJ_10101;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        if (A + B + C != 180) {
            System.out.println("Error");
        } else if (A == B && A == C) {
            System.out.println("Equilateral");
        } else if (A == B || B == C || C == A) {
            System.out.println("Isosceles");
        } else {
            System.out.println("Scalene");
        }
    }
}
