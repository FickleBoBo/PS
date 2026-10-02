package day_01.BOJ_S2_16953;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long A = sc.nextInt();
        long B = sc.nextInt();

        int ans = 1;
        Queue<Long> q = new LinkedList<>();
        q.offer(A);
        int cnt = q.size();

        boolean flag = false;
        while(!q.isEmpty()){
            Long num = q.poll();
            cnt--;

            if(num == B){
                flag = true;
                break;
            }

            if(num * 2 <= B){
                q.offer(num * 2);
            }
            if(num * 10 + 1 <= B){
                q.offer(num * 10 + 1);
            }

            if(cnt == 0){
                cnt = q.size();
                ans++;
            }
        }

        if(flag) System.out.println(ans);
        else System.out.println(-1);

        sc.close();
    }
}
