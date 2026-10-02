package day_15.BOJ_31859;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        char[] name = st.nextToken().toCharArray();

        Set<Character> set = new HashSet<>();

        int cnt = 0;
        for (char c : name) {
            if (set.contains(c)) {
                cnt++;
                continue;
            }

            sb.append(c);
            set.add(c);
        }

        sb.append(cnt + 4);
        sb = new StringBuilder().append(N + 1906).append(sb);
        sb = new StringBuilder("smupc_").append(sb.reverse());

        bw.write(sb.toString());
        bw.flush();
    }
}
