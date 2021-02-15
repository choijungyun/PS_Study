package BaekJoon;

import java.io.*;
import java.util.*;

public class 파이프옮기기1_17070 {
	public static int [][] map;
	public static int ans,N;
	public static boolean [][] visited;
	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//집의 크기
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		//집 상태 받기, 빈칸은 0, 벽은 1
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		//초기값 방문
		visited[1][1] = true;
		visited[1][2] = true;
		//가로 방향부터 시작
		dfs(1, 2, 1);
		System.out.println(ans);
	}
	
	//dir 가로 : 1, 세로 : 2, 대각선 :3
	public static void dfs(int x, int y, int dir) {
		//N,N에 도달하면 ans+1
		if(x==N && y==N) {
			ans += 1;
			return;
		}
		
		//가로의 경우
		if(dir==1) {
			//가로 가능?
			if(isPossible(x, y+1)) {
				visited[x][y+1] = true;
				dfs(x, y+1, 1);
				visited[x][y+1] = false;
			}
			//대각선 가능?
			if(isPossible(x, y+1) && isPossible(x+1, y) && isPossible(x+1, y+1)) {
				visited[x][y+1] = true;
				visited[x+1][y] = true;
				visited[x+1][y+1] = true;
				dfs(x+1, y+1, 3);
				visited[x][y+1] = false;
				visited[x+1][y] = false;
				visited[x+1][y+1] = false;
			}
		}
		//세로의 경우?
		if(dir==2) {
			//세로 가능?
			if(isPossible(x+1, y)) {
				visited[x+1][y] = true;
				dfs(x+1, y, 2);
				visited[x+1][y] = false;
			}
			//대각선 가능?
			if(isPossible(x, y+1) && isPossible(x+1, y) && isPossible(x+1, y+1)) {
				visited[x][y+1] = true;
				visited[x+1][y] = true;
				visited[x+1][y+1] = true;
				dfs(x+1, y+1, 3);
				visited[x][y+1] = false;
				visited[x+1][y] = false;
				visited[x+1][y+1] = false;
			}
		}
		
		//대각선의 경우?
		if(dir==3) {
			//가로
			if(isPossible(x, y+1)) {
				visited[x][y+1] = true;
				dfs(x, y+1, 1);
				visited[x][y+1] = false;
			}
			//세로 가능?
			if(isPossible(x+1, y)) {
				visited[x+1][y] = true;
				dfs(x+1, y, 2);
				visited[x+1][y] = false;
			}
			//대각선 가능?
			if(isPossible(x, y+1) && isPossible(x+1, y) && isPossible(x+1, y+1)) {
				visited[x][y+1] = true;
				visited[x+1][y] = true;
				visited[x+1][y+1] = true;
				dfs(x+1, y+1, 3);
				visited[x][y+1] = false;
				visited[x+1][y] = false;
				visited[x+1][y+1] = false;
			}
		}
	}
	
	//범위체크
	public static boolean isPossible(int x, int y) {
		if(x<=0 || y<=0 || x>N || y>N) return false;
		//벽인경우
		if(map[x][y]==1) return false;
		//이미 방문한 경우
		if(visited[x][y]) {
			System.out.println(x + " " + y);
			return false;
		}
		return true;
	}


}
