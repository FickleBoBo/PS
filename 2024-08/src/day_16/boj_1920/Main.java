package day_16.BOJ_S4_1920;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Set<Integer> set = new HashSet<>();

        br.readLine();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            set.add(Integer.parseInt(st.nextToken()));
        }

        br.readLine();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            if(set.contains(Integer.parseInt(st.nextToken()))) sb.append("1\n");
            else sb.append("0\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
