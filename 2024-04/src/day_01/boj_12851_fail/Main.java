package day_01.BOJ_G4_12851_Fail;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        boolean found = false;
        int time = 0;
        int cnt = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        int len = q.size();

        while(!q.isEmpty()){
            int pos = q.poll();
            len--;

            if(pos == K){
                cnt++;
                found = true;
            }

            q.offer(pos-1);
            q.offer(pos+1);
            q.offer(2*pos);

            if(len==0){
                if(found){
                    break;
                }
                len = q.size();
                time++;
            }
        }

        System.out.println(time);
        System.out.println(cnt);

        sc.close();
    }
}
