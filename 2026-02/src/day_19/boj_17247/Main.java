package day_19.boj_17247;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<int[]> pos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) pos.add(new int[]{i, j});
            }
        }

        System.out.println(Math.abs(pos.get(0)[0] - pos.get(1)[0]) + Math.abs(pos.get(0)[1] - pos.get(1)[1]));
    }
}
