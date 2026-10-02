package day_02.BOJ_4153;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            if (arr[0] == 0) break;

            bw.write(Pythagorean(arr) ? "right\n" : "wrong\n");
        }

        bw.flush();
    }

    private static boolean Pythagorean(int[] arr) {
        return arr[0] * arr[0] + arr[1] * arr[1] == arr[2] * arr[2];
    }

}
