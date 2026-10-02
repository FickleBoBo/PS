package day_29.BOJ_S2_11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List[] nodes;
    static int[] p;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        nodes = new ArrayList[1+N];

        nodes[1] = new ArrayList<Integer>();
        for(int i=2 ; i<=N ; i++){
            nodes[i] = new ArrayList<Integer>();
            sb.append(br.readLine()+" ");
        }

        StringTokenizer st = new StringTokenizer(sb.toString(), " ");
        p = new int[1+N];

        while(st.hasMoreTokens()){
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            nodes[node1].add(node2);
            nodes[node2].add(node1);
        }

        BFS(1);

        for(int i=2 ; i<=N ; i++){
            System.out.println(p[i]);
        }

        br.close();
    }

    private static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        p[node] = node;

        while(!q.isEmpty()){
            int item = q.poll();

            for(int i=0 ; i<nodes[item].size() ; i++){
                int connect = (int) nodes[item].get(i);
                if(p[connect] == 0){
                    p[connect] = item;
                    q.offer(connect);
                }
            }
        }

    }
}
