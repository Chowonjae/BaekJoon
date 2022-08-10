package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] srr = bf.readLine().split("");
        int total = 0;
        for(String s : srr){
            total += Integer.parseInt(s);
        }
        System.out.println(total);
    }
}
