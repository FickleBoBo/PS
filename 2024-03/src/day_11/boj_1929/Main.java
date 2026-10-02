package day_11.BOJ_S3_1929;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] isNotPrime = new boolean[1_000_001];
        isNotPrime[1] = true;

        // 에라토스테네스의 체
        for(int i=1 ; i<=1_000_000 ; i++){
            for(int j=2 ; j<=Math.sqrt(i) ; j++){
                if(i % j == 0){
                    isNotPrime[i] = true;
                    break;
                }
            }
        }

        for(int i=M ; i<=N ; i++){
            if(!isNotPrime[i]){
                System.out.println(i);
            }
        }
    }
}
