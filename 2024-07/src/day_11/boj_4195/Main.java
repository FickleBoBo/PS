package day_11.BOJ_G2_4195;

import java.io.*;
import java.util.*;

public class Main {

    // 예전에 어디 풀이에서 분리집합 클래스에 make-set, find-set, union-set 다 넣고 돌리던거 생각나서 해봄
     static class DisjointSet{

         // p는 사람을 넣으면 그룹장이 나오는 map
         // cnt는 사람을 넣으면 해당 그룹에 포함된 사람의 수가 나오는 map
         Map<String, String> p = new HashMap<>();
         Map<String, Integer> cnt = new HashMap<>();

         // 좀 헷갈렸는데 Map 버전으로 find 구현하려고 해본거
         public String find(String x){
            if(!p.get(x).equals(x)){
                // 이거 38% 메모리 초과땜에 오래걸렸는데 왜인지 잘 모르겠음
                // 어차피 map이라 덮어쓰기 되는데 왜 메모리 초과?
                // p.put(p.get(x), find(p.get(x)));
                p.put(x, find(p.get(x)));
            }
            return p.get(x);
        }

        // union에 make-set이 포함된 느낌인데 p에 안넣은 사람(=첨보는 사람)이면 초기화해줌
        public void union(String x, String y){
            p.putIfAbsent(x, x);
            p.putIfAbsent(y, y);

            String px = find(x);
            String py = find(y);

            // 그룹장이 같으면 cnt 갱신 안하고 넘어가야함
            if(px.equals(py)) return;

            // 간단하게 cnt 갱신해주는거
            cnt.put(px, cnt.getOrDefault(px, 1) + cnt.getOrDefault(py, 1));

            // 얘가 union
            p.put(py, px);
        }

        // 개수 뱉는 메서드
        public int count(String x){
            String px = find(x);
            return cnt.get(px);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            // 분리집합 객체 생성
            DisjointSet disjointSet = new DisjointSet();

            int F = Integer.parseInt(br.readLine());

            for(int i=0 ; i<F ; i++){
                st = new StringTokenizer(br.readLine());

                String f1 = st.nextToken();
                String f2 = st.nextToken();

                // f1, f2 넣어주면 알아서 다함
                disjointSet.union(f1, f2);

                sb.append(disjointSet.count(f1)).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
