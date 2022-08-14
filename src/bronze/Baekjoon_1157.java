package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[26];
        char[] arr = br.readLine().toUpperCase().toCharArray();
        int max = Integer.MIN_VALUE;
        char result = '?';
        for (char c : arr) {
            cnt[c - 65]++;
        }

        for (int i = 0; i < 26; i++) {
            if (max == cnt[i]) {
                result = '?';
            }else if (max < cnt[i]) {
                max = cnt[i];
                result = (char) (i + 65);
            }
        }
        System.out.print(result);
    }
}

