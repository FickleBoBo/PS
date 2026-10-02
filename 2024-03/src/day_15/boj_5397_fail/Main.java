package day_15.BOJ_S2_5397_Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            List<Character> password = new LinkedList<>();
            int pos = 0;
            char[] input = br.readLine().toCharArray();

            for(char c : input){
                if(c == '<'){
                    pos = pos > 0 ? pos-1 : pos;
                }
                else if(c == '>'){
                    pos = pos < password.size() ? pos+1 : pos;
                }
                else if(c == '-'){
                    if(pos > 0) password.remove(--pos);
                }
                else{
                    password.add(pos++, c);
                }
            }

            StringBuilder sb = new StringBuilder();
            for(char c : password){
                sb.append(c);
            }
            System.out.println(sb);

        }
        br.close();
    }
}
