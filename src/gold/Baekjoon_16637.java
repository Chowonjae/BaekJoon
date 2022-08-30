package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_16637 {
    static int N, RESULT_MAX = Integer.MIN_VALUE;
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        s = bf.readLine();

        search(1, s.charAt(0)-'0');

        System.out.print(RESULT_MAX);
    }

    private static void search(int cnt, int sum){
        if(cnt == N){
//            System.out.println(cnt + " " + sum);
            RESULT_MAX = Math.max(RESULT_MAX, sum);
            return;
        }
        search(cnt+2, cal(sum, s.charAt(cnt+1)-'0', s.charAt(cnt)));

        if(cnt+2 < N){  // cnt 를 9 (N) 미만으로 낮춰야 한다, 그래야 아래 재귀를 돌릴때 cnt가 N을 벗어나는 일이 없다.
            search(cnt+4, cal(sum, cal(s.charAt(cnt+1)-'0', s.charAt(cnt+3)-'0', s.charAt(cnt+2)), s.charAt(cnt)));
        }
    }

    private static int cal(int a, int b, char op){
        switch (op){
            case '+':
                return a + b;
            case '-':
                return a - b;
            default:
                return a * b;
        }
    }
}
