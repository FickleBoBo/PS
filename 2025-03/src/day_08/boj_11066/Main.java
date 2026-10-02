package day_08.BOJ_11066;

import java.io.*;
import java.util.*;

// 실패
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine());

            int[] arr = new int[K];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;

            for (int k = 0; k < K - 1; k++) {
                int startIdx = -1;
                int endIdx = -1;
                int min = Integer.MAX_VALUE;

                for (int i = 0; i < K - 1; i++) {
                    if (arr[i] == 0) continue;

                    for (int j = i + 1; j < K; j++) {
                        if (arr[j] == 0) continue;

                        if (arr[i] + arr[j] < min) {
                            min = arr[i] + arr[j];
                            startIdx = i;
                            endIdx = j;
                        }

                        break;
                    }
                }

                System.out.println(startIdx + " " + endIdx);
                System.out.println(Arrays.toString(arr));

                sum += arr[startIdx] + arr[endIdx];
                arr[startIdx] += arr[endIdx];
                arr[endIdx] = 0;
            }

            sb.append(sum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
