package day_26.BOJ_S3_1431;

import java.io.*;
import java.util.*;

public class Main_Comparator {

    // 해당 Character 타입 숫자의 Integer 값을 저장하는 맵
    static Map<Character, Integer> map = new HashMap<>();

    static class MyComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            // 조건 1
            if(o1.length() != o2.length()){
                return Integer.compare(o1.length(), o2.length());
            }
            else{
                int sum1 = 0;
                int sum2 = 0;

                for(int i=0 ; i<o1.length() ; i++){
                    sum1 += map.getOrDefault(o1.charAt(i), 0);
                }
                for(int i=0 ; i<o2.length() ; i++){
                    sum2 += map.getOrDefault(o2.charAt(i), 0);
                }

                // 조건 2
                if(sum1 != sum2){
                    return Integer.compare(sum1, sum2);
                }
            }
            // 조건 3
            return o1.compareTo(o2);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String[] strArr = new String[N];
        for(int i=0 ; i<N ; i++){
            strArr[i] = br.readLine();
        }

        // map의 값 초기화
        for(int i=0 ; i<10 ; i++) {
            map.put((char) (i + '0'), i);
        }

        MyComparator myComparator = new MyComparator();

        Arrays.sort(strArr, myComparator);

        for(int i=0 ; i<N ; i++){
            sb.append(strArr[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
