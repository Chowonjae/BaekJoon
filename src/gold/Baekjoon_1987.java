package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1987 {
    static boolean[] alpha;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int RESULT_MAX = Integer.MIN_VALUE, R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alpha = new boolean[26];
        map = new char[R][];

        for(int i = 0 ; i < R; i++){
            map[i] = bf.readLine().toCharArray();
        }

        search(0,0, 0);
        System.out.println(RESULT_MAX);
    }

    private static void search(int x, int y, int dist){
        if(RESULT_MAX == 26) return;
        if(alpha[map[x][y]-'A']){
            RESULT_MAX = Math.max(dist, RESULT_MAX);
            return;
        }
        alpha[map[x][y]-'A'] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < R && ny < C){
                search(nx, ny, dist+1);
            }
        }
        alpha[map[x][y]-'A'] = false;
    }
}
