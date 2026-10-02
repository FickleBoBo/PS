package day_13.BOJ_1592;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] cntArr = new int[N];
        cntArr[0]++;

        int pos = 0;
        int cnt = 0;
        while (true) {
            if (cntArr[pos] == M) break;
            else if (cntArr[pos] % 2 == 1) {
                pos = (pos + N + L) % N;
                cntArr[pos]++;
            } else {
                pos = (pos + N - L) % N;
                cntArr[pos]++;
            }

            cnt++;
        }

        System.out.println(cnt);
    }
}
