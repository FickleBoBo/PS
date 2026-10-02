package day_29.BOJ_G3_21276_Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String> names = new ArrayList<>();
        while(st.hasMoreTokens()){
            names.add(st.nextToken());
        }
        Collections.sort(names);

        int M = Integer.parseInt(br.readLine());
        List<String>[] adj = new ArrayList[N];
        for(int i=0 ; i<N ; i++){
            adj[i] = new ArrayList<>();
        }
        int[] degree = new int[N];

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            String descendant = st.nextToken();
            String anscestor = st.nextToken();
            adj[names.indexOf(anscestor)].add(descendant);
            degree[names.indexOf(descendant)]++;
        }

        for(int i=0 ; i<N ; i++){
            Collections.sort(adj[i]);
            for(int j=0 ; j<adj[i].size() ; i++){
                String name = adj[i].get(j);
                int idx = names.indexOf(name);
                if(degree[idx] > 1){
                    adj[i].remove(name);
                    degree[idx]--;
                }
            }
        }

//        List<String>[] ans = new ArrayList[N];
//        for(int i=0 ; i<N ; i++){
//            ans[i] = new ArrayList<>();
//        }

        List<String> Karr = new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        for(int i=0 ; i<N ; i++){
            if(degree[i] == 0){
                q.offer(names.get(i));
                Karr.add(names.get(i));
            }
        }

//        while(!q.isEmpty()){
//            String name = q.poll();
//            System.out.println(name);
//
//            for(int i=0 ; i<adj[names.indexOf(name)].size() ; i++){
//                String next = adj[names.indexOf(name)].get(i);
//                degree[names.indexOf(next)]--;
//                if(degree[names.indexOf(next)] == 0){
//                    q.offer(next);
//                    ans[names.indexOf(name)].add(next);
//                }
//                else{
//                    adj[names.indexOf(name)].remove(next);
//                    i--;
//                }
//            }
//        }

        StringBuilder sb = new StringBuilder();

        sb.append(Karr.size() + "\n");
//        System.out.println(Karr.size());
        for(String name : Karr){
            sb.append(name + " ");
//            System.out.print(name + " ");
        }
        sb.append("\n");
//        System.out.println();
        for(int i=0 ; i<N ; i++){
            sb.append(names.get(i) + " " + adj[i].size() + " ");
//            System.out.print(names.get(i) + " " + adj[i].size() + " ");
            for(String name : adj[i]){
                sb.append(name + " ");
//                System.out.print(name + " ");
            }
            sb.append("\n");
//            System.out.println();
        }

        System.out.print(sb.toString());

    }
}
