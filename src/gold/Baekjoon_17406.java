package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_17406 {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[][] arr, copyArr;
    private static String[] srr, sake;
    private static boolean[] isVisited;
    private static List<Integer> q;
    private static int N, M, K, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine(), " ");
            for(int j = 0; j < M; j++){
                String s = st.nextToken();
                arr[i][j] = Integer.parseInt(s);
            }
        }

        srr = new String[K];
        sake = new String[K];
        isVisited = new boolean[K];
        for(int i = 0; i < K; i++){
            srr[i] = bf.readLine();
        }
        perm(0);

        System.out.println(min);
    }

    private static void perm(int cnt){
        if(cnt == K){
            copyArr = new int[N][M];
            for(int i = 0; i < arr.length; i++)
                System.arraycopy(arr[i],0,copyArr[i],0,arr[0].length);
            operation();    // sake
                            // [3 4 2, 4 2 1]
                            // [4 2 1, 3 4 2]
            return;
        }
        for(int i = 0; i < K; i++){
            if(!isVisited[i]){
                sake[cnt] = srr[i];
                isVisited[i] = true;
                perm(cnt+1);
                isVisited[i] = false;
            }
        }
    }

    private static void operation(){
        for(String s : sake){
            q = new ArrayList<>();
            String[] oper = s.split(" ");
            int x1 = (Integer.parseInt(oper[0]) - Integer.parseInt(oper[2]))-1; // 0
            int y1 = (Integer.parseInt(oper[1]) - Integer.parseInt(oper[2]))-1; // 1
            int x2 = (Integer.parseInt(oper[0]) + Integer.parseInt(oper[2]))-1; // 4
            int y2 = (Integer.parseInt(oper[1]) + Integer.parseInt(oper[2]))-1; // 5
            int depth = Math.min(x2-x1, y2-y1) / 2;

//            for(int d = 0; d < depth; d++){
//                for(int i = y1+d; i <= y2-d; i++) q.add(copyArr[d+x1][i]);
//                for(int i = x1+d+1; i <= x2-d; i++) q.add(copyArr[i][y2-d]);
//                for(int i = y2-d-1; i >= y1+d; i--) q.add(copyArr[x2-d][i]);
//                for(int i = x2-d-1; i >= x1+d+1; i--) q.add(copyArr[i][y1+d]);
//
//                q.add(0,q.remove(q.size()-1));
//                for(int i = y1+d; i <= y2-d; i++) copyArr[d+x1][i] = q.remove(0);
//                for(int i = x1+d+1; i <= x2-d; i++) copyArr[i][y2-d] = q.remove(0);
//                for(int i = y2-d-1; i >= y1+d; i--) copyArr[x2-d][i] = q.remove(0);
//                for(int i = x2-d-1; i >= x1+d+1; i--) copyArr[i][y1+d] = q.remove(0);
//                q.clear();
//            }
            for(int c=0; c<depth; c++) { //라인 전부 돌리기
                int val = copyArr[x1+c][y1+c]; //(c,c)

                for(int j=x1+c; j<x2-c; j++) //왼쪽
                    copyArr[j][y1+c] = copyArr[j+1][y1+c];
                for(int j=y1+c; j<y2-c; j++) //아래쪽
                    copyArr[x2-c][j] = copyArr[x2-c][j+1];
                for(int j=x2-c; j>x1+c; j--) //오른쪽
                    copyArr[j][y2-c] = copyArr[j-1][y2-c];
                for(int j=y2-c; j>y1+c; j--) //위쪽
                    copyArr[x1+c][j] = copyArr[x1+c][j-1];

                copyArr[x1+c][y1+c+1] = val;
            }
        }
        for(int[] irr : copyArr){
            int count = 0;
            for(int i : irr){
                count += i;
            }
            min = Math.min(min, count);
        }
    }
}
