package day_21.BOJ_B5_10807;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 배열의 0번 인덱스부터 -100을 저장해야 한다
        int[] cntArr = new int[100+1+100];

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            cntArr[num + 100]++;    // 100만큼의 보정을 해준다
        }

        int v = Integer.parseInt(br.readLine());

        System.out.println(cntArr[v+100]);
    }
}
