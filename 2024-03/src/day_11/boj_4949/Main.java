package day_11.BOJ_S4_4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        while(true){
            char[] input = str.toCharArray();
            Stack<Character> st = new Stack<>();

            boolean balance = true;
            for(int i=0 ; i<input.length ; i++){
                if((input[i] == '(') || (input[i] == '[')){
                    st.push(input[i]);
                }
                else if(input[i] == ')'){
                    if((!st.isEmpty()) && (st.peek() == '(')){
                        st.pop();
                    }
                    else{
                        balance = false;
                        break;
                    }
                }
                else if(input[i] == ']'){
                    if((!st.isEmpty()) && (st.peek() == '[')){
                        st.pop();
                    }
                    else{
                        balance = false;
                        break;
                    }
                }
            }

            if(!st.isEmpty()) balance = false;

            if(balance) System.out.println("yes");
            else System.out.println("no");

            str = br.readLine();
            if(str.equals(".")) break;
        }

        br.close();
    }
}
