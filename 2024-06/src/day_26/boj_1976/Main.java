package day_26.BOJ_G4_1976;

import java.io.*;
import java.util.*;

public class Main {

    // 유니온 파인드 부모 배열
    static int[] p;

    // find-set (경로 단축)
    private static int find(int x){
        if(x == p[x]) return p[x];
        return p[x] = find(p[x]);
    }

    // union-set
    private static void union(int x, int y){
        p[y] = x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        p = new int[1+N];

        // make-set
        for(int i=1 ; i<=N ; i++){
            p[i] = i;
        }

        for(int i=1 ; i<=N ; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=1 ; j<=N ; j++){
                if(st.nextToken().equals("1")){
                    union(find(i), find(j));
                }
            }
        }

        boolean flag = true;    // 모두 연결되었을 때만 true

        st = new StringTokenizer(br.readLine());
        int root = find(Integer.parseInt(st.nextToken()));    // 일단 하나 꺼내서 최고 조상 확인

        while(st.hasMoreTokens()){
            if(root != find(Integer.parseInt(st.nextToken()))){    // 나머지 애들의 최고 조상이 처음 꺼낸거와 일치하는지 확인
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }
}
