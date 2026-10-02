package day_27.BOJ_S4_2960;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[1+N];
        for(int i=2 ; i<=N ; i++){
            isPrime[i] = true;
        }

        for(int i=2 ; i<=N ; i++){
            if(isPrime[i]){
                K--;
                if(K == 0){
                    System.out.println(i);
                    return;
                }

                for(int j=i*i ; j<=N ; j+=i){
                    if(isPrime[j]){
                        isPrime[j] = false;
                        K--;
                        if(K == 0){
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }
    }
}
