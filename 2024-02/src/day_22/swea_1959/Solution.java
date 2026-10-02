package day_22.SWEA_D2_1959;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){

            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] arrN = new int[N];
            for(int i=0 ; i<N ; i++){
                arrN[i] = sc.nextInt();
            }
            int[] arrM = new int[M];
            for(int i=0 ; i<M ; i++){
                arrM[i] = sc.nextInt();
            }

            int max = Integer.MIN_VALUE;
            if(N > M){
                for(int i=0 ; i<N-M+1 ; i++){
                    int tmp = 0;
                    for(int j=0 ; j<M ; j++){
                        tmp += arrN[i+j] * arrM[j];
                    }
                    max = Math.max(max, tmp);
                }
            }
            else{
                for(int i=0 ; i<M-N+1 ; i++){
                    int tmp = 0;
                    for(int j=0 ; j<N ; j++){
                        tmp += arrN[j] * arrM[i+j];
                    }
                    max = Math.max(max, tmp);
                }
            }

            System.out.printf("#%d %d\n", tc, max);
        }
        sc.close();
    }
}
