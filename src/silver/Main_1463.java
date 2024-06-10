package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        dp = new int[N+1];

        dp[0] = -1;
        dp[1] = 0;

        System.out.println(dfs(N));
    }

    static int dfs(int N){
        if(dp[N] == 0){
            if(N % 6 == 0){
                dp[N] = Math.min(dfs(N-1), Math.min(dfs(N/2), dfs(N/3))) + 1;
            }else if(N % 3 == 0){
                dp[N] = Math.min(dfs(N / 3), dfs(N - 1)) + 1;
            }else if(N % 2 == 0){
                dp[N] = Math.min(dfs(N / 2), dfs(N - 1)) + 1;
            }else{
                dp[N] = dfs(N - 1) + 1;
            }
        }
        return dp[N];
    }
}
