package 삼성_모의;

import java.io.*;
import java.util.*;

public class 수영장_1952 {
	public static int [] money;
	public static int [] month;
	public static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			//이용권 가격
			money = new int[4];
			//이용계획
			month = new int[12];
			
			String [] s = br.readLine().split(" ");
			for(int i=0; i<4; i++) {
				money[i] = Integer.parseInt(s[i]);
			}
			ans = money[3];
			s = br.readLine().split(" ");
			for(int i=0; i<12; i++) {
				month[i] = Integer.parseInt(s[i]);
			}
			dfs(0, 0);
			System.out.println("#" + test_case + " " +ans);
		}

	}
	public static void dfs(int mon, int sum) {
		if(sum>ans)
			return;
		if(mon>=12) {
			ans = Math.min(sum, ans);
			return;
		}
		dfs(mon+1, sum+month[mon]*money[0]);
		dfs(mon+1, sum+money[1]);
		dfs(mon+3, sum+money[2]);
		
	}

}
