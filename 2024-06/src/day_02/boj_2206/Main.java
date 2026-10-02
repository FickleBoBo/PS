package day_02.BOJ_G3_2206;

import java.io.*;
import java.util.*;

public class Main {

    // 상우하좌 델타배열
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int N, M;        // N, M : map의 높이와 너비
    static char[][] map;    // map : 입력으로 주어지는 N x M 크기의 맵

    // BFS에 사용할 각각의 노드 클래스
    static class Node {
        int r, c;             // r, c : map에서의 (세로, 가로) 위치
        boolean breakWall;    // breakWall : 해당 노드가 벽을 부순적이 있는지 체크하는 변수

        public Node(int r, int c, boolean breakWall) {
            this.r = r; this.c = c; this.breakWall = breakWall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    // delim에 아무것도 안 넣으면 공백이 구분자

        // step1 - 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i=0 ; i<N ; i++){
            map[i] = br.readLine().toCharArray();
        }

        // step2 - BFS 돌리기
        System.out.println(BFS());
    }

    // 최단 거리를 바로 반환
    private static int BFS(){
        // BFS에서 사용할 Queue
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, false));    // 시작점이 (1, 1)로 고정 + 벽이 항상 없음

        // BFS에서 사용할 방문 체크 배열(2차원 boolean 배열로는 문제 해결 불가능, 3차원 boolean배열 풀이가 더 많았음)
        // 도착점에 갈 수 있으면 visited[N-1][M-1] 이 0이 아니어야 함을 이용해서 도착 여부 판단
        // 0 : 아직 방문한 적이 없음
        // 1 : 벽을 부순적이 없는 상태에서 방문 했었음
        // 2 : 벽을 부순적이 있는 상태에서 방문 했었음
        int[][] visited = new int[N][M];
        visited[0][0] = 1;    // 시작점 방문 체크

        // 최단 거리
        int ans = 1;

        // 시작점과 도착점이 동일할 때 출력이 잘 안됐는데, 한번에 만들기 어려워서 그냥 예외처리 한번 해줌(90% 대에서 테케 있음)
        if(visited[N-1][M-1] != 0) return ans;

        while(!q.isEmpty()){
            // BFS 최단 거리 유형이라서 현재 Queue의 크기만큼만 수행하도록 len 설정
            int len = q.size();

            for(int i=0 ; i<len ; i++){

                // Queue에서 뽑은 각각의 Node에 대한 사방탐색
                Node item = q.poll();
                for(int dir=0 ; dir<4 ; dir++){
                    int nr = item.r + dr[dir];
                    int nc = item.c + dc[dir];

                    // 새로운 Node 후보가 map 안에 있을 경우
                    if(nr>=0 && nr<N && nc>=0 && nc<M){

                        // 새로운 좌표가 이동할 수 있는 곳일 경우
                        if(map[nr][nc] == '0'){
                            // 처음 방문할 경우
                            if(visited[nr][nc] == 0){
                                // 현재 벽을 부순적이 있음
                                if(item.breakWall){
                                    q.offer(new Node(nr, nc, true));
                                    visited[nr][nc] = 2;
                                }
                                // 아직 벽을 부순적이 없음
                                else{
                                    q.offer(new Node(nr, nc, false));
                                    visited[nr][nc] = 1;
                                }
                            }
                            // 벽을 부순적 없이 방문했었을 경우
                            else if(visited[nr][nc] == 1){
                                // 현재 벽을 부순적이 있음
                                continue;
                            }
                            // 벽을 부순적 있이 방문했었을 경우
                            else{
                                // 현재 벽을 부순적이 있음
                                if(item.breakWall){
                                    continue;
                                }
                                // 아직 벽을 부순적이 없음
                                else{
                                    q.offer(new Node(nr, nc, false));
                                    visited[nr][nc] = 1;
                                }
                            }
                        }
                        // 새로운 좌표가 벽일 경우
                        else{
                            // 처음 방문할 경우
                            if(visited[nr][nc] == 0){
                                // 현재 벽을 부순적이 있음
                                if(item.breakWall){
                                    continue;
                                }
                                // 아직 벽을 부순적이 없음
                                else{
                                    q.offer(new Node(nr, nc, true));
                                    visited[nr][nc] = 2;
                                }
                            }
                            // 벽을 부순적 없이 방문했었을 경우
                            else if(visited[nr][nc] == 1){
                                continue;
                            }
                            // 벽을 부순적 있이 방문했었을 경우
                            else{
                                continue;
                            }
                        }

                    }
                }
            }

            // Queue의 크기만큼 돌았으면 최단 거리 + 1
            ans++;
            // 도착점을 방문했으면 종료
            if(visited[N-1][M-1] != 0) return ans;
        }

        // 도착점을 방문하지 못했으면 -1 리턴
        return -1;
    }

}
