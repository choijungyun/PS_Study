package BaekJoon;
import java.io.*;
import java.util.*;
/*
 * 다이나믹 프로그래밍
 * 부분문제가 겹치고 최적 부분 경로이기 때문에
 * 점화식 이용
 * dp[길이가 N인 오르막 수의 개수][마지막으로 사용한 수 j]
 *  = dp[길이가 N인 오르막수의 개수][마지막으로 사용한 수 j]
 *  + dp[길이가 N-1인 오르막수의 개수][마지막으로 사용한 수가 j이거나 작은수]
 * 
 */

public class 오르막수_11057 {
	public static int [][] dp = new int[1001][10];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 초기값 세팅
		for(int i=0; i<=9; i++) {
			dp[1][i] = 1;
		}
		//점화식 구현
		for(int i=2; i<=1000; i++) {
			for(int j=0; j<=9; j++) {
				for(int k=0; k<=j; k++) {
					dp[i][j] += (dp[i-1][j-k])%10007;
				}
			}
		}
		//오르막 수 구하기
		int ans=0;
		for(int i=0; i<=9; i++) {
			ans += dp[N][i];
		}
		
		System.out.println(ans%10007);
	}

}
