package day_24.BOJ_S3_2910;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, C는 필요 없음
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // HashMap(카운팅) + LinkedList(순서유지)
        Map<Integer, Integer> map = new LinkedHashMap<>();

        // 카운팅 해줌
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // entry는 키와 밸류 쌍 객체
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        // 빈도 정렬을 해주는데 LinkedHashMap으로 기본 순서를 가져온채로 정렬(Comparator는 정렬 기준만 제공하고, list.sort는 안정정렬 제공)
        list.sort(((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue())));

        for(Map.Entry<Integer, Integer> item : list){
            int key = item.getKey();
            int value = item.getValue();

            for(int i=0 ; i<value ; i++){
                sb.append(key).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
