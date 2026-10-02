package day_21.BOJ_B2_11328;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1 ; tc<=T ; tc++){

            // 각 문자열의 각 알파벳 개수를 저장하는 카운팅 배열
            int[] cntArr1 = new int[26];
            int[] cntArr2 = new int[26];

            st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            // 두 문자열의 길이가 다르면 더 비교할 필요없음
            if(str1.length() != str2.length()){
                bw.write("Impossible\n");
                continue;
            }

            // 두 문자열의 길이가 같아서 하나의 반복문에서 같이 개수 세기 가능
            for(int i=0 ; i<str1.length() ; i++){
                cntArr1[str1.charAt(i) - 'a']++;
                cntArr2[str2.charAt(i) - 'a']++;
            }

            // flag는 사용한 개수가 다른 알파벳을 발견하면 false
            boolean flag = true;
            for(int i=0 ; i<26 ; i++){
                if(cntArr1[i] != cntArr2[i]){
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
