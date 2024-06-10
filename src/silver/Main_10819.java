package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819 {
    static int N, RESULT_MAX = Integer.MIN_VALUE;
    static int[] nums, result;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        nums = new int[N];
        result = new int[N];
        isVisited = new boolean[N];

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        perm(0);
        System.out.println(RESULT_MAX);
    }
    static void perm(int cnt){
        if(cnt==N){
            RESULT_MAX = Math.max(RESULT_MAX, summery());
            return;
        }

        for(int i = 0; i < N; i++){
            if(isVisited[i]) continue;
            isVisited[i] = true;
            result[cnt] = nums[i];
            perm(cnt+1);
            isVisited[i] = false;
        }
    }

    static int summery(){
        int sum = 0;
        for(int i = 0; i < N-1; i++){
            sum += (Math.abs(result[i]-result[i+1]));
        }
        return sum;
    }
}
