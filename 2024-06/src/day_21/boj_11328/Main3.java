package day_21.BOJ_B2_11328;

import java.io.*;
import java.util.*;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1 ; tc<=T ; tc++){

            st = new StringTokenizer(br.readLine());
            char[] str1 = st.nextToken().toCharArray();
            char[] str2 = st.nextToken().toCharArray();

            // 두 문자열의 길이가 다르면 더 비교할 필요없음
            if(str1.length != str2.length){
                bw.write("Impossible\n");
                continue;
            }

            // char[]을 정렬하면 알파벳 순서로 정렬됨
            Arrays.sort(str1);
            Arrays.sort(str2);

            // flag는 각 인덱스의 알파벳이 서로 다르면 false
            boolean flag = true;
            for(int i=0 ; i<str1.length ; i++){
                if(str1[i] != str2[i]){
                    flag = false;
                    break;
                }
            }

            // 삼항 연산자로 조건문 축약
            bw.write(flag ? "Possible\n" : "Impossible\n");
        }

        bw.flush();
        bw.close();
    }
}
