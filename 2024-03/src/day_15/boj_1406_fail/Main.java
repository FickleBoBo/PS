package day_15.BOJ_S2_1406_Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Character> list = new LinkedList<>();

        String input = br.readLine();

        for(int i=0 ; i<input.length() ; i++){
            list.add(input.charAt(i));
        }

        int pos = list.size();

//        System.out.println("초기 pos : " + pos);

        int N = Integer.parseInt(br.readLine());

        for(int i=0 ; i<N ; i++){
            char[] order = br.readLine().toCharArray();
            if(order.length > 1){
                list.add(pos++, order[2]);

//                System.out.println("pos : " + pos);
//                for(char c : list){
//                    System.out.print(c);
//                }
//                System.out.println("\n");

            }
            else{
                if(order[0]=='L'){
                    pos = pos > 0 ? pos-1 : pos;

//                    System.out.println("pos : " + pos);
//                    for(char c : list){
//                        System.out.print(c);
//                    }
//                    System.out.println("\n");

                }
                else if(order[0]=='D'){
                    pos = pos < list.size() ? pos+1 : pos;

//                    System.out.println("pos : " + pos);
//                    for(char c : list){
//                        System.out.print(c);
//                    }
//                    System.out.println("\n");

                }
                else if(order[0]=='B'){
                    if(pos > 0) list.remove(--pos);

//                    System.out.println("pos : " + pos);
//                    for(char c : list){
//                        System.out.print(c);
//                    }
//                    System.out.println("\n");

                }
            }
        }

//        System.out.println("pos : " + pos);
        for(char c : list){
            sb.append(c);
        }

        System.out.println(sb);
//        System.out.println("\n");

        br.close();
    }
}
