package day_26.BOJ_S4_10816_Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(st.hasMoreTokens()){
            pq.add(Integer.parseInt(st.nextToken()));
        }



        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] mList = new int[M];
        int idx = 0;
        while(st2.hasMoreTokens()){
            mList[idx++] = Integer.parseInt(st2.nextToken());
        }
        int[] cntArr = new int[M];

        while(!pq.isEmpty()){
            for(int j=0 ; j<M ; j++){
                while(!pq.isEmpty() && pq.peek() == mList[j]){
                    pq.poll();
                    cntArr[j]++;
                }
            }
            pq.poll();
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<M ; i++){
            sb.append(cntArr[i] + " ");
        }

        System.out.println(sb.toString());

    }
}
