package day_15.BOJ_S4_1269;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;    // 중복 원소의 개수

        Set<String> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            set.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            if(set.contains(st.nextToken())){
                cnt++;
            }
        }

        System.out.println(N + M - 2 * cnt);
    }
}
