package BaekJoon;
import java.util.*;
import java.io.*;

/*
 * 전위순회 중심으로 중위순회 서브트리 구성 -> 이분탐색 이용
 * 
 */
public class 트리_4256 {
	public static int N;
	public static int [] preorder;
	public static int [] inorder;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			preorder = new int[N];
			inorder = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				preorder[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				inorder[i] = Integer.parseInt(st.nextToken());
			}
			
			postorder(0, N, 0);
			System.out.println();
		}
		
	}
	//시작위치, 마지막 위치, 현재 위치 
	public static void postorder(int s, int e, int r) {
		for(int i=s; i<e; i++) {
			if(preorder[r]==inorder[i]) {
				//이분탐색
				//시작, 루트, pre위치
				postorder(s, i, r+1);
				postorder(i+1, e, r+i-s+1);
				System.out.print(preorder[r]+ " ");
			}
		}
	}

}
