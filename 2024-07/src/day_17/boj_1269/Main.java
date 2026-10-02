package day_17.BOJ_S4_1269;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            set.add(Integer.parseInt(st.nextToken()));
        }

        // 두 대칭 차집합의 크기의 합은 전체 집합의 두배에서 각 집합의 크기를 뺀 것과 같다
        System.out.println(set.size() * 2 - cnt);
    }
}
