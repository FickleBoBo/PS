package day_29.BOJ_G2_2637;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1 -> 1
        // 2 -> 2
        // 3 -> 3
        // 4 -> 4
        // 5 -> 1, 1, 2, 2
        // 6 -> 3, 3, 3, 4, 4, 4, 4, 5, 5
        // 7 -> 5, 5, 6, 6, 6, 4, 4, 4, 4, 4
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<int[]>[] adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }
        int[] degree = new int[1+N];
        boolean[] complexParts = new boolean[1+N];

        for(int i=0 ; i<M ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cnt = sc.nextInt();
            adj[a].add(new int[]{b, cnt});
            degree[b]++;
            complexParts[a] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] dp = new int[1+N];
        dp[N] = 1;

        for(int i=1 ; i<=N ; i++){
            if(degree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int item = q.poll();

            for(int[] next : adj[item]){
                degree[next[0]]--;
                if(degree[next[0]] == 0){
                    q.offer(next[0]);
                }

                dp[next[0]] += dp[item] * next[1];
            }
        }

//        System.out.println(Arrays.toString(dp));

        for(int i=1 ; i<=N ; i++){
            if(!complexParts[i]){
                System.out.println(i + " " + dp[i]);
            }
        }
    }
}
