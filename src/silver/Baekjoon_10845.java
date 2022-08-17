package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(bf.readLine());
        int last = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());
            String order = st.nextToken();
            switch (order){
                case "push":
                    int temp = Integer.parseInt(st.nextToken());
                    last = temp;
                    queue.add(temp);
                    break;
                case "front":
                    if(queue.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(queue.peek()).append("\n");
                    }
                    break;
                case "back":
                    if(queue.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(last).append("\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "pop":
                    if(queue.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(queue.poll()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
