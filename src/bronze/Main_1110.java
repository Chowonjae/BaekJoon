package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1110 {
    static int RESULT, data;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        data = Integer.parseInt(bf.readLine());
        search(cycle(data), 1);
        System.out.println(RESULT);
    }

    static void search(int num, int cnt){
        if(data == num){
            RESULT = cnt;
            return;
        }
        search(cycle(num), cnt+1);
    }

    static int cycle(int num){
        int temp = num % 10;
        int div = num / 10;
        int result = (temp + div)%10;
        return temp*10 + result;
    }
}
