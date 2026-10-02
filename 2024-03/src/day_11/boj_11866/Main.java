package day_11.BOJ_S5_11866;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        String ans = "<";

        Queue<Integer> q = new LinkedList<>();
        for(int i=1 ; i<=N ; i++){
            q.offer(i);
        }

        // 요세푸스는 Queue가 정석인듯
        while(!q.isEmpty()){
            int k = K-1;
            while(k > 0){
                q.offer(q.poll());
                k--;
            }
            ans += q.poll() + ", ";
        }

        System.out.println(ans.substring(0, ans.length()-2) + ">");

        sc.close();
    }
}
