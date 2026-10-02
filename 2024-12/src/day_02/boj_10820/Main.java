package day_02.BOJ_10820;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str;

        while ((str = br.readLine()) != null) {
            char[] input = str.toCharArray();
            int[] cntArr = new int[128];

            for (char c : input) {
                cntArr[c]++;
            }

            sb.append(sum(cntArr, 'a', 'z')).append(" ")
                    .append(sum(cntArr, 'A', 'Z')).append(" ")
                    .append(sum(cntArr, '0', '9')).append(" ")
                    .append(sum(cntArr, ' ', ' ')).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    // 카운팅 배열의 구간합
    private static int sum(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        return sum;
    }

}
