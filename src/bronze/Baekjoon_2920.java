package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] srr = bf.readLine().split(" ");
        int cnt;
        if(srr[0].equals("1")){
            cnt = 1;
            for(String s : srr){
                if(Integer.parseInt(s) != cnt){
                    System.out.println("mixed");
                    return;
                }
                cnt++;
            }
            System.out.println("ascending");
        }else if(srr[0].equals("8")){
            cnt = 8;
            for(String s : srr){
                if(Integer.parseInt(s) != cnt){
                    System.out.println("mixed");
                    return;
                }
                cnt--;
            }
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }
    }
}
