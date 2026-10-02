package day_05.BOJ_S4_1822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());

        Map<Integer, Boolean> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            map.put(Integer.parseInt(st.nextToken()), true);
        }
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            map.remove(Integer.parseInt(st.nextToken()));
        }

        System.out.println(map.size());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int key : map.keySet()){
            pq.add(key);
        }

        while(!pq.isEmpty()){
            System.out.print(pq.poll() + " ");
        }
    }
}
