package day_15.BOJ_S5_8979;

import java.io.*;
import java.util.*;

public class Main {
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

        // 금메달 수, 은메달 수, 동메달 수로 정렬하고 각 메달 수가 모두 같으면 일단 국가 번호로 정렬
        Arrays.sort(map, ((o1, o2) -> {
            if(o1[1] != o2[1]) return Integer.compare(o2[1], o1[1]);
            if(o1[2] != o2[2]) return Integer.compare(o2[2], o1[2]);
            if(o1[3] != o2[3]) return Integer.compare(o2[3], o1[3]);
            return Integer.compare(o1[0], o2[0]);
        }));

        // 등수
        int rank = 0;

        // 역순으로 순회하며 등수를 찾음
        for(int i=N-1 ; i>=0 ; i--){
            if(map[i][0] == K){

                // 일단 국가를 찾으면 임시 등수 부여
                rank = i + 1;

                // 모든 메달 수가 동일한 국가가 있으면 그만큼 거슬러 올라가서 진짜 등수를 찾음
                for(int k=i-1 ; k>=0 ; k--){
                    if(map[i][1] == map[k][1] && map[i][2] == map[k][2] && map[i][3] == map[k][3]){
                        rank--;
                    }
                }

                break;
            }
        }

        System.out.println(rank);
    }
}
