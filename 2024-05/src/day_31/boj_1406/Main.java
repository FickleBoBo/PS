package day_31.BOJ_S2_1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");

        Stack<String> st1 = new Stack<>();
        Stack<String> st2 = new Stack<>();
        for(String str : input){
            st1.push(str);
        }

        int M = Integer.parseInt(br.readLine());

        for(int i=0 ; i<M ; i++){
            String order = br.readLine();

            if(order.equals("L")){
                if(!st1.isEmpty()){
                    st2.push(st1.pop());
                }
            }
            else if(order.equals("D")){
                if(!st2.isEmpty()){
                    st1.push(st2.pop());
                }
            }
            else if(order.equals("B")){
                if(!st1.isEmpty()){
                    st1.pop();
                }
            }
            else{
                st1.push(order.substring(2, 3));
            }
        }

        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!st2.isEmpty()){
            sb.append(st2.pop());
        }
        System.out.println(sb.toString());


    }
}
