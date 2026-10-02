package day_27.BOJ_S3_2312;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        List<Integer> primeList = getPrimeList(100_000);

        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            int N = Integer.parseInt(br.readLine());

            List<int[]> ansList = new ArrayList<>();

            for(int prime : primeList){
                int quotient = 0;

                while(N % prime == 0){
                    quotient++;
                    N /= prime;
                }

                if(quotient > 0){
                    ansList.add(new int[]{prime, quotient});
                }
            }

            for(int[] ans : ansList){
                sb.append(ans[0]).append(" ").append(ans[1]).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static List<Integer> getPrimeList(int N){
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

        List<Integer> primeList = new ArrayList<>();
        for(int i=2 ; i<=N ; i++){
            if(isPrime[i]){
                primeList.add(i);
            }
        }

        return primeList;
    }

}
