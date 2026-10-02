package day_13.BOJ_S5_1343;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), ".", true);

        boolean flag = true;
        while(st.hasMoreTokens()){
            String token = st.nextToken();

            if(token.equals(".")){
                sb.append(token);
            }
            else{
                if(token.length() % 2 == 1){
                    flag = false;
                    break;
                }
                else{
                    for(int i=0 ; i<token.length()/4 ; i++){
                        sb.append("AAAA");
                    }
                    for(int i=0 ; i<token.length()%4 ; i++){
                        sb.append("B");
                    }
                }
            }
        }

        if(flag){
            bw.write(sb.toString());
        }
        else{
            bw.write("-1");
        }
        bw.flush();
    }
}
