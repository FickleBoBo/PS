package day_15.BOJ_S5_8979;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][4];
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());

            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
            map[i][3] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map, ((o1, o2) -> Integer.compare(o1[0], o2[0])));

        int rank = 1;
        int goldCnt = map[K-1][1];
        int silverCnt = map[K-1][2];
        int bronzeCnt = map[K-1][3];

        for(int i=0 ; i<N ; i++){
            if(map[i][1] > goldCnt){
                rank++;
            }
            else if(map[i][1] == goldCnt){
                if(map[i][2] > silverCnt){
                    rank++;
                }
                else if(map[i][2] == silverCnt){
                    if(map[i][3] > bronzeCnt){
                        rank++;
                    }
                }
            }
        }

        System.out.println(rank);
    }
}
