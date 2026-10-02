package day_28.SWEA_D4_1251_Fail;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for(int tc=1 ; tc<=T ; tc++){

            // step1 - 입력 받아 정리하기
            int N = Integer.parseInt(sc.nextLine());    // N : 섬의 개수

            int[][] pos = new int[1+N][2];    // pos : 각 섬의 x, y 좌표
            StringTokenizer st_xpos = new StringTokenizer(sc.nextLine(), " ");
            StringTokenizer st_ypos = new StringTokenizer(sc.nextLine(), " ");
            for(int i=1 ; i<=N ; i++){
                pos[i][0] = Integer.parseInt(st_xpos.nextToken());
                pos[i][1] = Integer.parseInt(st_ypos.nextToken());
            }
            double E = Double.parseDouble(sc.nextLine());
            double[][] dist = new double[1+N][1+N];    // dist : 각 섬 간의 거리를 담는 인접 행렬
            for(int i=1 ; i<=N ; i++){
                for(int j=i ; j<=N ; j++){
                    double L = Math.sqrt(Math.pow(pos[i][0]-pos[j][0], 2)+Math.pow(pos[i][1]-pos[j][1], 2));
                    dist[i][j] = dist[j][i] = E * Math.pow(L, 2);
                }
            }

            // step2 - Prim 하기 전에 준비하기
            double ans = 0;
            int V = 0;
            boolean[] visited = new boolean[1+N];
            double[] key = new double[1+N];
            Arrays.fill(key, INF);
            int minKeyIdx = 0;
            key[1] = 0;

            // step3 - Prim 시작하기
            while(V < N-1){

                for(int idx=1 ; idx<=N ; idx++){
                    if(dist[idx][minKeyIdx] != 0){
                        key[idx] = dist[idx][minKeyIdx];
                    }
                }
                
                for(int idx=1 ; idx<=N ; idx++){
                    if(!visited[idx]) {
//                        minKeyIdx = Math.min(minKeyIdx, key[idx]);
                    }
                }

                visited[minKeyIdx] = true;



            }

        }

        sc.close();
    }
}
