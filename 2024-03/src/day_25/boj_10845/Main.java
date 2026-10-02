package day_25.BOJ_S4_10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<N ; i++){
            sb.append(br.readLine() + " ");
        }

        StringTokenizer st = new StringTokenizer(sb.toString(), " ");

        while(st.hasMoreTokens()){
            String str = st.nextToken();

            if(str.equals("push")){
                push(Integer.parseInt(st.nextToken()));
            }
            else if(str.equals("pop")){
                pop();
            }
            else if(str.equals("size")){
                size();
            }
            else if(str.equals("empty")){
                empty();
            }
            else if(str.equals("front")){
                front();
            }
            else{
                back();
            }

        }

        br.close();
    }

    private static List<Integer> queue = new LinkedList<>();

    private static void push(int item){
        queue.add(item);
    }

    private static void pop(){
        if(queue.isEmpty()){
            System.out.println(-1);
            return;
        }
        int item = queue.get(0);
        queue.remove(0);
        System.out.println(item);
    }

    private static void size(){
        System.out.println(queue.size());
    }

    private static void empty(){
        if(queue.isEmpty()){
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }

    private static void front(){
        if(queue.isEmpty()){
            System.out.println(-1);
            return;
        }
        System.out.println(queue.get(0));
    }

    private static void back(){
        if(queue.isEmpty()){
            System.out.println(-1);
            return;
        }
        System.out.println(queue.get(queue.size()-1));
    }

}
