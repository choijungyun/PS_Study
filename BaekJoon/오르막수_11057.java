package BaekJoon;
import java.io.*;
import java.util.*;
/*
 * ���̳��� ���α׷���
 * �κй����� ��ġ�� ���� �κ� ����̱� ������
 * ��ȭ�� �̿�
 * dp[���̰� N�� ������ ���� ����][���������� ����� �� j]
 *  = dp[���̰� N�� ���������� ����][���������� ����� �� j]
 *  + dp[���̰� N-1�� ���������� ����][���������� ����� ���� j�̰ų� ������]
 * 
 */

public class ��������_11057 {
	public static int [][] dp = new int[1001][10];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// �ʱⰪ ����
		for(int i=0; i<=9; i++) {
			dp[1][i] = 1;
		}
		//��ȭ�� ����
		for(int i=2; i<=1000; i++) {
			for(int j=0; j<=9; j++) {
				for(int k=0; k<=j; k++) {
					dp[i][j] += (dp[i-1][j-k])%10007;
				}
			}
		}
		//������ �� ���ϱ�
		int ans=0;
		for(int i=0; i<=9; i++) {
			ans += dp[N][i];
		}
		
		System.out.println(ans%10007);
	}

}
