package day_10.BOJ_G3_2252_Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<M ; i++){
            sb.append(br.readLine() + " ");
        }

        StringTokenizer st = new StringTokenizer(sb.toString(), " ");

        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[1+N];

        while(st.hasMoreTokens()){
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(!visited[A] && !visited[B]){
                list.add(A);
                list.add(B);
                visited[A] = true;
                visited[B] = true;
            }
            else if(!visited[B]){
                for(int i=0 ; i<list.size() ; i++){
                    if(list.get(i)==A){
                        list.add(i+1, B);
                        visited[B] = true;
                        break;
                    }
                }
            }
            else if(!visited[A]){
                for(int i=0 ; i<list.size() ; i++){
                    if(list.get(i)==B){
                        list.add(i, A);
                        visited[A] = true;
                        break;
                    }
                }
            }
            else{
                int idx = 0;
                for(int i=0 ; i<list.size() ; i++){
                    if(list.get(i)==A) idx = i;
                    else if(list.get(i)==B) list.add(idx, A);
                }
            }

//            System.out.println(list.size());
//            for(int n : list){
//                System.out.print(n + " ");
//            }
//            System.out.println();
        }

        for(int n : list){
            System.out.print(n + " ");
        }
        System.out.println();

    }
}
