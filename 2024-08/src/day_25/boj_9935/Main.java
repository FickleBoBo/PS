package day_25.BOJ_G4_9935;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] input = br.readLine().toCharArray();
        String str = br.readLine();

        Deque<Character> deque = new ArrayDeque<>();    // 문자열의 문자를 저장하는 디큐로 출력은 큐로 판정은 스택으로 해줌
        Deque<Character> stack = new ArrayDeque<>();    // 폭발 문자열인지 판단하기 위한 스택

        for(char c : input){
            // 폭발 문자열의 끝 문자를 찾으면 폭발 문자열인지 디큐에서 하나씩 꺼내보면서 확인
            // 폭발 문자열의 끝 문자를 스택에 넣고 디큐의 나머지 문자들이 폭발 문자열이 되는지 확인해서 flag를 갱신
            if(c == str.charAt(str.length()-1)){
                stack.push(c);

                boolean flag = true;

                // 폭발 문자열의 길이가 디큐의 길이보다 크면 폭발 문자열일 수 없다
                if(deque.size() < str.length() - 1){
                    flag = false;
                }
                else{
                    for(int i=str.length()-2 ; i>=0 ; i--){
                        if(deque.peekLast() == str.charAt(i)){
                            stack.push(deque.pollLast());
                        }
                        else{
                            flag = false;
                            break;
                        }
                    }
                }

                // 폭발 문자열이면 스택을 비우면 되고 폭발 문자열이 아니면 스택에 있는 문자를 디큐에 다 넣어줌
                if(flag){
                    stack.clear();
                }
                else{
                    while(!stack.isEmpty()){
                        deque.addLast(stack.pop());
                    }
                }
            }
            // 폭발 문자열의 끝 문자가 아니면 그냥 디큐에 넣으면 됨
            else{
                deque.addLast(c);
            }
        }

        while(!deque.isEmpty()){
            sb.append(deque.pollFirst());
        }

        if(sb.toString().isEmpty()){
            bw.write("FRULA");
        }
        else{
            bw.write(sb.toString());
        }
        bw.flush();
    }
}
