package day_29.BOJ_G5_13549_Fail;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(BFS(N, K));

        sc.close();
    }

    private static int BFS(int n, int k){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n, 0});

        while((!q.isEmpty()) && (q.peek()[0]!=k)){
            int[] next = q.poll();

            if(next[0]-1 >= 0){
                q.offer(new int[]{next[0]-1, next[1]+1});
            }
            if(next[0]+1 <= k){
                q.offer(new int[]{next[0]+1, next[1]+1});
            }
            if(next[0]*2 <= k){
                q.offer(new int[]{next[0]*2, next[1]});
            }

        }
        return q.peek()[1];
    }

}
