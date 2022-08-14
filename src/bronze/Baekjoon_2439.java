package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());

        for(int i = 0; i < N; i++){
            for(int j = N-i-1; j > 0; j--){
                sb.append(" ");
            }
            for(int k = 0; k < 1+i; k++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
