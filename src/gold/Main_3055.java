package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
	'.' 빈공간
	'*' 물
	'X' 돌
	'D' 비버숲(도착지)
	'S' 고슴도치 위치(현 위치)
 */
public class Main_3055 {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1}, start, end, water;
    static int R, C, time;
    static char[][] map;
    static boolean[][] isVisited;
    static int flag;
    static Queue<int[]> wQueue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ss = new StringTokenizer(bf.readLine(), " ");
        R = Integer.parseInt(ss.nextToken());
        C = Integer.parseInt(ss.nextToken());

        start = new int[2];
        end = new int[2];
        water = new int[2];

        isVisited = new boolean[R+2][C+2];
        map = new char[R+2][C+2];
        for(int i = 1; i <= R; i++) {
            String temp = bf.readLine();
            for(int j = 1; j <= C; j++) {
                map[i][j] = temp.charAt(j-1);
                switch (map[i][j]) {
                    case 'D':
                        end[0] = i; end[1] = j;
                        break;
                    case 'S':
                        start[0] = i; start[1] = j;
                        break;
                    case '*':
                        wQueue.add(new int[] {i,j});
                        break;
                }
            }
        }
        play();

        if(flag==1) System.out.println(time);
        else System.out.println("KAKTUS");
    }
    private static void play() {
        Queue<int[]> sQueue = new LinkedList<>();
        sQueue.add(start);	// 고슴도치
        isVisited[start[0]][start[1]] = true;
        time = 0;

        out : while(!sQueue.isEmpty()) {
            // while 문은 분당 시간
            // 물 먼저
            time++;
            int wSize = wQueue.size();
            while(wSize-- > 0) {
                int[] temp = wQueue.poll();
                for(int i = 0; i < 4; i++) {
                    int nx = temp[0] + dx[i];
                    int ny = temp[1] + dy[i];
                    if(nx == end[0] && ny == end[1]) continue;
                    if(map[nx][ny] == '.' || map[nx][ny] == 'S') {
                        map[nx][ny] = '*';
                        wQueue.add(new int[] {nx, ny});
                    }
                }
            }

            int sSize = sQueue.size();
            while(sSize-- > 0) {
                int[] temp = sQueue.poll();
                for(int i = 0; i < 4; i++) {
                    int nx = temp[0] + dx[i];
                    int ny = temp[1] + dy[i];
                    if(nx == end[0] && ny == end[1]) {
                        flag = 1;
                        break out;
                    }
                    if((map[nx][ny] == '.' || map[nx][ny] == 'D') && !isVisited[nx][ny]) {
                        map[nx][ny] = 'S';
                        isVisited[nx][ny] = true;
                        sQueue.add(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}


