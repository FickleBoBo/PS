package day_26.BOJ_S5_10814;

import java.io.*;
import java.util.StringTokenizer;

public class Main_StringBuilder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        StringBuilder[] sbArr = new StringBuilder[1+200];    // 카운팅 배열
        for(int i=0 ; i<=200 ; i++){    // enhenced for 문으로 출력할거라 0번도 초기화
            sbArr[i] = new StringBuilder();
        }

        int N = Integer.parseInt(br.readLine());
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            sbArr[age].append(age).append(" ").append(name).append("\n");
        }

        for(StringBuilder sb : sbArr){
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }
}
