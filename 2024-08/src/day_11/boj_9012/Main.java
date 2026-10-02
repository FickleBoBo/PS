package day_11.BOJ_S4_9012;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=0 ; i<N ; i++){
            char[] input = br.readLine().toCharArray();

            // Deque로 스택을 구현하고 VPS면 flag가 true
            Deque<Character> stack = new ArrayDeque<>();
            boolean flag = true;

            for(char c : input){
                // 열린 괄호면 푸시
                if(c == '('){
                    stack.push(c);
                }
                // 닫힌 괄호일 때 스택이 비었으면 VPS가 아님
                else{
                    if(stack.isEmpty()){
                        flag = false;
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }
            }

            // 남은 열린 괄호가 스택에 있으면 VPS가 아님
            if(!stack.isEmpty()) flag = false;

            if(flag) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.flush();
        bw.close();
    }
}
