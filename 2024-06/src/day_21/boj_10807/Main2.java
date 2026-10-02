package day_21.BOJ_B5_10807;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // Key에 정수의 종류, Value에 해당 정수의 개수를 저장하는 해시맵
        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());

            // num이라는 key가 있으면 value에 +1 해서 저장
            // num이라는 key가 없으면 0을 반환받고 +1 해서 저장
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int v = Integer.parseInt(br.readLine());

        // v에 해당하는 값이 없으면 0을 반환하기 위해 getOrDefault 사용
        System.out.println(map.getOrDefault(v, 0));
    }
}
