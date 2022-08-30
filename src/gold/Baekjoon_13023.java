package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_13023 {
//	static Node[] network;
	static List<Integer>[] network;
	static boolean[] isVisited;
	static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 사람의 수
		int M = Integer.parseInt(st.nextToken());	// 친구 관계 수
		
//		network = new Node[N];
		network = new ArrayList[N];
		isVisited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			network[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			network[a].add(b);
			network[b].add(a);
//			network[a] = new Node(b, network[a]);
//			network[b] = new Node(b, network[b]);
		}
		
		for(int i = 0; i < N; i++) {
			if(result == 0){
				search(i, 0);
			}
			if(result == 1){
				System.out.println(1);
				System.exit(0);
			}
		}
		System.out.println(result);
	}
	
	private static void search(int x, int cnt) {
		if(result == 1) return; 
		
		if(cnt == 5) {
			result = 1;
			return;
		}
		
		for(int temp : network[x]) {
			if(isVisited[temp]) continue;
			isVisited[temp] = true;
			search(temp, cnt+1);
			isVisited[temp] = false;
		}
	}	
}

