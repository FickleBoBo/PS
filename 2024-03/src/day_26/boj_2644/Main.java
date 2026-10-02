package day_26.BOJ_S2_2644;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int m = sc.nextInt();

        List[] adjList = new List[n+1];
        for(int i=1 ; i<=n ; i++){
            adjList[i] = new LinkedList<Integer>();
        }

        for(int i=0 ; i<m ; i++){
            int p = sc.nextInt();
            int c = sc.nextInt();
            adjList[p].add(c);
            adjList[c].add(p);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.offer(n1);
        visited[n1] = true;
        int ans = 0;
        boolean flag = false;
        int cnt = q.size();

        out:
        while(!q.isEmpty()){
            int item = q.poll();
            cnt--;
            for(int i=0 ; i<adjList[item].size() ; i++){
                int connect = (int) adjList[item].get(i);
                if(!visited[connect]){
                    q.offer(connect);
                    visited[connect] = true;
                    if(connect == n2){
                        flag = true;
                        break out;
                    }
                }
            }
            if(cnt == 0){
                cnt = q.size();
                ans++;
            }
        }

        if(flag) System.out.println(ans+1);
        else System.out.println(-1);

        sc.close();
    }
}
