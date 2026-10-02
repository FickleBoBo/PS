package day_12.BOJ_S2_15965;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[10_000_000];
        Arrays.fill(isPrime, true);

        for(int i=2 ; i*i<10_000_000 ; i++){
            if(isPrime[i]){
                for(int j=i*i ; j<10_000_000 ; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        int order = 0;
        for(int i=2 ; i<10_000_000 ; i++){
            if(isPrime[i]) order++;
            if(order == n){
                System.out.println(i);
                return;
            }
        }
    }
}
