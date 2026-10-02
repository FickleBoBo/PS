package day_18.BOJ_S2_12779;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int cnt = 0;
        for(long i=0 ; i*i<=b ; i++){
            cnt++;
        }
        for(long i=0 ; i*i<=a ; i++){
            cnt--;
        }

        long gcd = GCD(b-a, cnt);

        if(cnt == 0) sb.append("0");
        else sb.append(cnt / gcd).append("/").append((b-a) / gcd);

        bw.write(sb.toString());
        bw.flush();
    }

    private static long GCD(long a, long b){
        if(b==0) return a;
        return GCD(b, a % b);
    }

}
