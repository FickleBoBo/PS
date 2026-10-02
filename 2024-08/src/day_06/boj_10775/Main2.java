package day_06.BOJ_G2_10775;

import java.io.*;

// 1. 비행기는 도킹할 수 있는 게이트 중 가장 번호가 큰 게이트에 도킹해야 최대한 많이 도킹할 수 있음
// 2. 부모 배열은 인덱스에 비행기 번호, 값에 해당 비행기가 도킹할 게이트 번호 저장(정확히는 그룹장일 때 이렇게 됨)
// 3. 도킹을 마치면 가리킬 다음 게이트는 도킹을 마친 게이트 바로 이전 게이트(부모만 갱신하지만 어차피 또 find() 안에 넣을거라 상관없음?)
public class Main2 {

    // 유니온 파인드 알고리즘의 부모 배열
    static int[] p;

    // find-set
    private static int find(int x){
        if(x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    // union-set
    private static void union(int x, int y){
        p[y] = x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        // make-set
        p = new int[1+G];
        for(int i=1 ; i<=G ; i++) p[i] = i;

        // 1 세 개 입력 들어오는게 71% 반례여서 도킹한 비행기 개수를 반복문 밖에서 세줬음(반복문 안에서 return 하는 방식이 안됐음)
        int ans = 0;

        for(int i=0 ; i<P ; i++){
            // n : 비행기 번호
            int n = Integer.parseInt(br.readLine());

            // 도킹 가능한 게이트 없으면 종료
            if(find(n) == 0) break;

            // 도킹 가능한 게이트를 한칸 이동
            union(find(n) - 1, find(n));    // union(find(n - 1), find(n)); 이렇게 하면 안되는데 같은 번호의 비행기가 연달아 나오면 갱신이 전혀 안됨
            ans++;
        }

        System.out.println(ans);
    }
}
