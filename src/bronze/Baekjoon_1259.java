package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String num;
            String result = "yes";
            num = bf.readLine();
            if(num.charAt(0) == '0') break;
            int num_length = num.length();
            for(int i = 0; i < num_length/2; i++){
                if(num.charAt(i) != num.charAt(num_length-1-i)) {
                    result = "no";
                    break;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.print(sb.toString());
    }
}
