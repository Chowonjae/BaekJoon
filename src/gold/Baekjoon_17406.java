package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_17406 {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[][] arr;
    private static String[] srr;
    private static List<String> l;
    private static int N, M, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine(), " ");
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        srr = new String[K];
        for(int i = 0; i < K; i++){
            srr[i] = bf.readLine();
        }
        perm(0);
        System.out.println(l);
    }

    private static void perm(int cnt){
        if(cnt == K){
            return;
        }
        for(int i = 0; i < K; i++){
            l.add(srr[i]);
            perm(cnt+1);
        }
    }
}
