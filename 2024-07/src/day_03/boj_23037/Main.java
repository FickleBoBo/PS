package day_03.BOJ_B2_23037;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        while(N > 0){
            int r = N % 10;
            N /= 10;
            sum += r * r * r * r * r;
        }

        System.out.println(sum);
    }
}
