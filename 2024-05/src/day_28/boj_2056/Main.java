package day_28.BOJ_G4_2056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] time = new int[1+N];
        List[] adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<Integer>();
        }
        int[] degree = new int[1+N];

        StringBuilder sb = new StringBuilder();
        for(int i=1 ; i<=N ; i++){
            sb.append(br.readLine() + " ");
        }
        StringTokenizer st = new StringTokenizer(sb.toString(), " ");

        for(int i=1 ; i<=N ; i++){
            time[i] = Integer.parseInt(st.nextToken());

            int cnt = Integer.parseInt(st.nextToken());
            degree[i] = cnt;
            for(int j=0 ; j<cnt ; j++){
                int next = Integer.parseInt(st.nextToken());
                adj[next].add(i);
            }
        }

//        for(List list : adj){
//            System.out.println(list);
//        }
//
//        System.out.println(Arrays.toString(degree));

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[1+N];
        int[] dp = new int[1+N];

        for(int i=1 ; i<=N ; i++){
            if(!visited[i] && degree[i] == 0){
                q.offer(i);
                visited[i] = true;
            }
        }

        while(!q.isEmpty()){
            int item = q.poll();
            dp[item] += time[item];

            for(Object n : adj[item]){
                int i = (int) n;
                degree[i]--;
                if(!visited[i] && degree[i] == 0){
                    q.offer(i);
                    visited[i] = true;
                }
                dp[i] = Math.max(dp[i], dp[item]);
            }

//            System.out.println(Arrays.toString(dp));

        }

//        System.out.println(Arrays.toString(ans));

        Arrays.sort(dp);
        System.out.println(dp[N]);

    }
}
