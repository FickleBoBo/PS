package day_18.BOJ_S4_4949;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String str = br.readLine();
            if(str.equals(".")) break;    // 종료 조건

            char[] input = str.toCharArray();

            Deque<Character> stack = new ArrayDeque<>();
            boolean flag = true;    // 균형잡힌 문자열인지 여부를 판단

            for(char c : input){
                // 1. 열린 괄호면 푸시
                if(c == '(' || c == '['){
                    stack.push(c);
                }
                // 2. 닫힌 괄호면 스택이 비었는지, 스택의 peek와 짝을 이루는지 판단
                else if(c == ')'){
                    if(stack.isEmpty() || stack.peek() == '['){
                        flag = false;
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }
                else if(c == ']'){
                    if(stack.isEmpty() || stack.peek() == '('){
                        flag = false;
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }
            }

            // 3. 남은 열린 괄호가 스택에 있으면 균형잡인 문자열이 아님
            if(!stack.isEmpty()) flag = false;

            if(flag) bw.write("yes\n");
            else bw.write("no\n");
        }

        bw.flush();
    }
}
