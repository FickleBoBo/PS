package day_29.BOJ_G3_16235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Tree implements Comparable<Tree> {
        int x;
        int y;
        int z;
        boolean alive;

        public Tree(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.alive = true;
        }

        @Override
        public int compareTo(Tree o) {
            return Integer.compare(this.z, o.z);
        }
    }

    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

    static Deque<Tree> trees;
    static int N;
    static int[][] map;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i=0 ; i<N ; i++){
            Arrays.fill(map[i], 5);
        }

        A = new int[N][N];
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<N ; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Tree> tmp = new ArrayList<>();
        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            tmp.add(new Tree(x, y, z));
        }
        Collections.sort(tmp);
        trees = new LinkedList<>(tmp);

        for(int i=0 ; i<K ; i++){
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(trees.size());
    }

    private static void spring(){
        int len = trees.size();
        for(int i=0 ; i<len ; i++){
            Tree tree = trees.pollFirst();
            if(map[tree.x][tree.y] >= tree.z){
                map[tree.x][tree.y] -= tree.z;
                tree.z += 1;
            }
            else{
                tree.alive = false;
            }
            trees.addLast(tree);
        }
    }

    private static void summer(){
        int len = trees.size();
        for(int i=0 ; i<len ; i++){
            Tree tree = trees.pollFirst();
            if(!tree.alive){
                map[tree.x][tree.y] += tree.z/2;
            }
            else{
                trees.addLast(tree);
            }
        }
    }

    private static void fall(){
        Queue<Tree> tmp = new LinkedList<>();

        int len = trees.size();
        for(int i=0 ; i<len ; i++){
            Tree tree = trees.pollFirst();
            if(tree.z % 5 == 0){
                for(int dir=0 ; dir<8 ; dir++){
                    int nx = tree.x + dr[dir];
                    int ny = tree.y + dc[dir];
                    if(nx>=0 && nx<N && ny>=0 && ny<N){
                        tmp.add(new Tree(nx, ny, 1));
                    }
                }
            }
            trees.addLast(tree);
        }

        for(Tree tree : tmp){
            trees.addFirst(tree);
        }
    }

    private static void winter(){
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                map[i][j] += A[i][j];
            }
        }
    }

}
