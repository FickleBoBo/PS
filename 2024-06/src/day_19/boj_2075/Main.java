package day_19.BOJ_S2_2075;

import java.io.*;
import java.util.*;

public class Main_List {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0 ; j<N ; j++){
                list.add(Integer.parseInt(st.nextToken()));
            }
        }

        Collections.sort(list);

        // N번째로 큰 수의 위치 - N * N - N
        System.out.println(list.get(N * N - N));
    }
}
