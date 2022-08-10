package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_14888 {
    private static StringTokenizer st;
    private static int[] nums;
    private static int RESULT_MAX = Integer.MIN_VALUE, RESULT_MIN = Integer.MAX_VALUE, N;
    private static int[] operator = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        nums = new int[N];

        st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < 4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        perm(1, nums[0]);
        System.out.println(RESULT_MAX);
        System.out.println(RESULT_MIN);
    }

    private static void perm(int cnt, int num){
        if(cnt == N){
            RESULT_MAX = Math.max(RESULT_MAX, num);
            RESULT_MIN = Math.min(RESULT_MIN, num);
            return;
        }
        for(int i = 0; i < 4; i ++){
            if(operator[i] > 0){
                operator[i]--;
                switch (i){
                    case 0: // +
                        perm(cnt+1, num + nums[cnt]);
                        break;
                    case 1: // -
                        perm(cnt+1, num - nums[cnt]);
                        break;
                    case 2: // *
                        perm(cnt+1, num * nums[cnt]);
                        break;
                    case 3: // /
                        perm(cnt+1, num / nums[cnt]);
                        break;
                }
                operator[i]++;
            }
        }
    }
}
