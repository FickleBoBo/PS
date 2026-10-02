package day_05.BOJ_1316;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;

        out:
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            boolean[] visited = new boolean[26];
            visited[input[0] - 'a'] = true;

            for (int j = 1; j < input.length; j++) {
                if ((input[j] != input[j - 1]) && visited[input[j] - 'a']) continue out;
                visited[input[j] - 'a'] = true;
            }

            cnt++;
        }

        System.out.println(cnt);
    }
}
