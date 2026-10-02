package day_20.BOJ_S2_6603;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // combination에서 바로 사용하려고 static 변수로 선언
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr;
    static int R = 6;
    static int[] sel = new int[R];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true){
            String input = br.readLine();
            if(input.charAt(0) == '0') break;    // 종료 조건

            st = new StringTokenizer(input);

            N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            for(int i=0 ; i<N ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            combination(0, 0);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void combination(int idx, int sidx){
        if(sidx == R){
            for(int n : sel){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=idx ; i<N ; i++){
            sel[sidx] = arr[i];
            combination(i+1, sidx+1);
        }
    }

}
