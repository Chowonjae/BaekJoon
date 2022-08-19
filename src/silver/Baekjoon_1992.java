package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1992 {
    private static int[][] tree;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        tree = new int[N][N];
        for(int i = 0; i < N; i++){
            String s = bf.readLine();
            for(int j = 0; j < N; j++){
                tree[i][j] = s.charAt(j) - '0';
            }
        }

        quadTree(0, 0, N);
        System.out.print(sb.toString());
    }
    private static void quadTree(int x, int y, int N){
        int cnt = 0;
        a : for(int i = x; i < x + N; i++){
            for(int j = y; j < y + N; j++){
                if(tree[x][y] != tree[i][j]){
                    break a;
                }else{
                    cnt++;
                }
            }
        }
        if(cnt == N*N){
            sb.append(tree[x][y]);
            return;
        }


        sb.append("(");
        // 1 사분면
        quadTree(x, y, N/2);
        // 2 사분면
        quadTree(x, y + N/2, N/2);
        // 3 사분면
        quadTree(x + N/2, y, N/2);
        // 4 사분면
        quadTree(x + N/2, y + N/2 , N/2);
        sb.append(")");
    }
}
