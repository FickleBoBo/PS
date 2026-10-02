package day_18.BOJ_S4_2164;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();

        for(int i=1 ; i<=N ; i++){
            q.offer(i);
        }

        while(q.size() > 1){
            q.poll();
            q.offer(q.poll());
        }

        System.out.println(q.poll());
    }
}
