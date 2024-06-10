package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500 {
    static int N, M, ans;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        ans = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 긴 막대기
        for(int i = 0; i < N; i++){
            int temp = 0;
            for(int j = 0; j <= M - 4; j++){
                temp += map[i][j];
            }
        }
    }
}
