package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18691 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int[] group = new int[]{0, 1, 3, 5};
        int T = Integer.parseInt(bf.readLine());
        int G, C, E;
        for(int tc = 0; tc < T; tc++){
            st = new StringTokenizer(bf.readLine(), " ");
            G = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            int moreCandies = E - C;
            if(moreCandies * group[G] <= 0)
                sb.append(0).append("\n");
            else
                sb.append(moreCandies * group[G]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
