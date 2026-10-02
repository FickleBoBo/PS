package day_28.BOJ_S5_5347;

import java.io.*;
import java.util.StringTokenizer;

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

            sb.append(LCM(A, B)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int GCD(int a, int b){
        if(b == 0) return a;
        return GCD(b, a % b);
    }

    // int 형 범위를 넘을 수 있다
    private static long LCM(int a, int b){
        int gcd = GCD(a, b);
        return (long) a * b / gcd;
    }

}
