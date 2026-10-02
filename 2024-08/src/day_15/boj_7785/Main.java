package day_15.BOJ_S5_7785;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            boolean leave = st.nextToken().equals("leave");

            if(leave) set.remove(name);
            else set.add(name);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(set);

        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
