package day_02.BOJ_S4_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){

            char[] input = br.readLine().toCharArray();
            boolean flag = true;

            for(int i=0 ; i<input.length ; i++){
                if(input[i]=='('){
                    stack.push('(');
                }
                else if(input[i]==')'){
                    if(!stack.empty()){
                        stack.pop();
                    }
                    else{
                        flag = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()) flag = false;

            if(flag) System.out.println("YES");
            else System.out.println("NO");
            stack.clear();
        }

        br.close();
    }
}
