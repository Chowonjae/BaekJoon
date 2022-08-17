package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1018 {
    private static int RESULT_MIN;
    private static String[][] board;
    private static String[][] boardCopy;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new String[N][M];
        boardCopy = new String[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine(), "");
            for(int j = 0; j < M; j++){
                String temp = st.nextToken();
                board[i][j] = temp;
                boardCopy[i][j] = temp;
            }
        }
        // 세로로 검사
//        int cnt;
//        for(int i = 0; i <= N - 8; i++) {
//            for (int j = 0; j <= M - 8; j++) {
//                cnt = 0;
//                for (int k = i; k < i + 8; k++) {
//                    for (int h = j; h < j + 8; h++) {
//                        if(k==0){
//                            if(board[k][h].equals(board[k-1][h])) {
//                                cnt++;
//                                if(board[k][h].equals("W")){
//                                    board[k][h] = "B";
//                                }else{
//                                    board[k][h] = "W";
//                                }
//                            }
//                        }else{
//                            if(board[k][h].equals(board[k][h-1])){
//                                cnt++;
//                                if(board[k][h].equals("W")){
//                                    board[k][h] = "B";
//                                }else{
//                                    board[k][h] = "W";
//                                }
//                            }
//                        }
//                    }
//                }
//                System.arraycopy(boardCopy, i, board, i, 8);
//            }
//        }

    }
}
