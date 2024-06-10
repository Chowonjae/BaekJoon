package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_9610 {
    static Map<String, Integer> ans = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());
        ans.put("Q1", 0);
        ans.put("Q2", 0);
        ans.put("Q3", 0);
        ans.put("Q4", 0);
        ans.put("AXIS", 0);
        for(int tc = 0; tc < T; tc++){
            st = new StringTokenizer(bf.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x == 0 || y == 0){
                ans.put("AXIS", ans.get("AXIS")+1);
            }else if(x < 0 && y < 0){
                ans.put("Q3", ans.get("Q3")+1);
            }else if(x < 0 && y > 0){
                ans.put("Q2", ans.get("Q2")+1);
            }else if(x > 0 && y < 0){
                ans.put("Q4", ans.get("Q4")+1);
            }else if(x > 0 && y > 0){
                ans.put("Q1", ans.get("Q1")+1);
            }
        }
        sb.append("Q1: ").append(ans.get("Q1")).append("\n")
                .append("Q2: ").append(ans.get("Q2")).append("\n")
                .append("Q3: ").append(ans.get("Q3")).append("\n")
                .append("Q4: ").append(ans.get("Q4")).append("\n")
                .append("AXIS: ").append(ans.get("AXIS"));
        System.out.println(sb);
    }
}
