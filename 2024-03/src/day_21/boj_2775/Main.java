package day_21.BOJ_B1_2775;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            int k = sc.nextInt();
            int n = sc.nextInt();

            int[][] building = new int[k+1][n+1];
            for(int i=1 ; i<=n ; i++){
                building[0][i] = i;
            }

            for(int i=1 ; i<=k ; i++){
                for(int j=1 ; j<=n ; j++){
                    building[i][j] = building[i-1][j] + building[i][j-1];
                }
            }
            System.out.println(building[k][n]);
        }

        sc.close();
    }
}
