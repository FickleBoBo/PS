package day_24.boj_10214;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int ysum = 0;
            int ksum = 0;

            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                ysum += y;
                ksum += k;
            }

            if (ysum > ksum) {
                bw.write("Yonsei\n");
            } else if (ysum < ksum) {
                bw.write("Korea\n");
            } else {
                bw.write("Draw\n");
            }
        }

        bw.flush();
    }
}
