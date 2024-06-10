package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1593 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int g = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        String W = bf.readLine();
        String S = bf.readLine();
        int[] wArr = new int[52];
        int[] sArr = new int[52];

        int ans = 0;

        for(int i = 0; i < g; i++){
            char temp = W.charAt(i);
            if('a' <= temp && temp <= 'z') {   // 소문자
                wArr[temp - 'a']++;
            }else{  // 대문자
                wArr[temp - 'A' + 26]++;
            }
        }

        int size = 0;
        int start = 0;
        for(int i = 0; i < s; i++){
            char temp = S.charAt(i);
            if(isUpper(temp)) sArr[temp - 'A' + 26]++;
            else sArr[temp - 'a']++;

            size++;
            if(size == g){  // S의 추출 글자 수가 W의 수랑 같으면
                if(Arrays.equals(sArr, wArr)){
                    ans++;
                }
                char mTemp = S.charAt(start);
                if(isUpper(mTemp)) sArr[mTemp - 'A' + 26]--;
                else sArr[mTemp - 'a']--;
                start++;
                size--;
            }
        }
        System.out.println(ans);
    }

    static boolean isUpper(char c){
        // 소문자
        // 대문자
        return 'a' > c || c > 'z';
    }
}
