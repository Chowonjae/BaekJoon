package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1926 {
    static int n, m;
    static int total, max;
    static int[][] pic;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pic = new int[n][m];
        visited = new boolean[n][m];
        total = 0;
        max = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(bf.readLine(), " ");
            for(int j = 0; j < m; j++){
                pic[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(pic[i][j] == 1 && !visited[i][j]){
                    bfs(i, j);
                    total++;
                }
            }
        }

        System.out.println(total);
        System.out.println(max);
    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        int cnt = 1;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || pic[nx][ny] == 0) continue;
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                cnt++;
            }
        }
        max = Math.max(cnt, max);
    }
}
