package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(bf.readLine());
        int B = Integer.parseInt(bf.readLine());
        int C = Integer.parseInt(bf.readLine());

        int[] index = new int[10];
        String[] X = String.valueOf(A*B*C).split("");

        for(String x : X) index[Integer.parseInt(x)]++;

        for(int i : index) sb.append(i).append("\n");
        System.out.print(sb.toString());
    }
}
