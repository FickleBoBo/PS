package day_11.BOJ_S5_2822;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] dp = new int[8][2];
        for(int i=0 ; i<8 ; i++){
            dp[i][0] = i+1;
            dp[i][1] = sc.nextInt();
        }

        Arrays.sort(dp, ((o1, o2) -> {
            return o1[1] - o2[1];
        }));

        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=3 ; i<8 ; i++){
            sum += dp[i][1];
            pq.offer(dp[i][0]);
        }

        System.out.println(sum);
        while(!pq.isEmpty()){
            System.out.print(pq.poll() + " ");
        }
    }
}
