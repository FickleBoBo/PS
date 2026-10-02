package day_27.BOJ_S2_5567;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<=n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0 ; i<m ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        System.out.println(BFS(n, adj));
    }

    private static int BFS(int N, List<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[1+N];

        q.offer(1);
        visited[1] = true;
        int ans = 0;

        int maxLen = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0 ; i<len ; i++){
                int item = q.poll();
                for(int j : adj.get(item)){
                    if(!visited[j]){
                        q.offer(j);
                        visited[j] = true;
                        ans++;
                    }
                }
            }

            maxLen++;
            if(maxLen == 2) break;
        }

        return ans;
    }

}
