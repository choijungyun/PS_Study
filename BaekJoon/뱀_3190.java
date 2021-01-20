package BaekJoon;

import java.io.*;
import java.util.*;

/*
 * 1. 뱀상태저장
 * 2. 방향 바꿈?
 * 3. 방향 따라 움직임 
 * 
 * 사과1 뱀2
 */

public class 뱀_3190 {
	public static int N;
	public static int [][] map;
	public static int [] dx = {0,1,0,-1};
	public static int [] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		int K = Integer.parseInt(br.readLine());
		Queue <dirState> sq = new LinkedList<>();
		Deque <State> snake = new ArrayDeque<>();
		
		//사과 채우기
		for(int i=0; i<K; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int ap_x = Integer.parseInt(str.nextToken());
			int ap_y = Integer.parseInt(str.nextToken());
			
			map[ap_x][ap_y] = 1; 
		}
		
		int L = Integer.parseInt(br.readLine());
		
		//뱀 방향 부분 큐에 저장
		for(int i=0; i<L; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(str.nextToken());
			String dir = str.nextToken();
			sq.add(new dirState(t, dir));
		}
		
		//처음 뱀 시작
		map[1][1] = 2;
		int snake_dir = 0;
		snake.add(new State(1,1));
		int time = 0;
		
		while(!snake.isEmpty()) {
			int s_x = snake.peekFirst().x;
			int s_y = snake.peekFirst().y;
			
			time++;
			//방향에 따라 움직이기
			s_x += dx[snake_dir];
			s_y += dy[snake_dir];
			
			//벽 부딪히면 중단
			if(s_x<1 || s_y<1 || s_x>N || s_y>N) break;
			//자기자신 부딪히면 중단
			if(map[s_x][s_y]==2) break;
			
			//중단 되지 않으면 전진
			snake.addFirst(new State(s_x, s_y));
			//사과가 없으면 꼬리 자르기
			if(map[s_x][s_y]!=1) {
				int del_x = snake.peekLast().x;
				int del_y = snake.peekLast().y;
				map[del_x][del_y] = 0;
				snake.pollLast();
			}
			map[s_x][s_y] = 2;
			//방향 바꾸는 시간과 일치한지 확인
			if(!sq.isEmpty() && time==sq.peek().time) {
				if(sq.peek().dir.equals("D")) {
					//오른쪽 90도
					snake_dir = (snake_dir+1)%4;
				}
				else {
					//왼쪽 90도
					snake_dir = (snake_dir+3)%4;
				}
				sq.poll();
			}
		}
		
		System.out.println(time);
		
		
	}
}

class dirState{
	int time;
	String dir;
	
	dirState(int time, String dir){
		this.time = time;
		this.dir = dir;
	}
}

class State{
	int x, y;
	
	State(int x, int y){
		this.x = x;
		this.y = y;
	}
}