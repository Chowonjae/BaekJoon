package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String target = bf.readLine();
        String bomb = bf.readLine();
        StringBuilder sb = new StringBuilder();

//        while(target.contains(bomb)){                 // 자바에서는 String 연산을 계속 할 경우 String을 계속해서 새로 만들기 때문에 메모리 초과가 발생
//            target = target.replaceAll(bomb, "");
//        }
//
//        if(target.equals("")){
//            System.out.println("FRULA");
//        }else{
//            System.out.println(target);
//        }

        int bombLength = bomb.length();
        boolean isSame = true;

        for(int i = 0; i < target.length(); i++){
            sb.append(target.charAt(i));
            if(sb.length() >= bombLength){
                isSame = true;
                for(int j = 0; j < bombLength; j++){
                    if(sb.charAt(sb.length() - bombLength + j) != bomb.charAt(j)){
                        isSame = false;
                        break;
                    }
                }
                if(isSame){
                    sb.delete(sb.length() - bombLength, sb.length());
                }
            }
        }

        if(sb.length() == 0){
            System.out.println("FRULA");
        }else{
            System.out.println(sb.toString());
        }
    }
}
