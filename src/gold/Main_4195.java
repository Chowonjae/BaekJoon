package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_4195 {
    static int[] p;
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc < T; tc++){
            Map<String, Integer> network = new HashMap<>();
            int F = Integer.parseInt(bf.readLine());
            p = new int[F*2];
            cnt = new int[F*2];
            for(int i = 0; i < F * 2; i++){
                p[i] = i;
                cnt[i] = 1;
            }
            int idx = 0;
            for(int f = 0; f < F; f++){
                StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
                String first = st.nextToken();
                String second = st.nextToken();
                if(!network.containsKey(first)){
                    network.put(first, idx++);
                }
                if(!network.containsKey(second)){
                    network.put(second, idx++);
                }

                sb.append(union(network.get(first), network.get(second))).append("\n");
            }
        }
        System.out.println(sb);
    }
    static int find(int a){
        if(p[a] == a) return a;
        else return p[a] = find(p[a]);
    }
    static int union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            p[b] = a;
            cnt[a] += cnt[b];
        }
        return cnt[a];
    }
}
