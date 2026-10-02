package day_14.BOJ_S4_1764;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<String> set = new HashSet<>();
        PriorityQueue<String> ans = new PriorityQueue<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0 ; i<N ; i++){
            set.add(br.readLine());
        }

        for(int i=0 ; i<M ; i++){
            String name = br.readLine();

            if(set.contains(name)){
                ans.offer(name);
            }
        }

        sb.append(ans.size()).append("\n");
        while(!ans.isEmpty()){
            sb.append(ans.poll()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
