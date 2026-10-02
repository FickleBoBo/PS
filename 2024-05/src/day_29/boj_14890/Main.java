package day_29.BOJ_G3_14890;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();

        int[][] map = new int[N][N];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int[][] putRunway = new int[L+N+L][L+N+L];
        int cnt = 2 * N;

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N-1 ; j++){
                if(map[i][j] > map[i][j+1]){
                    for(int k=1 ; k<=L ; k++){
                        putRunway[i+L][j+L+k] += map[i][j] - map[i][j+1];
                    }
                }
                else if(map[i][j] < map[i][j+1]){
                    for(int k=0 ; k<L ; k++){
                        putRunway[i+L][j+L-k] += map[i][j+1] - map[i][j];
                    }
                }
            }
        }

        for(int i=L ; i<N+L ; i++){
            for(int j=0 ; j<N+2*L ; j++){
                if(((j<L) || (j>=N+L)) && putRunway[i][j] > 0){
                    cnt--;
                    break;
                }
                else if((j>=L && j<N+L) && putRunway[i][j] > 1){
                    cnt--;
                    break;
                }
            }
        }

        putRunway = new int[L+N+L][L+N+L];

        for(int j=0 ; j<N ; j++){
            for(int i=0 ; i<N-1 ; i++){
                if(map[i][j] > map[i+1][j]){
                    for(int k=1 ; k<=L ; k++){
                        putRunway[i+L+k][j+L] += map[i][j] - map[i+1][j];
                    }
                }
                else if(map[i][j] < map[i+1][j]){
                    for(int k=0 ; k<L ; k++){
                        putRunway[i+L-k][j+L] += map[i+1][j] - map[i][j];
                    }
                }
            }
        }

        for(int j=0 ; j<N+L ; j++){
            for(int i=0 ; i<N+2*L ; i++){
                if(((i<L) || (i>=N+L)) && putRunway[i][j]>0){
                    cnt--;
                    break;
                }
                else if((i>=L && i<N+L) && putRunway[i][j] > 1){
                    cnt--;
                    break;
                }
            }
        }

        System.out.println(cnt);

    }
}
