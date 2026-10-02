package day_26.BOJ_G3_1644;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

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

        int left = 0;
        int right = 0;
        int sum = 0;
        int cnt = 0;

        while(true){
            if(sum < N && right == primeList.size()) break;

            if(sum < N){
                sum += primeList.get(right);
                right++;
            }
            else if(sum > N){
                sum -= primeList.get(left);
                left++;
            }
            else{
                sum -= primeList.get(left);
                left++;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
