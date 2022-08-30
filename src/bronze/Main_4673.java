package bronze;

import java.io.IOException;
import java.util.Arrays;

public class Main_4673 {
    static int[] nums = new int[10_001];
    static int[] db = new int[10_001];
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= 10_000; i++) {
            nums[i] = i; db[i] = i;
        }
        for(int i : db) {
            if(i!=0) self(i);
        }
        for(int i = 1; i <= 10_000; i++){
            if(nums[i]!=0) sb.append(i).append("\n");
        }
        System.out.print(sb.toString());
    }
    static void self(int num){
        int temp = num;
        while(num!=0){
            temp = temp + (num%10);
            num = num / 10;
        }
        if(temp<10_001) nums[temp] = 0;
    }
}
