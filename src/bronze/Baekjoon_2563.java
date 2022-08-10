package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());    // 색종이 수
        int[][] board = new int[100][100];
        int cnt = 0;
        for(int tc = 1; tc <= N; tc++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = x1 + 10;
            int y2 = y1 + 10;
            for(int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    if(board[i][j] != 1) {
                        board[i][j] = 1;
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
