package swea_java;
import java.util.*;
import java.io.*;

public class 행렬찾기_1258 {
	public static int [][] map;
	public static boolean [][] visited;
	public static int N,idx;
	public static State [] tmp;
	public static State [] state;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			tmp = new State[N];
			idx =0;
			for(int i=0; i<N; i++) {
				String [] s = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]!=0 && !visited[i][j]) {
						visited[i][j] = true;
						search(i,j);
					}
				}
			}
			state = new State[idx];		
			for(int i=0; i<idx; i++) {
				state[i] = tmp[i];
			}
			Arrays.sort(state);
			System.out.print("#" + test_case +" " + idx + " ");
			for(int i=0; i<idx; i++) {
				System.out.print(state[i].x + " " + state[i].y + " ");
			}
			System.out.println();
			
		}
	}
	
	public static void search(int x, int y) {
		int dx = 1;
		int dy = 1;
		for(int i=y+1; i<N; i++) {
			if(map[x][i]!=0 && !visited[x][i]) {
				visited[x][i] = true;
				map[x][i] = 0;
				dy++;
			}
			else break;
		}
		for(int i=x+1; i<N; i++) {
			if(map[i][y]!=0 && !visited[i][y]) {
				visited[i][y] = true;
				map[i][y] = 0;
				dx++;
			}
			else break;
		}
		
		for(int i=x+1; i<x+dx; i++) {
			for(int j=y+1; j<y+dy; j++) {
				if(map[i][j]!=0)
				visited[i][j] = true;
			}
		}

		
		tmp[idx++] = new State(dx,dy);
	}

}
class State implements Comparable<State>{
	int x, y;
	
	State(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(State s) {
		if(x*y==s.x*s.y) {
			return x-s.x;
		} 
		return ((x*y)-(s.x*s.y));
	}
	
}