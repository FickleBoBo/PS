package day_15.BOJ_S4_3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int tc=1 ; tc<=T ; tc++){
            char[] input = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();

            /* 스택이 비어있으면 푸시
            *  스택이 차있을 때 같은 단어면 푸시
            *  다른 단어면 팝
            *  반복 이후 스택이 비어있으면 좋은 단어 완성
            * */
            for(char c : input){
                if(stack.isEmpty()){
                    stack.push(c);
                }
                else{
                    if(stack.peek() == c){
                        stack.pop();
                    }
                    else{
                        stack.push(c);
                    }
                }
            }
            if(stack.isEmpty()){
                cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
