package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_3190 {
    static class Snake{
        int x, y, dist;
        Snake(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    static int N, K, SEC, dist;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static Snake snake;
    static Queue<Snake> q;
    static Map<Integer, String> info;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine().trim());
        K = Integer.parseInt(bf.readLine().trim());

        map = new int[N+2][N+2];
        snake = new Snake(1, 1, 3);
        info = new HashMap<>();

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(bf.readLine(), " ");
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        int L = Integer.parseInt(bf.readLine().trim());

        dist = 3;
        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            info.put(X, C);
        }
        bfs();

        System.out.println(SEC);
    }
    private static void bfs(){
        q = new LinkedList<>();
        q.offer(snake);
        SEC = 0;
        while(true){
            Snake temp = q.peek();
            int nx = temp.x + dx[dist];
            int ny = temp.y + dy[dist];
            SEC++;
            if(nx == 0 || ny == 0 || nx > N || ny > N) break;
            if(isIt(nx, ny)) break;

            if(map[ny][nx] == 1){
                map[ny][nx] = 0;
                q.offer(new Snake(ny, nx, dist));
            }else{
                q.offer(new Snake(ny, nx, dist));
                q.poll();
            }
            if(info.containsKey(SEC)){
                String nDist = info.get(SEC);
                switch (dist){
                    case 0:
                        if(nDist.equals("L")) dist = 2;
                        else if(nDist.equals("D")) dist = 3;
                        break;
                    case 1:
                        if(nDist.equals("L")) dist = 3;
                        else if(nDist.equals("D")) dist = 2;
                        break;
                    case 2:
                        if(nDist.equals("L")) dist = 1;
                        else if(nDist.equals("D")) dist = 0;
                        break;
                    case 3:
                        if(nDist.equals("L")) dist = 0;
                        else if(nDist.equals("D")) dist = 1;
                        break;
                }
            }
        }

    }
    private static boolean isIt(int nx, int ny){
        boolean flag = false;
        for(Snake s : q){
            if(s.x == ny && s.y == nx) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
