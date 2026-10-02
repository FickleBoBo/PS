# 🔍 ACM Craft (실패)
- 설계 시간 : 1+1min
- 구현 시간 : 35+76min
- 난이도 : 골드 3
- 알고리즘 : 위상 정렬 / DP
- 코드 길이 : B
- 실행 시간 : ms(제한 1초)
- 메모리 : KB

------------------------------

# 💡 아이디어

1. 그림 딱 보니까 위상 정렬 같은데?
   - 근데 위상 정렬로 하면 하나씩 정렬하면서 더해주면 값이 모든 노드의 합이 될거 같다 -> 위상 정렬이 아닌가?
2. 그럼 BFS로 완탐이 되나?
   - 이거도 위상 정렬이랑 논리 자체는 딱히 다른게 없어보임
3. 그럼 DFS로 완탐을 돌려보자?
    - 정답에 대한 출발 노드를 알 수가 없어서 지어야 하는 건물부터 거슬러 찾아야 함
    - 답은 맞는거 같은데 4%에서 시간초과남
4. 출발 노드를 알려면 유니온파인드 해줘서 선행 작업 노드만 찾을까?
    - 패스 컴프레션하면 연결관계가 바뀌어서 안됨
5. DP로 하라는데 모르겠음 포기

------------------------------

# 🧠 어려웠던 점

- 그냥 손도 못대겠음

------------------------------

# 🧐 좋은 풀이

1. 일단 접근 자체는 위상 정렬에 DP가 섞인 느낌으로 가져감
2. 위상 정렬에서 노드의 선후관계는 유지하면서 가져가는데 여기에 소요시간을 배열로 저장해줘야함
3. 핵심 로직은 저 건물의 기본 소요시간을 구하는 공식인데 저게 왜 됨?
```java
// https://bcp0109.tistory.com/24

// indegree는 진입차수
// List<List<Integer>> list 이거는 인접리스트
// w는 지어야 하는 목표 건물
static void topologicalSort(int[] indegree, List<List<Integer>> list, int w) {
    Queue<Integer> q = new LinkedList<Integer>();
    int[] result = new int[n+1];    // result 배열에 소요시간 저장

    // 건물의 소요 기본 소요시간은 d[i]
    // 기본 요소 시간은 그 건물 짓는 시간(입력으로 주어짐)
    for(int i=1; i<=n; i++) {
        result[i] = d[i];

        if(indegree[i] == 0)    // 위상 정렬 준비
            q.offer(i);
    }

    // 건물의 총 소요시간 = 이전까지의 소요시간 + 현재 건물 소요시간
    // Max 해주는 이유는 이전 테크가 다 올라야 현재 건물을 지을 수 있기 때문
    while(!q.isEmpty()) {
        int node = q.poll();

        for(Integer i : list.get(node)) {
            result[i] = Math.max(result[i], result[node] + d[i]);    // 여기가 DP인듯?
            indegree[i]--;

            if(indegree[i] == 0)
                q.offer(i);
        }
    }

    System.out.println(result[w]);
}
```