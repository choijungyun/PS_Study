package BaekJoon;
import java.util.*;
import java.io.*;


/*
 * ������ �˰���
 * : �״�� �۾��� �������� ������ �ذ��ϴ� ���
 * : Ư�����ؿ� ���� ������ �� ������� ó���ϴ� �˰���
 * : ���� N=1000000������ �־���
 *
 * ��, N�� ũ��� 1�̻� 10,000�����̰�, M�� ũ��� 1�̻� 100,000�����̴�.
 */

public class ��������_7571 {	
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