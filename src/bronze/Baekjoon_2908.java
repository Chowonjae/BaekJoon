package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String[] sa = st.nextToken().split("");
        String[] sb = st.nextToken().split("");
        String[] temp1 = new String[3];
        String[] temp2 = new String[3];
        int fir = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        for(int i = 0; i < 3; i++){
            temp1[3-i-1] = sa[i];
            temp2[3-i-1] = sb[i];
        }
        System.out.print(Math.max(Integer.parseInt(temp1[0] + temp1[1] + temp1[2]),
                Integer.parseInt(temp2[0] + temp2[1] + temp2[2])));
    }
}
