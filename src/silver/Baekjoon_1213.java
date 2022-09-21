package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha_cnt = new int[26];
        int sum = 0;
        int cnt = 0;
        String s = bf.readLine();
        StringBuilder result_left = new StringBuilder();
        StringBuilder result_right = new StringBuilder();
        StringBuilder center = new StringBuilder();
        for(char temp : s.toCharArray()){
            alpha_cnt[temp-'A']++;
        }
        for(int i : alpha_cnt) {
            sum += i;
            if(i%2!=0) cnt++;
        }
        if(cnt > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        // 짝수
        if(sum % 2 == 0){
            for(int i = 0; i < 26; i++){
                if(alpha_cnt[i] != 0){
                    int temp = alpha_cnt[i];
                    for(int j = 0; j < temp/2; j++){
                        result_left.append((char)(i + 'A'));
                        result_right.append((char)(i + 'A'));
                    }
                }
            }
        }else { //홀수
            for(int i = 0; i < 26; i++){
                if(alpha_cnt[i] != 0){
                    int temp = alpha_cnt[i];
                    for(int j = 0; j < temp/2; j++){
                        result_left.append((char)(i + 'A'));
                        result_right.append((char)(i + 'A'));
                    }
                    if(alpha_cnt[i] % 2!=0){
                        center.append((char)(i+'A'));
                    }
                }
            }
        }
        result_right.reverse();

        System.out.println(result_left.append(center).append(result_right));

    }
}
