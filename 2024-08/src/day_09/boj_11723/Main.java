package day_09.BOJ_S5_11723;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            if(order.equals("add")){
                set.add(Integer.parseInt(st.nextToken()));
            }
            else if(order.equals("remove")){
                set.remove(Integer.parseInt(st.nextToken()));
            }
            else if(order.equals("check")){
                if(set.contains(Integer.parseInt(st.nextToken()))){
                    sb.append("1\n");
                }
                else{
                    sb.append("0\n");
                }
            }
            else if(order.equals("toggle")){
                int x = Integer.parseInt(st.nextToken());

                if(set.contains(x)) set.remove(x);
                else set.add(x);
            }
            else if(order.equals("all")){
                set = new HashSet<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
            }
            else if(order.equals("empty")){
                set.clear();
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
