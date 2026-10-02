package day_04.BOJ_16165;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, TreeSet<String>> map = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String team = br.readLine();
            int size = Integer.parseInt(br.readLine());

            map.put(team, new TreeSet<>());
            for (int j = 0; j < size; j++) {
                String member = br.readLine();
                map.get(team).add(member);
                map2.put(member, team);
            }
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            int type = Integer.parseInt(br.readLine());

            if (type == 0) {
                for (String member : map.get(input)) {
                    sb.append(member).append("\n");
                }
            } else {
                sb.append(map2.get(input)).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
