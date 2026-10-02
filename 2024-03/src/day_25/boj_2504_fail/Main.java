package day_25.BOJ_G5_2504_Fail;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] input = sc.next().split("");

        Stack<String> investigate = new Stack<>();
        Stack<String> st = new Stack<>();
        boolean incorrect = false;

        for(int i=0 ; i<input.length ; i++){
            if(input[i].equals("(") || (input[i].equals("["))) {
                investigate.push(input[i]);
            }
            else if(input[i].equals(")")){
                if(!investigate.isEmpty() && investigate.peek().equals("(")){
                    investigate.pop();
                }
                else{
                    incorrect = true;
                    break;
                }
            }
            else if(input[i].equals("]")){
                if(!investigate.isEmpty() && investigate.peek().equals("[")){
                    investigate.pop();
                }
                else{
                    incorrect = true;
                    break;
                }
            }
        }



//        if(incorrect) System.out.println(0);
//        else {
//            while(st.size() != 1){
//
//            }
//        }

        sc.close();
    }
}
