package day_29.BOJ_P5_17071_Fail;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(BFS(N, K));
    }

    private static int BFS(int n, int k){
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[500_001];

        q.offer(n);
        visited[n] = -1;
        visited[k] = -1;

        int ans = 1;

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0 ; i<len ; i++){
                int item = q.poll();
                if(item == k) return ans;
                if(k<=500_000 && (visited[k] != 0) && (visited[k]%2 == (ans+1)%2)){
                    return ans;
                }

                if(item * 2 <= 500_000 && visited[item * 2]==0){
                    q.offer(item * 2);
                    visited[item * 2] = ans;
                }
                if(item - 1 >= 0 && visited[item - 1]==0){
                    q.offer(item - 1);
                    visited[item - 1] = ans;
                }
                if(item + 1 <= 500_000 && visited[item + 1]==0){
                    q.offer(item + 1);
                    visited[item + 1] = ans;
                }
            }

            k += ans;
            if(k<=500_000 && (visited[k] != 0) && (visited[k]%2 == ans%2)){
                return ans;
            }
            else if(k > 500_000){
                return -1;
            }
            ans++;
        }

        return -1;
    }

}
