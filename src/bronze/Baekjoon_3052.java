package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Baekjoon_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hashSet = new HashSet<>();

        for(int i = 0; i < 10; i++){
            hashSet.add(Integer.parseInt(bf.readLine()) % 42);
        }

        System.out.print(hashSet.size());
    }
}
