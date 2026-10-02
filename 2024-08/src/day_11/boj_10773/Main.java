package day_11.BOJ_S4_10773;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0 ; i<K ; i++){
            int n = Integer.parseInt(br.readLine());

            if(n == 0) stack.pop();
            else stack.push(n);
        }

        int sum = 0;
        while(!stack.isEmpty()) sum += stack.pop();

        System.out.println(sum);
    }
}
