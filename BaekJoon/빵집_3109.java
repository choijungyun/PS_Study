package BaekJoon;
import java.io.*;
import java.util.*;

/*
 * 빵집이 있는 곳 R*C
 * 건물이 있는 경우에 파이프를 놓을 수 없다
 * 각 칸은 오른쪽, 오른쪽 위 대각선, 오른쪽 아래 대각선으로 연결 가능
 * 각 칸을 지나는 파이프는 하나
 * 가스관과 빵집을 연결하는 파이프 라인의 최대 개수 
 * '.'는 빈칸, 'x'는 건물
 * 
 * 사용 알고리즘?
 * - 브루트포스, 백트래킹
 * (모든 경우의 수를 하면 시간복잡도가 커지기 때문에 안되는 경우는 더이상 검사 하지 말기)
 * 
 *  - dfs(갈 수 있냐? 없냐?를 체크하기 위해 사용)
 * 
 * 구현
 * 1. R*C에 현재 상태 저장
 * 2. 0열 부터 시작 (모든 행 별 다 해보기-> 파이프라인이 시작하는 곳)
 * 3. dfs실행(파이프가 끝까지 갈 수 있는지 없는지를 파악하기 위해)
 *    3-1) 이동,현재 들리는 곳이라면 x로 상태 체인지 (경로는 겹칠 수 없기에 한 번만 방문하기 위함)
 *    3-2) 종결조건 -> 끝까지 간 경우 ans+1해주기
 * 4. 3번 행마다 반복
 */

public class 빵집_3109 {
	public static String [][] map;
	public static int R,C,ans;
	public static int [] dx = {-1,0,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		map = new String[R][C];
		ans = 0;
		
		//1. R*C에 현재 상태 저장
		for(int i=0; i<R; i++) {
			String [] s = br.readLine().split("");
			for(int j=0; j<C; j++) {
				map[i][j] = s[j]; 
			}
		}
		
		//2. 0열 부터 시작(모든 행 별 다해보기 -> 파이프라인이 시작하는 곳)
		for(int i=0; i<R; i++) {
			//3. dfs실행(파이프가 끝까지 갈 수 있는지 없는지를 파악하기 위해)
			if(dfs(i,0)) ans++;
		}
		System.out.println(ans);
	}
	
	public static boolean dfs(int x, int y) {
		if(y==C-1) {
			//3-2) 종결 조건
			return true;
		}
		//3-1) 이동, 들리는 곳 x로 바꾸기 + 백트래킹
		for(int i=0; i<3; i++) {
			int nx = x + dx[i];
			int ny = y + 1;
			if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
			if(map[nx][ny].equals("x")) continue;
			map[nx][ny] = "x";
			if(dfs(nx, ny)) return true;
		}
		return false;
	}
	
}
