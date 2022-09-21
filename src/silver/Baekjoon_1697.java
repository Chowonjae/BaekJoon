package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1697 {
    private static int[] sec = new int[100001];
    private static int[] move = {-1, 1, 2};
    private static int N, K;
    private static int RESULT_MIN;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

//        sec = new int[K];
        search(N);
        System.out.println(RESULT_MIN);
    }

    private static void search(int N){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        sec[N] = 1;

        while (!queue.isEmpty()){
            int x = queue.remove();

            if(x == K) {
                RESULT_MIN = sec[x]-1;
                break;
            }

            for(int i = 0; i < 3; i++){
                int nx;
                if(i == 2){
                    nx = x * move[i];
                }else{
                    nx = x + move[i];
                }
                if(nx < 0 || nx >= 100_001 || sec[nx] != 0) continue;
                queue.add(nx);
                sec[nx] = sec[x]+1;
            }
        }
    }
}
