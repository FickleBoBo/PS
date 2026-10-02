package day_27.BOJ_S4_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        Map<String, Integer> map = new HashMap<>();
        while(st1.hasMoreTokens()){
            String key = st1.nextToken();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();
        while(st2.hasMoreTokens()){
            sb.append(map.getOrDefault(st2.nextToken(), 0) + " ");
        }

        System.out.println(sb.toString());
    }
}
