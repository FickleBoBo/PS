package day_13.BOJ_G2_1368_Fail;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();

        PriorityQueue<int[]> nodes = new PriorityQueue<>(((o1, o2) -> {
            return o1[1] - o2[1];
        }));

        for(int i=1 ; i<=V ; i++){
            nodes.add(new int[]{i, sc.nextInt()});
        }

        int[][] adj = new int[1+V][1+V];
        for(int i=1 ; i<=V ; i++){
            for(int j=1 ; j<=V ; j++){
                adj[i][j] = sc.nextInt();
            }
        }

        p = new int[1+V];
        for(int i=1 ; i<=V ; i++){
            p[i] = i;
        }

        boolean[] visited = new boolean[1+V];
        int ans = 0;

        int[] start = nodes.poll();
        visited[start[0]] = true;
        ans += start[1];

        for(int i=2 ; i<=V ; i++){
            int[] node = nodes.poll();





        }

        System.out.println(ans);

        sc.close();
    }

    static int[] p;

    private static int find(int x){
        if(x != p[x]) p[x] = find(p[x]);
        return p[x];
    }

    private static void union(int x, int y){
        p[y] = x;
    }

}
