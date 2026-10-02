package day_26.BOJ_S5_11651;

import java.io.*;
import java.util.*;

public class Main_Comparator {

    static class MyComparator implements Comparator<int[]>{

        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[1] != o2[1]){
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // Comparator
        MyComparator myComparator = new MyComparator();

        Arrays.sort(arr, myComparator);

        for(int[] item : arr){
            sb.append(item[0]).append(" ").append(item[1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
