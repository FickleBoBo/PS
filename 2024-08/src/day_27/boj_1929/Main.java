package day_27.BOJ_S3_1929;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[1+N];
        for(int i=2 ; i<=N ; i++){
            isPrime[i] = true;
        }

        for(int i=2 ; i*i<=N ; i++){
            if(isPrime[i]){
                for(int j=i*i ; j<=N ; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        for(int i=M ; i<=N ; i++){
            if(isPrime[i]){
                sb.append(i).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
