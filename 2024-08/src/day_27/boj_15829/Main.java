package day_27.BOJ_B2_15829;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        long r = 1;
        int M = 1234567891;
        long ans = 0;

        for(char c : input){
            ans += (c - 'a' + 1) * r;
            r *= 31;
            ans %= M;
            r %= M;
        }

        System.out.println(ans);
    }
}
