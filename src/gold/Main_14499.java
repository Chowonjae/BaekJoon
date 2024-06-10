package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499 {
    static int N, M, x, y, K;
    static int[] dice = {0, 0, 0, 0, 0, 0}; // index 1이 주사위 상단, index 3이 주사위 바닥
    static int[][] map;
    static int[] order;
    static int[] dx = {0, 0, 0, -1, 1}, dy = {0, 1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        order = new int[K];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine()," ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(bf.readLine(), " ");
        for(int i = 0; i < K; i++){
            order[i] = Integer.parseInt(st.nextToken());
        }

        for(int i : order){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx == N || ny == M) continue;    // 범위 밖 명령 무시

            go(i);

            if(map[nx][ny] == 0){   // 이동한 칸의 쓰여있는 수가 0이면
                map[nx][ny] = dice[3];
            }else{
                dice[3] = map[nx][ny];
                map[nx][ny] = 0;
            }
            sb.append(dice[1]).append("\n");
            x = nx; y = ny;
        }
        System.out.println(sb.toString());
    }
    static void go(int o){
        int temp = dice[3];
        switch (o){
            case 1:
                dice[3] = dice[2];
                dice[2] = dice[1];
                dice[1] = dice[0];
                dice[0] = temp;
                break;
            case 2:
                dice[3] = dice[0];
                dice[0] = dice[1];
                dice[1] = dice[2];
                dice[2] = temp;
                break;
            case 3:
                dice[3] = dice[4];
                dice[4] = dice[1];
                dice[1] = dice[5];
                dice[5] = temp;
                break;
            case 4:
                dice[3] = dice[5];
                dice[5] = dice[1];
                dice[1] = dice[4];
                dice[4] = temp;
                break;
        }
    }
}
