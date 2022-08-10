package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_1937 {
    private static int[][] forest;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean[][] isVisited;
    private static int n, result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(bf.readLine());
        forest = new int[n+2][n+2];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 1; j <= n; j++){
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                dfs(i, j, 1);
            }
        }
        System.out.println(result);
    }
    private static void dfs(int x, int y, int dist){
        Stack<Node> queue = new Stack<>();
        queue.add(new Node(x, y, dist));
        isVisited = new boolean[n+2][n+2];
        isVisited[x][y] = true;
        while (!queue.isEmpty()) {
            Node node = queue.pop();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (forest[nx][ny] > forest[node.x][node.y]) {
                    queue.add(new Node(nx, ny, node.dist += 1));
                    isVisited[nx][ny] = true;
                }
            }
            result = Math.max(result, node.dist);
        }
    }
}

class Node{
    int x, y;
    int dist;
    public Node(int x, int y, int dist){
        this.dist = dist;
        this.x = x;
        this.y = y;
    }
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}