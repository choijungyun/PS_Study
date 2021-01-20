package BaekJoon;
import java.util.*;
import java.io.*;


/*
 * 스위핑 알고리즘
 * : 그대로 휩쓸고 지나가며 문제를 해결하는 방식
 * : 특정기준에 따라 정렬한 후 순서대로 처리하는 알고리즘
 * : 보통 N=1000000정도가 주어짐
 *
 * 단, N의 크기는 1이상 10,000이하이고, M의 크기는 1이상 100,000이하이다.
 */

public class 점모으기_7571 {	
	public static int N,M;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		int ans = 0;
		int x_sum = 0;
		int y_sum = 0;
		int [] x_arr = new int[M];
		int [] y_arr = new int[M];
		
		for(int i=0; i<M; i++) {
			str = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());
			x_arr[i] = x;
			y_arr[i] = y;

		}

		Arrays.sort(x_arr);
		Arrays.sort(y_arr);
		
		int x_mid = x_arr[M/2];
		int y_mid = y_arr[M/2];
		
		for(int i=0; i<M; i++) {
			ans += Math.abs(x_arr[i]-x_mid);
			ans += Math.abs(y_arr[i]-y_mid);
		}
		
		System.out.println(ans);
	}
}