package day_07.BOJ_S4_1764;

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

        PriorityQueue<String> pq = new PriorityQueue<>();

        Set<String> set = new HashSet<>();
        for(int i=0 ; i<N ; i++) set.add(br.readLine());

        for(int i=0 ; i<M ; i++){
            String input = br.readLine();

            if(set.contains(input)){
                pq.offer(input);
            }
        }

        sb.append(pq.size()).append("\n");
        while(!pq.isEmpty()) sb.append(pq.poll()).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
