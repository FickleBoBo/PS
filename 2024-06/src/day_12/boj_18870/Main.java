package day_12.BOJ_S2_18870;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        int idx = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<N ; i++){
            if(!map.containsKey(sortedArr[i])){
                map.put(sortedArr[i], idx++);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<N ; i++){
            sb.append(map.get(arr[i])).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
