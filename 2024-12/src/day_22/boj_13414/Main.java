package day_22.BOJ_13414;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Set<String> set = new LinkedHashSet<>();

        for (int i = 0; i < L; i++) {
            String id = br.readLine();

            set.remove(id);
            set.add(id);
        }

        int cnt = 0;
        for (String id : set) {
            sb.append(id).append("\n");
            cnt++;

            if (cnt == K) break;
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
