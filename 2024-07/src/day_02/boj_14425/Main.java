package day_02.BOJ_S4_14425;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i=0 ; i<N ; i++){
            set.add(br.readLine());
        }

        int cnt = 0;

        for(int i=0 ; i<M ; i++){
            if(set.contains(br.readLine())){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
