package day_05.BOJ_11651;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] posArr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            posArr[i][0] = Integer.parseInt(st.nextToken());
            posArr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(posArr, (o1, o2) -> {
            if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o1[1], o2[1]);
        });

        for (int[] pos : posArr) {
            sb.append(pos[0]).append(" ").append(pos[1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
