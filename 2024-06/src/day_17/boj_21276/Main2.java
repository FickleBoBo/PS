package day_17.BOJ_G3_21276;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 자식들을 저장하는 Map (key: 이름, value: 자식들)
        Map<String, PriorityQueue<String>> childMap = new HashMap<>();
        // 자손들을 저장하는 Map (key: 이름, value: 자손들)
        Map<String, List<String>> descendantMap = new HashMap<>();
        // 진입차수를 저장하는 Map (key: 이름, value: 진입차수)
        Map<String, Integer> indegree = new HashMap<>();

        // step1 - 입력 받아서 세팅
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++){
            String name = st.nextToken();

            childMap.put(name, new PriorityQueue<>());
            descendantMap.put(name, new ArrayList<>());
            indegree.put(name, 0);
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            String descendant = st.nextToken();
            String name = st.nextToken();

            descendantMap.get(name).add(descendant);    // 자손 추가
            indegree.put(descendant, indegree.get(descendant) + 1);    // 진입차수 갱신
        }

        // 이름을 사전순 대로 출력
        PriorityQueue<String> ans = new PriorityQueue<>();

        // step2 - 위상 정렬 시작
        Queue<String> q = new ArrayDeque<>();    // LinkedList랑 별 차이 없네...
        for(String name : indegree.keySet()){
            if(indegree.get(name) == 0){
                q.offer(name);
                ans.offer(name);    // 초기 진입차수가 0이면 각 가문의 시조
            }
        }

        while(!q.isEmpty()){
            String name = q.poll();

            // 위상 정렬에서 뽑은 애의 자손들을 둘러보며
            for(String descendant : descendantMap.get(name)){

                // 자손들의 진입차수를 1 감소시킴
                indegree.put(descendant, indegree.get(descendant) - 1);

                // 진입차수가 0이 된 자손은 Queue에 넣고 자식에 추가
                // 위상 정렬에서 방금 0이 된게 부모, 자식 관계임
                // 자식과 자손을 구분하는 것이 포인트
                if(indegree.get(descendant) == 0){
                    q.offer(descendant);
                    childMap.get(name).offer(descendant);
                }
            }
        }

        // step3 - 출력 단계

        // 처음엔 가문의 시조와 관련된 정보 출력
        sb.append(ans.size()).append("\n");
        while(!ans.isEmpty()){
            sb.append(ans.poll()).append(" ");
        }
        sb.append("\n");

        // 다음엔 각 사람에 대해 자식을 출력(오름차순)
        for(String name : childMap.keySet()){
            ans.offer(name);
        }

        while(!ans.isEmpty()){
            String name = ans.poll();

            sb.append(name).append(" ").append(childMap.get(name).size()).append(" ");
            while(!childMap.get(name).isEmpty()){
                sb.append(childMap.get(name).poll()).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
