package day_01.BOJ_S2_18870;

import java.io.*;
import java.util.*;

public class Main_HashMap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] sortedArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++){
            arr[i] = sortedArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sortedArr);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for(int i=0 ; i<N ; i++){
            if(!map.containsKey(sortedArr[i])){
                map.put(sortedArr[i], rank++);
            }
        }

        for(int i=0 ; i<N ; i++){
            sb.append(map.get(arr[i])).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
