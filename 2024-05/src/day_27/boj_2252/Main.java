package day_27.BOJ_G3_2252;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer>[] adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }
        int[] p = new int[1+N];
        for(int i=0 ; i<M ; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            adj[from].add(to);
            p[to]++;
        }

        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        for(int i=1 ; i<=N ; i++){
            if(p[i] == 0){
                q.offer(i);
            }
        }

        int cnt = 0;
        while(true){
            int item = q.poll();
            sb.append(item + " ");
            cnt++;
            if(cnt == N) break;

            for(int i : adj[item]){
                p[i]--;
                if(p[i] == 0) q.offer(i);
            }
        }

        System.out.println(sb.toString());

        sc.close();
    }
}
