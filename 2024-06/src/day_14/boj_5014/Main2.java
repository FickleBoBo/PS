package day_14.BOJ_S1_5014;

import java.io.*;
import java.util.*;

public class Main2 {

    // 노드 클래스에 위치와 이동 횟수를 저장하는 방식으로도 가능
    static class Node {
        int pos;
        int cnt;

        public Node(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int ans = BFS(S, G, F, U, D);
        if(ans >= 0){    // S == G 인 케이스가 테케 30% 에 있음
            System.out.println(ans);
        }
        else{
            System.out.println("use the stairs");
        }
    }

    private static int BFS(int curr, int target, int height, int up, int down){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(curr, 0));

        boolean[] visited = new boolean[1+height];
        visited[curr] = true;

        while(!q.isEmpty()){
            Node node = q.poll();

            // 목표층에 도달하면 종료
            if(node.pos == target){
                return node.cnt;
            }

            // 다음 층이 건물에 있는 층이면서 방문 안한 층이면 Queue에 넣어줌
            int nextUp = node.pos + up;
            if((nextUp <= height) && (!visited[nextUp])){
                q.offer(new Node(nextUp, node.cnt + 1));
                visited[nextUp] = true;
            }
            int nextDown = node.pos - down;
            if((nextDown >= 1) && (!visited[nextDown])){
                q.offer(new Node(nextDown, node.cnt + 1));
                visited[nextDown] = true;
            }

        }

        // G층에 도달할 수 없으면 음수를 리턴해서 조건문에 활용
        return -1;
    }

}
