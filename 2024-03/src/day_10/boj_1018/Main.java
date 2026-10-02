package day_10.BOJ_S4_1018;

import java.util.Scanner;

public class Main {

    static char[][] input;
    static int cnt = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        input = new char[N][M];
        for(int i=0 ; i<N ; i++){
            input[i] = sc.next().toCharArray();
        }

        for(int i=0 ; i<=N-8 ; i++){
            for(int j=0 ; j<=M-8 ; j++){
                paintBlack(i, j);
                paintWhite(i, j);
            }
        }
        System.out.println(cnt);
        sc.close();
    }

    private static void paintBlack(int r, int c) {
        boolean isBlack = true;
        int count = 0;
        for(int i=r ; i<r+8 ; i++){
            for(int j=c ; j<c+8 ; j++){
                if(isBlack){
                    if(input[i][j] == 'W') count++;
                }
                else{
                    if(input[i][j] == 'B') count++;

                }
                isBlack = !isBlack;
            }
            isBlack = !isBlack;
        }
        cnt = Math.min(cnt, count);
    }

    private static void paintWhite(int r, int c) {
        boolean isWhite = true;
        int count = 0;
        for(int i=r ; i<r+8 ; i++){
            for(int j=c ; j<c+8 ; j++){
                if(isWhite){
                    if(input[i][j] == 'B') count++;
                }
                else{
                    if(input[i][j] == 'W') count++;

                }
                isWhite = !isWhite;
            }
            isWhite = !isWhite;
        }
        cnt = Math.min(cnt, count);
    }

}
