import java.util.Arrays;
import java.util.Scanner;

public class CombinationTest1 {
	static int N, totalCnt, r;
	static int[] numbers, input;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		totalCnt = 0;
		
		input = new int[N];
		numbers = new int[r];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		comb(0, 0);
		System.out.println("총 경우의 수 : " + totalCnt);
	}
	
	static void comb(int cnt, int start) {
		if(cnt==r) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			comb(cnt+1, i+1);
		}
	}
}