package day_18.BOJ_S5_11728;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> q1 = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            q1.offer(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> q2 = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            q2.offer(Integer.parseInt(st.nextToken()));
        }

        for(int i=0 ; i<N+M ; i++){
            if(!q1.isEmpty() && !q2.isEmpty()){
                sb.append(q1.peek() < q2.peek() ? q1.poll() : q2.poll()).append(" ");
            }
            else if(q1.isEmpty()){
                sb.append(q2.poll()).append(" ");
            }
            else{
                sb.append(q1.poll()).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
