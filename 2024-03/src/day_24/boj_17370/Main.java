package day_24.BOJ_G3_17370;

import java.util.*;

public class Main {

    static int N;                  // 주어진 개미의 이동 횟수
    static boolean[][] visited;    // 개미가 방문한 좌표에 대한 방문 체크
    // 개미의 이동을 나타내는 델타배열
    static int[] dx = {0, 0, 1, -1, -1, 1};     // 상 하 우상 좌하 좌상 우하
    static int[] dy = {1, -1, 1, -1, 1, -1};    // 상 하 우상 좌하 좌상 우하
    static int ans = 0;                         // 출력할 정답
//    static Stack<int []> coorStack = new Stack<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[2*N+1][3*N+1];    // 개미의 이동을 고려해서 잡아줌

        DFS(N, N, 0, -1);    // DFS로 푸는데 배열은 음의 인덱스가 없으므로 가운데로 이동시켜줌

        System.out.println(ans/2);    // 같은 경로가 두 번 세지는 이슈가 있다
        sc.close();
    }

    private static void DFS(int x, int y, int dir, int depth){
        // 종료 조건
        if(visited[x][y]){
            if(depth == N) ans++;

//            System.out.println("----------정답 수 : "+ans);
//            List<int[]> list = new ArrayList<>();
//            int len = coorStack.size();
//            System.out.println("----------스택 길이 : " + len);
//            for(int i=0 ; i<len ; i++){
//                list.addFirst(coorStack.pop());
//            }
//            for(int[] arr : list){
//                System.out.print(Arrays.toString(arr));
//            }
//            for(int i=0 ; i<len ; i++){
//                coorStack.push(list.removeFirst());
//            }
//            System.out.println();

            return;    // 방문한 곳을 만나면 무조건 탐색은 끝나는 백트래킹?
        }
        if(depth == N) return;    // 다 갔는데 탐색을 못멈주면 종료

//        System.out.println((x-N)+" "+(y-N) + " " + (depth+1));

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if(dir == 0){
            visited[x][y] = true;
//            coorStack.push(new int[]{x-N, y-N , depth+1});
            DFS(nx, ny, 2, depth+1);
            visited[x][y] = false;
//            coorStack.pop();
            visited[x][y] = true;
//            coorStack.push(new int[]{x-N, y-N , depth+1});
            DFS(nx, ny, 4, depth+1);
            visited[x][y] = false;
//            coorStack.pop();
        }
        else if(dir == 1){
            visited[x][y] = true;
//            coorStack.push(new int[]{x-N, y-N , depth+1});
            DFS(nx, ny, 3, depth+1);
            visited[x][y] = false;
//            coorStack.pop();
            visited[x][y] = true;
//            coorStack.push(new int[]{x-N, y-N , depth+1});
            DFS(nx, ny, 5, depth+1);
            visited[x][y] = false;
//            coorStack.pop();
        }
        else if(dir == 2){
            visited[x][y] = true;
//            coorStack.push(new int[]{x-N, y-N , depth+1});
            DFS(nx, ny, 0, depth+1);
            visited[x][y] = false;
//            coorStack.pop();
            visited[x][y] = true;
//            coorStack.push(new int[]{x-N, y-N , depth+1});
            DFS(nx, ny, 5, depth+1);
            visited[x][y] = false;
//            coorStack.pop();
        }
        else if(dir == 3){
            visited[x][y] = true;
//            coorStack.push(new int[]{x-N, y-N , depth+1});
            DFS(nx, ny, 1, depth+1);
            visited[x][y] = false;
//            coorStack.pop();
            visited[x][y] = true;
//            coorStack.push(new int[]{x-N, y-N , depth+1});
            DFS(nx, ny, 4, depth+1);
            visited[x][y] = false;
//            coorStack.pop();
        }
        else if(dir == 4){
            visited[x][y] = true;
//            coorStack.push(new int[]{x-N, y-N , depth+1});
            DFS(nx, ny, 0, depth+1);
            visited[x][y] = false;
//            coorStack.pop();
            visited[x][y] = true;
//            coorStack.push(new int[]{x-N, y-N , depth+1});
            DFS(nx, ny, 3, depth+1);
            visited[x][y] = false;
//            coorStack.pop();
        }
        else if(dir == 5){
            visited[x][y] = true;
//            coorStack.push(new int[]{x-N, y-N , depth+1});
            DFS(nx, ny, 1, depth+1);
            visited[x][y] = false;
//            coorStack.pop();
            visited[x][y] = true;
//            coorStack.push(new int[]{x-N, y-N , depth+1});
            DFS(nx, ny, 2, depth+1);
            visited[x][y] = false;
//            coorStack.pop();
        }



    }

}
