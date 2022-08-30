package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2750 {
    static int[] nums;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(bf.readLine());
        nums = new int[N];
        for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(bf.readLine());
        while(true){
            sort();
            if(isOrder()) break;
        }
        for(int i : nums) sb.append(i).append("\n");
        System.out.print(sb.toString());
    }

    static void sort(){
        int temp = 0;
        for(int i = 0; i < N-1; i++){
            if(nums[i] > nums[i+1]){
                temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
    }

    static boolean isOrder(){
        for(int i = 0; i < N-1; i++){
            if(nums[i] > nums[i+1]) return false;
        }
        return true;
    }
}
