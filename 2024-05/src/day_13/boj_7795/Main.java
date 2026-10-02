package day_13.BOJ_S3_7795;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] A = new int[N];
            int[] B = new int[M];
            for(int i=0 ; i<N ; i++){
                A[i] = sc.nextInt();
            }
            for(int i=0 ; i<M ; i++){
                B[i] = sc.nextInt();
            }
            Arrays.sort(A);
            Arrays.sort(B);

            int ans = 0;
            for(int j=0 ; j<M ; j++){
                for(int i=0 ; i<N ; i++){
                    if(A[i] > B[j]){
                        ans += N - i;
                        break;
                    }
                }
            }

            System.out.println(ans);
        }

    }
}
