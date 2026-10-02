package day_28.BOJ_G3_21276_Fail;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<String> names = new ArrayList<>();
        for(int i=0 ; i<N ; i++){
            names.add(sc.next());
        }
        Collections.sort(names);

        int M = sc.nextInt();
        List<String>[] adj = new ArrayList[N];
        int[] degree = new int[N];
        for(int i=0 ; i<N ; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0 ; i<M ; i++){
            String x = sc.next();
            String y = sc.next();
            int xIndex = names.indexOf(x);
            int yIndex = names.indexOf(y);
            adj[yIndex].add(x);
            degree[xIndex]++;
        }

        for(List<String> list : adj){
            Collections.sort(list);
        }

        int K = 0;
        List<String> KList = new ArrayList<>();

        for(int i=0 ; i<N ; i++){
            if(degree[i] == 0){
                K++;
                KList.add(names.get(i));
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(K + "\n");
        for(String name : KList){
            sb.append(name + " ");
        }
        sb.append("\n");

        for(int i=0 ; i<N ; i++){
            int cnt = adj[i].size();

            int len = adj[i].size();
            for(int j=0 ; j<len ; j++){
                String name = adj[i].get(j);
                if(degree[i] != degree[names.indexOf(name)]-1){
                    adj[i].remove(name);
                    j--;
                    len--;
                    cnt--;
                }
            }

            sb.append(names.get(i) + " ");
            sb.append(cnt + " ");
            for(String name : adj[i]){
                sb.append(name + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());

    }
}
