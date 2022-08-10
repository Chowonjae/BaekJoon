package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_10818 {
    private static int RESULT_MIN = Integer.MAX_VALUE;
    private static int RESULT_MAX = Integer.MIN_VALUE;
    private static int N;
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
         N = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++){
            int temp = Integer.parseInt(st.nextToken());
            RESULT_MAX = Math.max(RESULT_MAX, temp);
            RESULT_MIN = Math.min(RESULT_MIN, temp);
        }
        sb.append(RESULT_MIN).append(" ").append(RESULT_MAX);
        System.out.println(sb);
    }
}
