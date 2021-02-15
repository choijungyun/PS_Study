package BaekJoon;

import java.io.*;
import java.util.*;

public class �������ű��1_17070 {
	public static int [][] map;
	public static int ans,N;
	public static boolean [][] visited;
	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//���� ũ��
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		//�� ���� �ޱ�, ��ĭ�� 0, ���� 1
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		//�ʱⰪ �湮
		visited[1][1] = true;
		visited[1][2] = true;
		//���� ������� ����
		dfs(1, 2, 1);
		System.out.println(ans);
	}
	
	//dir ���� : 1, ���� : 2, �밢�� :3
	public static void dfs(int x, int y, int dir) {
		//N,N�� �����ϸ� ans+1
		if(x==N && y==N) {
			ans += 1;
			return;
		}
		
		//������ ���
		if(dir==1) {
			//���� ����?
			if(isPossible(x, y+1)) {
				visited[x][y+1] = true;
				dfs(x, y+1, 1);
				visited[x][y+1] = false;
			}
			//�밢�� ����?
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
		//������ ���?
		if(dir==2) {
			//���� ����?
			if(isPossible(x+1, y)) {
				visited[x+1][y] = true;
				dfs(x+1, y, 2);
				visited[x+1][y] = false;
			}
			//�밢�� ����?
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
		
		//�밢���� ���?
		if(dir==3) {
			//����
			if(isPossible(x, y+1)) {
				visited[x][y+1] = true;
				dfs(x, y+1, 1);
				visited[x][y+1] = false;
			}
			//���� ����?
			if(isPossible(x+1, y)) {
				visited[x+1][y] = true;
				dfs(x+1, y, 2);
				visited[x+1][y] = false;
			}
			//�밢�� ����?
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
	
	//����üũ
	public static boolean isPossible(int x, int y) {
		if(x<=0 || y<=0 || x>N || y>N) return false;
		//���ΰ��
		if(map[x][y]==1) return false;
		//�̹� �湮�� ���
		if(visited[x][y]) {
			System.out.println(x + " " + y);
			return false;
		}
		return true;
	}


}
