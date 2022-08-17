package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int[] coordinate = new int[4];
        coordinate[0] = Integer.parseInt(st.nextToken());
        coordinate[1] = Integer.parseInt(st.nextToken());
        coordinate[2] = Integer.parseInt(st.nextToken());
        coordinate[3] = Integer.parseInt(st.nextToken());

        int temp1 = Math.min((coordinate[2]-coordinate[0]), (coordinate[3]-coordinate[1]));
        int temp2 = Math.min((coordinate[0]-0), (coordinate[1]-0));
        System.out.println(Math.min(temp1, temp2));
    }
}
