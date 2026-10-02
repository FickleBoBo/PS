package day_29.BOJ_G4_13913;

import java.util.*;

public class Main {

    static class Node {
        int pos;
        Node node = null;

        public Node(int pos) {
            this.pos = pos;
        }

        public Node(int pos, Node node) {
            this.pos = pos;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Node ans = BFS(N, K);

        Stack<Integer> st = new Stack<>();
        while(true){
            st.push(ans.pos);
            if(ans.node == null){
                break;
            }
            ans = ans.node;
        }

        System.out.println(st.size() - 1);
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop() + " ");
        }
        System.out.println(sb.toString());
    }

    private static Node BFS(int n, int k){
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[200_001];

        q.offer(new Node(n));
        visited[n] = true;

        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.pos == k) return node;

            if(node.pos * 2 <= 2 * k && !visited[node.pos * 2]){
                q.offer(new Node(node.pos * 2, node));
                visited[node.pos * 2] = true;
            }
            if(node.pos - 1 >= 0 && !visited[node.pos - 1]){
                q.offer(new Node(node.pos - 1, node));
                visited[node.pos - 1] = true;
            }
            if(node.pos + 1 <= k && !visited[node.pos + 1]){
                q.offer(new Node(node.pos + 1, node));
                visited[node.pos + 1] = true;
            }
        }
        return null;
    }

}
