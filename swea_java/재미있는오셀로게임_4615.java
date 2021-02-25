package swea_java;
import java.util.*;
import java.io.*;
import java.io.*;

public class 재미있는오셀로게임_4615 {
	public static int [] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	public static int [] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			//보드 한변의 길이
			int N = Integer.parseInt(st.nextToken());
			//플레이어가 돌을 놓는 횟수
			int M = Integer.parseInt(st.nextToken());
			int [][] map = new int [N+1][N+1];
			//초기값 돌 놓기
			map[N/2][N/2] = 2;
			map[N/2+1][N/2] = 1;
			map[N/2+1][N/2+1] = 2;
			map[N/2][N/2+1] = 1;
			
			//돌 두기
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int color = Integer.parseInt(st.nextToken());
				//돌 놓기
				map[x][y] = color;
				
				//8방향으로 돌면서 가능한지 확인
				for(int j=0; j<8; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					//범위내에 있을 때까지
					while(nx>0 && ny>0 && nx<=N && ny<=N) {
						//움직였을 때 같은 색깔
						if(map[nx][ny]==color) {
							break;
						}
						//0이라면
						else if(map[nx][ny]==0) {
							break;
						}
						//다른 색깔이면 전진
						else {
							nx += dx[j];
							ny += dy[j];
						}
					}
					//같은 색이라면 돌 ~ 돌 사이 색깔 바꾸기
					if( (nx>0 && ny>0 && nx<=N && ny<=N) && map[nx][ny]==color){
						//돌이 놓여진 곳까지 거슬러 가기
						while (nx!=x || ny!=y) { 
							map[nx][ny] = color;
							nx -= dx[j];
							ny -= dy[j];
						}
						
					}	
					
				}
			}
			int w = 0;
			int b = 0;
			//다 돌면 돌 갯수 세기
			for(int k=1; k<=N; k++) {
				for(int l=1; l<=N; l++){
					if(map[k][l]==1)
						b+=1;
					else if(map[k][l]==2)
						w+=1;
				}
			}
			
			System.out.println("#" + test_case + " "+ b +" "+ w);
		}
				
		
	}

}
