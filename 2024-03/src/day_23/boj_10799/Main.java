package day_23.BOJ_S2_10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> st = new Stack<>();
        int ans = 0;

        for(int i=0 ; i<input.length() ; i++){
            if(input.charAt(i) == '('){    // 막대기 들어오고
                st.push('(');
            }
            else{
                if(input.charAt(i-1) == '('){    // 레이저면
                    st.pop();
                    ans += st.size();
                }
                else{    // 막대기가 끝난거면
                    st.pop();
                    ans++;
                }
//                System.out.println(st.size() + " " + ans);
            }
        }

        System.out.println(ans);

    }
}
