package day_30.SWEA_D4_5432_Fail;

import java.io.*;
import java.util.*;

public class Solution {

    static int openIdx = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for(int tc=1 ; tc<=T ; tc++){

            String[] input = bf.readLine().split("");

            Stack<Integer> stack = new Stack<Integer>();

            List<Integer> laser = new ArrayList<Integer>();
            int[] pipe = new int[input.length];

            int cnt = 0;

            for(int i=0 ; i<input.length ; i++){
                if(input[i].equals("(")){
                    stack.push(i);
                } else{
                    openIdx = stack.pop();
                    if((i-openIdx)>1){
                        for(int j=openIdx ; j<=i ; j++){
                            pipe[j]++;
                        }
                        cnt++;
                    } else{
                        laser.add(openIdx);
                    }
                }
            }

            for(int i=0 ; i<laser.size() ; i++){
                cnt += pipe[laser.get(i)];
            }
            System.out.printf("#%d %d\n", tc, cnt);
        }
        bf.close();
    }
}
