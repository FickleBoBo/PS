package day_15.BOJ_B1_6996;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        out:
        for(int tc=1 ; tc<=T ; tc++){
            st = new StringTokenizer(br.readLine());

            String str1 = st.nextToken();
            String str2 = st.nextToken();

            // 두 단어의 길이가 다르면 애너그램이 될 수 없음
            if(str1.length() != str2.length()){
                sb.append(str1).append(" & ").append(str2).append(" are NOT anagrams.\n");
                continue;
            }

            char[] charArr1 = str1.toCharArray();
            char[] charArr2 = str2.toCharArray();

            Arrays.sort(charArr1);
            Arrays.sort(charArr2);

            // 애너그램이면 정렬했을 때 각 자리 알파벳이 모두 일치해야 함
            for(int i=0 ; i<charArr1.length ; i++){
                if(charArr1[i] != charArr2[i]){
                    sb.append(str1).append(" & ").append(str2).append(" are NOT anagrams.\n");
                    continue out;
                }
            }

            // 모든 조건을 만족하면 애너그램
            sb.append(str1).append(" & ").append(str2).append(" are anagrams.\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
