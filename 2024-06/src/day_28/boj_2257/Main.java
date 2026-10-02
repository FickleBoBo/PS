package day_28.BOJ_S2_2257;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int ans = 0;

        Stack<String> st = new Stack<>();
        for(int i=0 ; i<input.length() ; i++){
            char ch = input.charAt(i);

            if(ch == '('){
                st.push("(");
            }
            else if(ch == ')'){
                int tmp = 0;
                while(true){
                    String pop = st.pop();
                    if(pop.equals("(")){
                        break;
                    }
                    tmp += Integer.parseInt(pop);
                }
                st.push(String.valueOf(tmp));
            }
            else if(ch == 'H'){
                st.push("1");
            }
            else if(ch == 'C'){
                st.push("12");
            }
            else if(ch == 'O'){
                st.push("16");
            }
            else{
                int tmp = Integer.parseInt(st.pop());
                st.push(String.valueOf(tmp * (ch-'0')));
            }
        }

        while(!st.isEmpty()){
            ans += Integer.parseInt(st.pop());
        }

        System.out.println(ans);
    }
}
