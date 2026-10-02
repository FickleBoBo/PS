package day_17.BOJ_G3_21276;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 진입 차수를 저장하는 Map (key: 이름, value: 진입차수)
        Map<String, Integer> indegree = new HashMap<>();
        // 자식들을 저장하는 Map (key: 이름, value: 자식들 우선순위큐)
        Map<String, PriorityQueue<String>> child = new HashMap<>();

        // 석호촌에 살고 있는 사람의 수
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        // 자손들을 저장하는 Map (key: 이름, value: 자손들 리스트)
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0 ; i<N ; i++){
            String name = st.nextToken();
            map.put(name, new ArrayList<>());
            indegree.put(name, 0);
            child.put(name, new PriorityQueue<>());
        }

        // 기억하는 정보의 개수
        int M = Integer.parseInt(br.readLine());
        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            String descendant = st.nextToken();
            String ancestor = st.nextToken();
            map.get(ancestor).add(descendant);
            indegree.put(descendant, indegree.get(descendant) + 1);
        }

        // 이름을 사전순 대로 출력
        PriorityQueue<String> ans = new PriorityQueue<>();

        // 위상 정렬 시작
        Queue<String> q = new ArrayDeque<>();
        for(String key : indegree.keySet()){
            if(indegree.get(key) == 0){
                q.offer(key);
                ans.offer(key);    // 초기 진입차수가 0이면 각 가문의 시조
            }
        }

        while(!q.isEmpty()){
            String name = q.poll();

            // 위상 정렬에서 뽑은 애의 자손들을 둘러보며
            for(String descendant : map.get(name)){

                // 자손들의 진입차수를 1 감소시킴
                indegree.put(descendant, indegree.get(descendant) - 1);

                // 진입차수가 0이 된 자손은 Queue에 넣고 자식에 추가
                // 자식과 자손을 구분하는 것이 포인트
                if(indegree.get(descendant) == 0){
                    q.offer(descendant);
                    child.get(name).offer(descendant);
                }
            }
        }

        // 출력 단계

        // 처음엔 가문의 시조와 관련된 정보 출력
        sb.append(ans.size()).append("\n");
        while(!ans.isEmpty()){
            sb.append(ans.poll()).append(" ");
        }
        sb.append("\n");

        // 다음엔 각 사람에 대해 자식을 출력
        for(String key : child.keySet()){
            ans.offer(key);
        }
        while(!ans.isEmpty()){
            String name = ans.poll();
            sb.append(name).append(" ").append(child.get(name).size()).append(" ");
            while(!child.get(name).isEmpty()){
                sb.append(child.get(name).poll()).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
