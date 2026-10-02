package day_01.BOJ_S2_18870;

import java.io.*;
import java.util.*;

public class Main_TreeSet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        SortedSet<Integer> sortedSet = new TreeSet<>();
        for(int i=0 ; i<N ; i++){
            sortedSet.add(arr[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for(int item : sortedSet){
            map.put(item, rank++);
        }

        for(int i=0 ; i<N ; i++){
            sb.append(map.get(arr[i])).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
