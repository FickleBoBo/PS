package day_26.BOJ_B3_10818;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());

            // 정수의 개수가 한개인 경우 주의(테스트 케이스 98%)
            if(num > max) max = num;
            if(num < min) min = num;
        }
        sb.append(min).append(" ").append(max);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
