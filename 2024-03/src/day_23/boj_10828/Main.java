package day_23.BOJ_S4_10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i=0 ; i<N ; i++){
            sb.append(br.readLine() + " ");
        }
        StringTokenizer st = new StringTokenizer(sb.toString(), " ");

        MyStack stack = new MyStack();

        while(st.hasMoreTokens()){
            String order = st.nextToken();
            if(order.equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
            }
            else if(order.equals("pop")){
                System.out.println(stack.pop());
            }
            else if(order.equals("size")){
                System.out.println(stack.size());
            }
            else if(order.equals("empty")){
                System.out.println(stack.empty());
            }
            else{
                System.out.println(stack.top());
            }

        }

    }

}

class MyStack{
   List<Integer> list = new ArrayList<>();

    void push(int item){
        list.add(item);
    }

    int pop(){
        if(list.isEmpty()) return -1;
        int item = list.get(list.size()-1);
        list.remove(list.size()-1);
        return item;
    }

    int size(){
        return list.size();
    }

    int empty(){
        if(list.isEmpty()) return 1;
        else return 0;
    }

    int top(){
        if(list.isEmpty()) return -1;
        return list.get(list.size()-1);
    }
}
