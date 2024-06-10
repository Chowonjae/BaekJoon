package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15683 {
    static int[][] cctvs;
    static int cnt, N, M, RESULT = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        cnt = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < M; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp != 0 && temp != 6) cnt++;
                map[i][j] = temp;
            }
        }
        cctvs = new int[cnt][3];

        int index = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] != 0 && map[i][j] != 6) cctvs[index++] = new int[] {map[i][j], i, j};
            }
        }
//        System.out.println(cnt);
//        for(String[] s : map) System.out.println(Arrays.toString(s));
        dfs(map, 0);
        System.out.println(RESULT);
    }

    static void dfs(int[][] map, int f){
        if(f==cnt){
            int count = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j] == 0) count++;
                }
            }
            System.out.println(count);
            RESULT = Math.min(count, RESULT);
            for(int a = 0; a < N; a++){
                for(int b = 0; b < M; b++){
                    if(map[a][b]==7) map[a][b] = 0;
                }
            }
            return;
        }

        for(int i = f; i < cnt; i++){
            for(int j = 0; j < 4; j++){
                switch (cctvs[i][0]){
                    case 1:
                        dfs(work(j, map, cctvs[i][1], cctvs[i][2]), f+1);
                        break;
                    case 2:
                        if(j == 0 || j == 2){
                            map = work(0, map, cctvs[i][1], cctvs[i][2]);
                            map = work(2, map, cctvs[i][1], cctvs[i][2]);
                        }else{
                            map = work(1, map, cctvs[i][1], cctvs[i][2]);
                            map = work(3, map, cctvs[i][1], cctvs[i][2]);
                        }
                        dfs(map, f+1);
                        break;
                    case 3:
                        if(j == 0) {
                            map = work(0, map, cctvs[i][1], cctvs[i][2]);
                            map = work(1, map, cctvs[i][1], cctvs[i][2]);
                        } else if(j== 1) {
                            map = work(1, map, cctvs[i][1], cctvs[i][2]);
                            map = work(2, map, cctvs[i][1], cctvs[i][2]);
                        } else if(j == 2) {
                            map = work(2, map, cctvs[i][1], cctvs[i][2]);
                            map = work(3, map, cctvs[i][1], cctvs[i][2]);
                        } else if(j == 3) {
                            map = work(3, map, cctvs[i][1], cctvs[i][2]);
                            map = work(4, map, cctvs[i][1], cctvs[i][2]);
                        }
                        dfs(map, f+1);
                        break;
                    case 4:
                        if(j == 0) {
                            map = work(0, map, cctvs[i][1], cctvs[i][2]);
                            map = work(1, map, cctvs[i][1], cctvs[i][2]);
                            map = work(3, map, cctvs[i][1], cctvs[i][2]);
                        } else if(j  == 1) {
                            map = work(0, map, cctvs[i][1], cctvs[i][2]);
                            map = work(1, map, cctvs[i][1], cctvs[i][2]);
                            map = work(2, map, cctvs[i][1], cctvs[i][2]);
                        } else if(j == 2) {
                            map = work(1, map, cctvs[i][1], cctvs[i][2]);
                            map = work(2, map, cctvs[i][1], cctvs[i][2]);
                            map = work(3, map, cctvs[i][1], cctvs[i][2]);
                        } else if(j == 3) {
                            map = work(0, map, cctvs[i][1], cctvs[i][2]);
                            map = work(2, map, cctvs[i][1], cctvs[i][2]);
                            map = work(3, map, cctvs[i][1], cctvs[i][2]);
                        }
                        dfs(map, f+1);
                        break;
                    case 5:
                        map = work(0, map, cctvs[i][1], cctvs[i][2]);
                        map = work(1, map, cctvs[i][1], cctvs[i][2]);
                        map = work(2, map, cctvs[i][1], cctvs[i][2]);
                        map = work(3, map, cctvs[i][1], cctvs[i][2]);
                        dfs(map, f+1);
                        break;
                }
            }
        }
    }

    static int[][] work(int d, int[][] map, int x, int y){
        while(true){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] != 6) {
                map[nx][ny] = 7;
                x = nx;
                y = ny;
            }
            else break;
        }
        return map;
    }
}
