package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(bf.readLine());
        int[] target = new int[n];

        for(int i = 0; i < n; i++){
            target[i] = Integer.parseInt(bf.readLine());
        }
        int data = 1;
        int index = 0;
        stack.push(data++);
        sb.append("+").append("\n");
        while (!stack.isEmpty()){
            if(target[index] == stack.peek()){
                stack.pop();
                sb.append("-").append("\n");
                index++;
            }else{
                stack.push(data++);
                sb.append("+").append("\n");
            }
            if(data+2>n) {
                System.out.println("NO");
                return;
            }
        }
        System.out.print(sb.toString());
    }
}
