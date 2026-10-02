package day_13.BOJ_S2_14248;

import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        int pos;
        int jump;

        public Node(int pos, int jump) {
            this.pos = pos;
            this.jump = jump;
        }
    }

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[1+N];

        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = Integer.parseInt(br.readLine());

        int ans = BFS(start);
        System.out.println(ans);
    }

    private static int BFS(int start){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(start, arr[start]));

        boolean[] visited = new boolean[1+N];
        visited[start] = true;

        int cnt = 1;

        while(!q.isEmpty()){
            Node node = q.poll();

            if(node.pos + node.jump <= N && !visited[node.pos + node.jump]){
                q.offer(new Node(node.pos + node.jump, arr[node.pos + node.jump]));
                visited[node.pos + node.jump] = true;
                cnt++;
            }
            if(node.pos - node.jump > 0 && !visited[node.pos - node.jump]){
                q.offer(new Node(node.pos - node.jump, arr[node.pos - node.jump]));
                visited[node.pos - node.jump] = true;
                cnt++;
            }
        }

        return cnt;
    }

}
