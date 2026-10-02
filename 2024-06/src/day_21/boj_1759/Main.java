package day_21.BOJ_G5_1759;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] arr;
    static int R;
    static String[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new String[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++){
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);    // 입력 값이 사전순이 아니므로 정렬

        sel = new String[R];

        combination(0, 0);    // 조합

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void combination(int idx, int sidx){
        if(sidx == R){
            if(meetCondition()){    // 문제 조건을 만족하면 StringBuilder에 추가
                for(String s : sel){
                    sb.append(s);
                }
                sb.append("\n");
            }
            return;
        }

        for(int i=idx ; i<N ; i++){
            sel[sidx] = arr[i];
            combination(i+1, sidx+1);
        }
    }

    // 자음이 2개 이상, 모음이 1개 이상이 있으면 true 아니면 false 반환
    private static boolean meetCondition() {
        int ja = 0;
        int mo = 0;
        for(String s : sel){
            if(s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")){
                mo++;
            }
            else{
                ja++;
            }
        }

        if(mo >= 1 && ja >= 2) return true;
        else return false;
    }

}
