package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cnt = new int[26];
        char[] arr = br.readLine().toUpperCase().toCharArray();
        int max = Integer.MIN_VALUE;
        char result = 0;
        int index = 0;
        for(char c : arr) {
            cnt[c - 65]++;
        }
        for(int i = 0; i < 26; i++) {
            if (max < cnt[i]) {
                max = cnt[i];
                index = i;
            }
        }
        for(int i = 0; i < 26; i++){
            if(i != index) {
                if (max == i) {
                    result = '?';
                    break;
                }
            }
            result = (char)(index+65);
        }
        System.out.println(result);
    }
}

