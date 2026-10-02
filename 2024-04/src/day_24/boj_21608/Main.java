package day_24.BOJ_G5_21608;

import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N;
    static int[][] map;

    public static void main(String[] args) {

        /* step1 - 입력값 세팅
         * 
         * N은 교실 한 변의 길이(정사각형)
         * map은 교실
         * data는 [학생번호, 친구1, 친구2, 친구3, 친구4]의 리스트
         */
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[1+N][1+N];    // 왼쪽 윗 칸이 (1, 1)이라 패딩

        List<Integer>[] data = new ArrayList[N*N];
        for(int i=0 ; i<N*N ; i++){
            data[i] = new ArrayList<>();
        }
        for(int i=0 ; i<N*N ; i++){
            for(int j=0 ; j<5 ; j++){
                data[i].add(sc.nextInt());
            }
        }

        // step2 - 각각의 학생을 교실에 순서대로 집어 넣음
        for(int i=0 ; i<N*N ; i++){
            find(data[i]);
        }

        /* step3 - 정답 찾음
        * 
        * 각각의 학생에 대해 주변 친구에 대한 가중치를 고려해 정답을 찾음
        * 교실을 순회하며 각 학생에 대한 사방탐색으로 찾는 방법 선택
        * 
        * ans는 최종 정답
        * tmp는 주변 친구 수
        * num은 교실에서 해당 학생에 대한 data의 정보(친구 목록)을 찾기 위한 임시 변수
        */
        int ans = 0;
        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=N ; j++){
                int tmp = 0;
                
                // 보기 불편한데 이거 말고는 못찾겠음
                int num = -1;
                for(int k=0 ; k<N*N ; k++){
                    if(data[k].get(0) == map[i][j]){    // data[]의 첫번째 원소가 학생 본인이고 나머지 원소가 친구들임
                        num = k;
                        break;
                    }
                }

                // 사방 탐색하며 친구 찾기
                for(int dir=0 ; dir<4 ; dir++){
                    int nr = i + dr[dir];
                    int nc = j + dc[dir];
                    if(nr>=1 && nr<=N && nc>=1 && nc<=N && data[num].contains(map[nr][nc])) {
                        tmp++;
                    }
                }
                
                // 친구 수에 대한 가중치 고려해서 정답에 반영
                if(tmp == 4) ans += 1000;
                else if(tmp == 3) ans += 100;
                else if(tmp == 2) ans += 10;
                else if(tmp == 1) ans += 1;
            }
        }

        System.out.println(ans);

        sc.close();
    }

    /* 학생이 들어갈 자리를 찾는 핵심 메서드
     * 
     * 교실을 순회하며 각 자리에 대한 정보를 posData에 저장함
     * posData = [주변친구수, 주변빈자리수, 행좌표, 열좌표, 본인번호]
     * 
     * posData에 대해 조건에 맞게 정렬함
     * - 조건 1 : 친구가 가장 많은 칸 (내림차순)
     * - 조건 2 : 빈 자리가 가장 많은 칸 (내림차순)
     * - 조건 3 : 행 번호가 작은 순서 (오름차순)
     * - 조건 4 : 열 번호가 작은 순서 (오름차순)
     */
    private static void find(List<Integer> data){
        int[][] posData = new int[N*N][5];

        // posData를 채워주는 반복문
        int idx = 0;
        for(int i=N ; i>=1 ; i--){
            for(int j=N ; j>=1 ; j--){
                if(map[i][j]==0){
                    int tmpEmptyCnt = 0;
                    int tmpFriendCnt = 0;
                    for(int dir=0 ; dir<4 ; dir++){
                        int nr = i + dr[dir];
                        int nc = j + dc[dir];
                        if(nr>=1 && nr<=N && nc>=1 && nc<=N){
                            if(data.contains(map[nr][nc])){
                                tmpFriendCnt++;
                            }
                            else if(map[nr][nc]==0){
                                tmpEmptyCnt++;
                            }
                        }
                    }
                    posData[idx][0] = tmpFriendCnt;
                    posData[idx][1] = tmpEmptyCnt;
                    posData[idx][2] = i;
                    posData[idx][3] = j;
                    posData[idx][4] = data.get(0);
                    idx++;
                }
            }
        }

        // 조건에 맞게 정렬 수행
        // if, else if로 하니까 정렬이 잘 안돼서 이렇게 함
        Arrays.sort(posData, (o1, o2) -> {
            if(o1[0] == o2[0]){
                if(o1[1] == o2[1]) {
                    if (o1[2] == o2[2]) {
                        return o1[3] - o2[3];
                    }
                    return o1[2] - o2[2];
                }
                return -(o1[1] - o2[1]);
            }
            return -(o1[0] - o2[0]);
        });

        /* 디버깅이 좀 걸린 파트
         * 
         * 원래 의도는 조건에 맞게 정렬을 수행하면 맨 첫번째 원소가 내가 원하는 값이라고 예상
         * 근데 내림차순으로 정렬한 단계에서는 잘 작동하는데 오름차순으로 정렬하는 단계에서
         * 내가 한 명을 배정할 때마다 posData의 1차원 배열 하나가 {0, 0, 0, 0, 0}이 됨(사람이 있는 자리는 바로 패스해서)
         * 이거 땜에 저 배열이 선택이 되어서 에러 발생
         * 불편하지만 저거인지 체크를 해줘야 해서 반복문이 하나 추가됨
         */
        for(int i=0 ; i<N*N ; i++){
            if(posData[i][2] != 0 && posData[i][3] != 0){
                if(map[posData[i][2]][posData[i][3]]==0){
                    map[posData[i][2]][posData[i][3]] = posData[i][4];
                    break;
                }
            }
        }
        
        // 막 구현해도 뚫려서 난이도 대비 정답률이 높은 듯

    }

}
