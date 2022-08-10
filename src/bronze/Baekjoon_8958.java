package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int i = 0; i < T; i++){
            int total = 0;
            char[] crr = bf.readLine().toCharArray();
            int cnt = 0;
            for(char c : crr){
                if(c == 'O') cnt++;
                else cnt = 0;
                total += cnt;
            }
            System.out.println(total);
        }
    }
}
