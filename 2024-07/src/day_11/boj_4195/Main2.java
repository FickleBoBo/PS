package day_11.BOJ_G2_4195;

import java.io.*;
import java.util.*;

public class Main_fin {

    // 유니온 파인드 알고리즘 부모 배열
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // T : 테스트 케이스의 수
        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){

            // F : 친구 관계의 수
            int F = Integer.parseInt(br.readLine());

            // 각각의 친구 관계마다 두 명이 존재하므로 이론상 최대 F * 2 명까지 가능
            p = new int[F * 2];
            for(int i=0 ; i<p.length ; i++) p[i] = i;    // make-set

            // 친구 네트워크에 몇 명이 있는지 세는 카운팅 배열(=dp?)
            int[] cntArr = new int[F * 2];
            Arrays.fill(cntArr, 1);    // 친구 네트워크에 포함된 인원수에 자기 자신도 포함하므로 1로 초기화

            // 얘가 제일 중요한데 사람 이름을 정수로 바꾸는 기능
            // String 타입으로 유니온 파인드 돌리기 어려우니까 정수랑 매칭시켜주는 개념
            Map<String, Integer> map = new HashMap<>();
            int n = 0;

            for(int i=0 ; i<F ; i++){
                st = new StringTokenizer(br.readLine());

                String f1 = st.nextToken();
                String f2 = st.nextToken();

                // map에 안 넣은 이름이면 n으로 정수 부여
                if(!map.containsKey(f1)) map.put(f1, n++);
                if(!map.containsKey(f2)) map.put(f2, n++);

                // 이거 하려고 정수로 바꾼거
                int x = find(map.get(f1));
                int y = find(map.get(f2));

                // 이거 땜에 38%에서 틀렸는데 x랑 y의 그룹장이 같아도 출력을 해야해서 continue하면 안됨
                // if(x == y) continue;

                // x와 y의 그룹장이 다르면 cntArr 갱신하고 유니온 해줌
                // 유니온 먼저하면 그룹장이 같아진채로 더하는거니까 순서 중요!
                // 개수를 계속 x에만 더하는거라 가능한 논리인듯?
                if(x != y){
                    cntArr[x] += cntArr[y];
                    union(x, y);
                }

                sb.append(cntArr[x]).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
