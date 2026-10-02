package day_28.BOJ_B1_1934;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int lcm = LCM(A, B);

            sb.append(lcm).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int GCD(int a, int b){
        if(b == 0) return a;
        return GCD(b, a % b);
    }

    private static int LCM(int a, int b){
        int gcd = GCD(a, b);
        return a * b / gcd;
    }

}
