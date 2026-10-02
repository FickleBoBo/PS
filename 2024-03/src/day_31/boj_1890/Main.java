package day_31.BOJ_S1_1890;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] map = new int[N][N];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                map[i][j] = sc.nextInt();
            }
        }

        long[][] dp = new long[N][N];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                if(i==0 && j==0){
                    dp[i][j] = 1;
                }
                else{
                    long ans = 0;
                    for(int a=0 ; a<i ; a++){
                        if(dp[a][j] != 0 && map[a][j]==i-a){
                            ans += dp[a][j];
                        }
                    }
                    for(int b=0 ; b<j ; b++){
                        if(dp[i][b] != 0 && map[i][b]==j-b){
                            ans += dp[i][b];
                        }
                    }
                    dp[i][j] = ans;
                }
            }
        }

//        for(int i=0 ; i<N ; i++){
//            for(int j=0 ; j<N ; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[N-1][N-1]);

        sc.close();
    }
}
