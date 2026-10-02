package day_26.BOJ_S5_11650;

import java.io.*;
import java.util.*;

public class Main_Comparator_pq {

    static class MyComparator implements Comparator<int[]>{

        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[0] != o2[0]){
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // Comparator
        MyComparator myComparator = new MyComparator();

        PriorityQueue<int[]> pq = new PriorityQueue<>(myComparator);

        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());

            pq.offer(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        while(!pq.isEmpty()){
            int[] item = pq.poll();
            sb.append(item[0]).append(" ").append(item[1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
