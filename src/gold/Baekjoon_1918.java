package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Baekjoon_1918 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static Stack<String> stack = new Stack<>();
    private static String[] median;
    private static String backward;
    public static void main(String[] args) throws IOException {
        median = br.readLine().split("");
        System.out.println(Arrays.toString(median));
        for(String s : median){
            switch (s){
                case "+":
                case "-":
                case "*":
                case "/":
                    while(!stack.isEmpty() && (stack.peek().equals("*") && stack.peek().equals("/"))){
                        sb.append(stack.pop());
                    }
                    stack.add(s);
                    break;
                case "(":
                    stack.add(s);
                    break;
                case ")":
                    while(!stack.isEmpty() && !stack.peek().equals("(")){
                        if(stack.peek().equals("(")) stack.pop();
                        sb.append(stack.pop());
                    }
                    break;
                default:
                    sb.append(s);
                    break;
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek().equals("(")) stack.pop();
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
