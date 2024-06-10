package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21610 {
    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static int[][] map, cmap;
    static boolean[][] removeArr;
    static Queue<Node> cloud;
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1}, dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        cmap = new int[N][N];
        removeArr = new boolean[N][N];

        cloud = new LinkedList<>();

        cloud.offer(new Node(N-1, 0));
        cloud.offer(new Node(N-1, 1));
        cloud.offer(new Node(N-2, 0));
        cloud.offer(new Node(N-2, 1));

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int move = 0; move < M; move++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int dist = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            cnt = cnt % N;

            int size = cloud.size();
            System.out.println(size);
            while(size-->0){
                Node temp = cloud.poll();
                int nx = (temp.x + N + (dx[dist] * cnt)) % N;
                int ny = (temp.y + N + (dy[dist] * cnt)) % N;
                cloud.offer(new Node(nx, ny));
            }

            copy();
            // 구름이 사라지며 바구니의 물의 양이 1 증가
            while(!cloud.isEmpty()) {
                Node temp = cloud.poll();
                map[temp.x][temp.y]++;
                removeArr[temp.x][temp.y] = true;	// 사라진 구름 위치 나중에 false로 돌려줘야 함
                int count = 0;
                for(int i = 2; i <= 8; i+=2) {		// 대각선에 물이 있으면 개수를 세고
                    int nx = temp.x + dx[i];
                    int ny = temp.y + dy[i];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if(cmap[nx][ny] != 0) count++;
                }
                map[temp.x][temp.y] += count;		// 대각선에 물이 있는 만큼 해당칸에 물을 증가
            }

            print();
            System.out.println();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] >= 2 && !removeArr[i][j]){
                        cloud.offer(new Node(i, j));
                        map[i][j] -= 2;
                    }
                }
            }

            init();
        }
        int sum = 0;
        for(int[] ia : map){
            for(int i : ia){
                sum += i;
            }
        }
        System.out.println(sum);
    }
    static void copy() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                cmap[i][j] = map[i][j];
            }
        }
    }
    static void init() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                removeArr[i][j] = false;
            }
        }
    }
    static void print(){
        for(int[] i : map) System.out.println(Arrays.toString(i));
    }
}

