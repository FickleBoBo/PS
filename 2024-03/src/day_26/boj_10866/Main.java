package day_26.BOJ_S4_10866;

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
            String order = st.nextToken();

            if(order.equals("push_front")){
                push_front(Integer.parseInt(st.nextToken()));
            }
            else if(order.equals("push_back")){
                push_back(Integer.parseInt(st.nextToken()));
            }
            else if(order.equals("pop_front")){
                pop_front();
            }
            else if(order.equals("pop_back")){
                pop_back();
            }
            else if(order.equals("size")){
                size();
            }
            else if(order.equals("empty")){
                empty();
            }
            else if(order.equals("front")){
                front();
            }
            else if(order.equals("back")){
                back();
            }
        }

    }

    private static List<Integer> deque = new LinkedList<>();

    private static void push_front(int item) {
        deque.add(0, item);
    }

    private static void push_back(int item) {
        deque.add(item);
    }

    private static void pop_front() {
        if(deque.isEmpty()){
            System.out.println(-1);
            return;
        }
        int item = deque.get(0);
        deque.remove(0);
        System.out.println(item);
    }

    private static void pop_back() {
        if(deque.isEmpty()){
            System.out.println(-1);
            return;
        }
        int item = deque.get(deque.size()-1);
        deque.remove(deque.size()-1);
        System.out.println(item);
    }

    private static void size() {
        System.out.println(deque.size());
    }

    private static void empty() {
        if(deque.isEmpty()){
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }

    private static void front() {
        if(deque.isEmpty()){
            System.out.println(-1);
            return;
        }
        System.out.println(deque.get(0));
    }

    private static void back() {
        if(deque.isEmpty()){
            System.out.println(-1);
            return;
        }
        System.out.println(deque.get(deque.size()-1));
    }

}
