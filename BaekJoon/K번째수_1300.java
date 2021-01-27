package BaekJoon;
import java.io.*;
import java.util.*;

public class K��°��_1300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		//�̺� Ž���� ���� k�� �ε����� �ش��ϴ� �� ���
		int start = 1;
		int end = K;
		int result = -1;
		int mid;
		while(start<=end) {
			int cnt = 0;
			mid = (start+end)/2;
			// A[i][j]����, i�࿡ ���� ���ڵ��� i*j�̹Ƿ� ��� i�� ��� �̴�.
			// mid/i�� 1,2,3,4,5,....�̷������� ������
			// ���� �ᱹ cnt
			for(int i=1; i<=N; i++) {
				cnt += Math.min(mid/i, N);
			}
			if(cnt<K)
				start = mid+1;
			else {
				result = mid;
				end = mid -1;
			}
			
		}
		
		System.out.println(result);
		
	}

}
