package day_03.BOJ_S5_2751;

import java.io.*;
import java.util.*;

public class Main_treeSet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Set<Integer> set = new TreeSet<>();
        for(int i=0 ; i<N ; i++){
            set.add(Integer.parseInt(br.readLine()));
        }

        for(int n : set){
            sb.append(n).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
