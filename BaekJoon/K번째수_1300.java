package BaekJoon;
import java.io.*;
import java.util.*;

public class K번째수_1300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		//이분 탐색을 통해 k의 인덱스에 해당하는 값 출력
		int start = 1;
		int end = K;
		int result = -1;
		int mid;
		while(start<=end) {
			int cnt = 0;
			mid = (start+end)/2;
			// A[i][j]에서, i행에 속한 숫자들은 i*j이므로 모두 i의 배수 이다.
			// mid/i가 1,2,3,4,5,....이런식으로 구성됨
			// 따라서 결국 cnt
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
