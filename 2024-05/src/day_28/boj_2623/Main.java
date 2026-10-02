package day_28.BOJ_G3_2623;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List[] adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<Integer>();
        }

        int[] degree = new int[1+N];

        for(int i=0 ; i<M ; i++){
            int n = sc.nextInt();
            int num1 = sc.nextInt();
            for(int j=0 ; j<n-1 ; j++){
                int num2 = sc.nextInt();
                if(!adj[num2].contains(num1)){
                    adj[num2].add(num1);
                    degree[num2]++;
                }
                num1 = num2;
            }
        }

//        for(List list : adj){
//            System.out.println(list);
//        }

        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> ans = new LinkedList<>();
        boolean[] visited = new boolean[1+N];

//        System.out.println(Arrays.toString(degree));
        while(true){
            for(int i=1 ; i<=N ; i++){
                if(!visited[i] && degree[i] == 0){
                    q.offer(i);
                    ans.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }

            if(q.isEmpty()) break;
            int item = q.poll();
//            System.out.println(item);
//            System.out.println(Arrays.toString(degree));

            for(int i=1 ; i<=N ; i++){
                if(adj[i].contains(item)){
                    degree[i]--;
                }
            }
        }

        if(cnt == N){
            while(!ans.isEmpty()){
                System.out.println(ans.poll());
            }
        }
        else{
            System.out.println(0);
        }

    }
}
