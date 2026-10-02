package day_26.BOJ_S4_11652;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // key에는 숫자 카드의 값, value에는 숫자 카드의 개수를 저장하는 map
        Map<Long, Integer> map = new HashMap<>();

        for(int i=0 ; i<N ; i++){
            long num = Long.parseLong(br.readLine());

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        long maxKey = 0;    // 가장 많이 가지고 있는 정수
        int maxCnt = 0;    // 가장 많이 가지고 있는 정수의 개수

        for(long key : map.keySet()){
            if(map.get(key) > maxCnt){
                maxKey = key;
                maxCnt = map.get(key);
            }
            else if((map.get(key) == maxCnt) && (key < maxKey)){
                maxKey = key;
            }
        }

        System.out.println(maxKey);
    }
}
