package day_26.BOJ_S1_1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        boolean[] visited = new boolean[100001];


        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        visited[N] = true;
        int time = 0;
        int cnt = 1;

        while(!q.isEmpty()){
            int item = q.poll();
            cnt--;

            if(item == K){
                break;
            }

            if((item+1<=100000) && (!visited[item+1])){
                q.offer(item+1);
                visited[item+1] = true;
            }
            if((item-1>=0) && (!visited[item-1])){
                q.offer(item-1);
                visited[item-1] = true;
            }
            if((item*2<=100000) && (!visited[item*2])){
                q.offer(item*2);
                visited[item*2] = true;
            }

            if(cnt == 0){
                cnt = q.size();
                time++;
            }
        }

        System.out.println(time);

        sc.close();
    }
}
