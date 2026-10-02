package day_20.BOJ_S5_5648;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // EOF 까지 입력 받기
        while(true){
            String input = br.readLine();
            if(input == null) break;

            sb.append(input).append(" ");
        }

        // StringTokenizer로 파싱
        st = new StringTokenizer(sb.toString());

        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];

        // 역원소를 배열에 넣어줌
        for(int i=0 ; i<N ; i++){
            String num = st.nextToken();
            long result = 0;

            long q = 1;
            for(int j=0 ; j<num.length() ; j++){
                result += (num.charAt(j) - '0') * q;
                q *= 10;
            }

            arr[i] = result;
        }

        Arrays.sort(arr);

        sb = new StringBuilder();
        for(long n : arr) sb.append(n).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
