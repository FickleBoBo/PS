package day_26.BOJ_S1_5014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt();
        int S = sc.nextInt();
        int G = sc.nextInt();
        int U = sc.nextInt();
        int D = sc.nextInt();

        boolean[] visited = new boolean[F+1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        visited[S] = true;
        int n = 0;
        int cnt = q.size();
        boolean flag = false;

        while(!q.isEmpty()){
            int item = q.poll();
            cnt--;

            if(item == G){
                flag = true;
                break;
            }

            if((item+U <= F) && (!visited[item+U])){
                q.offer(item+U);
                visited[item+U] = true;
            }
            if((item-D >= 1) && (!visited[item-D])){
                q.offer(item-D);
                visited[item-D] = true;
            }

            if(cnt == 0){
                cnt = q.size();
                n++;
            }
        }

        if(flag) System.out.println(n);
        else System.out.println("use the stairs");

        sc.close();
    }
}
