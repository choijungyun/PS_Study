package 삼성_모의;
import java.util.*;
import java.io.*;

public class 숫자만들기_4008 {
	public static int N, max_val, min_val;
	public static int [] op;
	public static int [] numbers;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			op = new int[4];
			numbers = new int[N];
			max_val = -2147000000;
			min_val = 2147000000;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			dfs(1, numbers[0]);
			System.out.println("#" + test_case + " " + (max_val-min_val));
		}
	}
	public static void dfs(int L, int sum) {
		if(L==N) {
			max_val = Math.max(max_val, sum);
			min_val = Math.min(min_val, sum);
			return;
		}
		if(op[0]>0) {
			op[0]-=1;
			dfs(L+1, sum+numbers[L]);
			op[0]+=1;
		}
		if(op[1]>0) {
			op[1]-=1;
			dfs(L+1, sum-numbers[L]);
			op[1]+=1;
		}
		if(op[2]>0) {
			op[2]-=1;
			dfs(L+1, sum*numbers[L]);
			op[2]+=1;
		}
		if(op[3]>0) {
			op[3]-=1;
			dfs(L+1, sum/numbers[L]);
			op[3]+=1;
		}
	}

}
