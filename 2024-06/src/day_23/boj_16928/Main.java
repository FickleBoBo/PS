package day_23.BOJ_G5_16928;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 뱀과 사다리를 구분해서 입력할 필요 없음
        int NM = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        int[] map = new int[1 + 100];

        for(int i=0 ; i<NM ; i++){    // NM은 N + M -> 따로 해도 아무 상관 없음
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a] = b;
        }

        int ans = BFS(map);

        System.out.println(ans);
    }

    // 출발 위치는 1로 고정
    private static int BFS(int[] map){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        // 이미 방문한 칸을 다시 방문해서 목적지에 도착하는 것은 항상 더 느림
        boolean[] visited = new boolean[1 + 100];
        visited[1] = true;

        int ans = 0;    // 최소 횟수

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0 ; i<len ; i++){
                int node = q.poll();

                if(node == 100){    // 목적지에 방문하면 종료
                    return ans;
                }

                for(int j=1 ; j<=6 ; j++){    // 각각의 주사위 눈금
                    int next = node + j;

                    // 맵을 벗어나지 않으면서 아직 방문하지 않았을 때
                    if((next <= 100) && !visited[next]){

                        // 일반 칸이면 큐에 넣고 방문 체크
                        if(map[next] == 0){
                            q.offer(next);
                            visited[next] = true;
                        }
                        // 뱀이나 사다리면 해당 칸으로 이동해서 큐에 넣고 방문 체크
                        else{
                            q.offer(map[next]);
                            visited[map[next]] = true;
                        }
                    }
                }
            }

            ans++;
        }

        return -1;    // 항상 100번 칸에 도착할 수 있어서 실제로 리턴될 일은 없다
    }

}
