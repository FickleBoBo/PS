package day_02.BOJ_B3_10984;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            int N = sc.nextInt();
            int[] C = new int[N];
            double[] G = new double[N];
            int CSUM = 0;
            double CG = 0;
            for(int i=0 ; i<N ; i++){
                C[i] = sc.nextInt();
                G[i] = sc.nextDouble();
                CSUM += C[i];
                CG += (C[i] * G[i]);
            }
            System.out.printf("%d %.1f\n", CSUM, CG / CSUM);
        }
    }
}
