package day_19.BOJ_S1_11286;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> positiveNums = new PriorityQueue<>();
        PriorityQueue<Integer> negativeNums = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        for(int i=0 ; i<N ; i++){
            int x = Integer.parseInt(br.readLine());

            if(x > 0){
                positiveNums.offer(x);
            }
            else if(x < 0){
                negativeNums.offer(x);
            }
            else{
                if(positiveNums.isEmpty() && negativeNums.isEmpty()){
                    sb.append(0).append("\n");
                }
                else if(positiveNums.isEmpty()){
                    sb.append(negativeNums.poll()).append("\n");
                }
                else if(negativeNums.isEmpty()){
                    sb.append(positiveNums.poll()).append("\n");
                }
                else{
                    int num = positiveNums.peek() < (-negativeNums.peek()) ? positiveNums.poll() : negativeNums.poll();
                    sb.append(num).append("\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
