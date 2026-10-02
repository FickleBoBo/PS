package day_08.BOJ_G3_17471;

import java.util.*;

public class Main {

    static int[] value;
    static int[][] adj;
    static int N;
    static int R;
    static int[] sel;
    static int ans;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        value = new int[1+N];
        for(int i=1 ; i<=N ; i++){
            value[i] = sc.nextInt();
        }

        adj = new int[1+N][1+N];
        for(int i=1 ; i<=N ; i++){
            int k = sc.nextInt();
            for(int j=0 ; j<k ; j++){
                int next = sc.nextInt();
                adj[i][next] = adj[next][i] = 1;
            }
        }

        ans = -1;
        for(int i=1 ; i<N ; i++){
            R = i;
            sel = new int[R];
            powerSet(0, 0);
        }

        System.out.println(ans);

        sc.close();
    }

    private static void powerSet(int idx, int sidx){
        if(sidx == R){
            List<Integer> list1 = new ArrayList<>();
            for(int i=0 ; i<R ; i++){
                list1.add(sel[i]);
            }

            List<Integer> list2 = new ArrayList<>();
            for(int i=0 ; i<N ; i++){
                if(!list1.contains(i+1)){
                    list2.add(i+1);
                }
            }

            BFS(list1, list2);
            return;
        }

        for(int i=idx ; i<N ; i++){
            sel[sidx] = i + 1;
            powerSet(i + 1, sidx + 1);
        }

    }

    private static void BFS(List<Integer> list1, List<Integer> list2){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited1 = new boolean[1+N];
        q.offer(list1.get(0));
        visited1[list1.get(0)] = true;

        while(!q.isEmpty()){
            int item = q.poll();
            for(int i=1 ; i<=N ; i++){
                if(adj[item][i]==1 && !visited1[i] && list1.contains(i)){
                    q.offer(i);
                    visited1[i] = true;
                }
            }
        }

        for(int i=0 ; i<list1.size() ; i++){
            if(!visited1[list1.get(i)]) return;
        }

        boolean[] visited2 = new boolean[1+N];
        q.offer(list2.get(0));
        visited2[list2.get(0)] = true;

        while(!q.isEmpty()){
            int item = q.poll();
            for(int i=1 ; i<=N ; i++){
                if(adj[item][i]==1 && !visited2[i] && list2.contains(i)){
                    q.offer(i);
                    visited2[i] = true;
                }
            }
        }

        for(int i=0 ; i<list2.size() ; i++){
            if(!visited2[list2.get(i)]) return;
        }

        int sum1 = 0;
        int sum2 = 0;
        for(int i=0 ; i<list1.size() ; i++){
            sum1 += value[list1.get(i)];
        }
        for(int i=0 ; i<list2.size() ; i++){
            sum2 += value[list2.get(i)];
        }
        if(ans >= 0){
            ans = Math.min(ans, Math.abs(sum1 - sum2));
        }
        else{
            ans = Math.abs(sum1 - sum2);
        }

    }

}
