package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Baekjoon_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        HashSet<String> set = new HashSet<>();
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        for(int i = 0; i < T; i++){
            set.add(bf.readLine());
        }
        pq.addAll(set);
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }
        System.out.print(sb.toString());
    }
}
