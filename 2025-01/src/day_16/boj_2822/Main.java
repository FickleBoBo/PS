package day_16.BOJ_2822;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[][] arr = new int[1 + 8][2];
        for (int i = 1; i <= 8; i++) {
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, ((o1, o2) -> Integer.compare(o2[1], o1[1])));

        int sum = 0;
        boolean[] visited = new boolean[1 + 8];
        for (int i = 0; i < 5; i++) {
            sum += arr[i][1];
            visited[arr[i][0]] = true;
        }

        sb.append(sum).append("\n");
        for (int i = 1; i <= 8; i++) {
            if (visited[i]) sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
