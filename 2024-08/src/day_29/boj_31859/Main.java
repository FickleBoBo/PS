package day_29.BOJ_B1_31859;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        char[] input = st.nextToken().toCharArray();

        Set<Character> set = new HashSet<>();

        // 3번 규칙
        sb.append(N + 1906);

        // 1번 규칙
        for(char c : input){
            if(!set.contains(c)){
                sb.append(c);
                set.add(c);
            }
        }

        // 2번 규칙
        sb.append(input.length - set.size() + 4);

        // 5번 규칙
        sb.append("_cpums");

        // 4번 규칙
        sb.reverse();

        bw.write(sb.toString());
        bw.flush();
    }
}
