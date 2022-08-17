package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] check = new int[N+1];

        for(int i = 2; i <= N; i++){
            check[i] = i;
        }

        boolean isPrime;
        for(int i = 2; i <= Math.sqrt(N); i++){
            if(check[i] == 0) continue;
            for(int j = i * 2; j <= N; j+=i){
                check[j]=0;
            }
        }

        for(int i = M; i <= N; i++){
            if(check[i] != 0) sb.append(check[i]).append("\n");
        }
        System.out.print(sb.toString());
    }
}
