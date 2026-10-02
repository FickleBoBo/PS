package day_06.BOJ_G4_1043;

import java.io.*;
import java.util.*;

public class Main {

    // 유니온 파인드 알고리즘의 부모 배열
    static int[] p;

    // find-set
    private static int find(int x){
        if(x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    // union-set
    // 그룹에서 가장 작은 수가 그룹장이 되도록 해주는데 그룹장이 0이면 해당 그룹에는 과장된 이야기를 할 수 없다
    private static void union(int x, int y){
        if(x < y) p[y] = x;
        else p[x] = y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // make-set
        p = new int[1+N];
        for(int i=1 ; i<=N ; i++) p[i] = i;

        // 진실을 아는 사람은 부모(=그룹장)를 0으로 세팅
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        while(st.hasMoreTokens()){
            p[Integer.parseInt(st.nextToken())] = 0;
        }

        // 과장된 이야기를 할 수 있는 파티의 개수
        int ans = 0;

        // 각 파티에서 한 명씩만 담는데 그룹장이 진실을 아는지 여부가 중요한거라 굳이 파티원 전원에 대해 조사할 필요가 없다
        Queue<Integer> q = new ArrayDeque<>();

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            int root = Integer.parseInt(st.nextToken());
            q.offer(root);

            // 처음 뽑은 파티원과 나머지 파티원들을 비교하며 그룹장을 세팅해준다
            while(st.hasMoreTokens()){
                union(find(root), find(Integer.parseInt(st.nextToken())));
                // union(root, find(Integer.parseInt(st.nextToken()))); 이렇게 했다가 3%에서 틀렸는데 root의 부모가 바뀔 수 있으니 당연;;
            }
        }

        // 각 파티원에 대해 그룹장이 0이 아니면 과장된 이야기를 할 수 있다
        while(!q.isEmpty()){
            if(find(q.poll()) != 0){
                ans++;
            }
        }

        System.out.println(ans);
    }
}
