package day_30.BOJ_G4_14226_Fail;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static class Node {
        int cnt;
        int buffer;

        public Node(int cnt, int buffer) {
            this.cnt = cnt;
            this.buffer = buffer;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();

        System.out.println(BFS(S));
    }

    private static int BFS(int s){
        Queue<Node> q = new LinkedList<>();
        int[] visited = new int[2000];

        q.offer(new Node(1, 0));

        int ans = 0;
        while(!q.isEmpty()){
            int len = q.size();
            System.out.println(len);
            for(int i=0 ; i<len ; i++){
                Node item = q.poll();
                if(item.cnt == s){
                    return ans;
                }

                if(visited[item.cnt] != item.cnt){
                    q.offer(new Node(item.cnt, item.cnt));
                }
                if(visited[item.cnt + item.buffer] != item.buffer){
                    q.offer(new Node(item.cnt + item.buffer, item.buffer));
                }
                if(item.cnt - 1 >= 0 && visited[item.cnt - 1] != item.buffer){
                    q.offer(new Node(item.cnt - 1, item.buffer));
                }
            }
            ans++;
        }

        return -1;
    }

}
