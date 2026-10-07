package day_06.boj_10989;

import java.io.*;

public class Main {

    static final int MAX = 10000;
    static int[] cnt = new int[1 + MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            cnt[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i <= MAX; i++) {
            for (int j = 1; j <= cnt[i]; j++) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
