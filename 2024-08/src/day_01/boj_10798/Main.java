package day_01.BOJ_B1_10798;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 각 행을 담고 있는 큐 배열 초기화
        Queue<Character>[] queues = new ArrayDeque[5];
        for(int i=0 ; i<5 ; i++){
            queues[i] = new ArrayDeque<>();

            char[] input = br.readLine().toCharArray();
            for(char c : input) queues[i].offer(c);
        }

        while(true){
            boolean flag = true;

            // 큐 배열의 각 행에 남은 원소가 있으면 하나씩 꺼내서 담음
            for(int i=0 ; i<5 ; i++){
                if(!queues[i].isEmpty()){
                    sb.append(queues[i].poll());
                    flag = false;
                }
            }

            // 큐 배열에서 한번도 원소를 꺼낸 적이 없으면 종료
            if(flag) break;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
