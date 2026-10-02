package day_10.BOJ_G4_1976;

import java.io.*;
import java.util.*;

public class Main {

    // 유니온 파인드 알고리즘 준비
    static int[] p;

    // 경로 단축 처리
    private static int find(int x){
        if(x == p[x]) return p[x];
        return p[x] = find(p[x]);
    }

    private static void union(int x, int y){
        p[y] = x;
    }

    public static void main(String[] args) throws IOException {

        // step1 - 입력 받아서 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 간선 배열로 연결관계 저장
        List<int[]> edges = new LinkedList<>();

        // 도시 번호가 1번부터라 반복문도 1부터 돌려줌
        for(int i=1 ; i<=N ; i++){
            st = new StringTokenizer(br.readLine());    // 토큰은 공백으로 잘려있음
            for(int j=1 ; j<=N ; j++){
                if(st.nextToken().equals("1")){
                    edges.add(new int[]{i, j});    // 그냥 양방향이라고 (내가) 생각하면 됨
                }
            }
        }

        // step2 - 유니온 파인드 수행
        p = new int[1+N];
        for(int i=1 ; i<=N ; i++){
            p[i] = i;
        }

        for(int[] e : edges){
            union(find(e[0]), find(e[1]));
        }

        // step3 - M개의 도시가 모두 연결되었는지 판단
        // 아마 하나하나 꺼낸애들도 find를 한번 더 넣어야 됨
        // 경로 단축해도 완벽하게 스타형? 연결이 아니어서 그럴듯 (아님 말고)
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
