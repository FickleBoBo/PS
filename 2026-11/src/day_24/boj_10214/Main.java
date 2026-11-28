package day_24.boj_10214;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int ySum = 0;
            int kSum = 0;

            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                ySum += y;
                kSum += k;
            }

            if (ySum > kSum) {
                bw.write("Yonsei\n");
            } else if (ySum < kSum) {
                bw.write("Korea\n");
            } else {
                bw.write("Draw\n");
            }
        }

        bw.flush();
    }
}
