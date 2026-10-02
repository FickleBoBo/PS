package day_24.BOJ_S2_11724;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static List[] graph;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new List[N+1];
        for(int i=1 ; i<=N ; i++){
            graph[i] = new LinkedList<Integer>();
        }

        for(int i=0 ; i<M ; i++){
            int nodeNum = sc.nextInt();
            int connectTo = sc.nextInt();
            graph[nodeNum].add(connectTo);
            graph[connectTo].add(nodeNum);
        }
        visited = new boolean[N+1];

        int cnt = 0;
        for(int i=1 ; i<=N ; i++){
            for(int j=0 ; j<graph[i].size() ; j++){
                int node = (int) graph[i].get(j);
                if(!visited[node]){
                    BFS(node);
                    cnt++;
                }
            }
        }

        for(int i=1 ; i<=N ; i++){
            if(!visited[i]) cnt++;
        }

        System.out.println(cnt);
    }

    private static void BFS(int curNode){
        Queue<Integer> q = new LinkedList<>();
        q.offer(curNode);
        visited[curNode] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int i=0 ; i<graph[node].size() ; i++){
                int thisNode = (int) graph[node].get(i);
                if(!visited[thisNode]){
                    q.offer(thisNode);
                    visited[thisNode] = true;
                }
            }
        }
    }

}
