package BaekJoon;
import java.io.*;
import java.util.*;

public class 게리맨더링_17471 {
	public static int N;
	public static int [] population;
	public static int [] ch;
	public static int [][] connect;
	public static int ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//구역의 개수
		N = Integer.parseInt(br.readLine());
		//구역별 인구수
		population = new int [N+1];
		//구역별 연결 관계
		connect = new int[N+1][N+1];
		
		//구역별 인구수
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		for(int i=1; i<=N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		//구역별 연결 관계
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				int con = Integer.parseInt(st.nextToken());
				connect[i][con] = connect[con][i] = 1;
			}
		}
		//최대 인구차로 초기화
		ans = 2147000000;
		//dfs 1~N-1개까지 선택하기
		for(int i=1; i<N; i++) {
			ch = new int[i];
			dfs(0, 1, i);
		}
		
		if(ans==2147000000) ans = -1;
		
		System.out.println(ans);
		
	}
	
	public static void dfs(int L, int start, int size) {
		//다 고른 경우
		if(L==size) {
			//ch배열 넘기기
			solve(ch);
			
		}
		else {
			for(int i=start; i<=N; i++) {
				ch[L] = i;
				dfs(L+1, i+1, size);
			}
		}
	}
	
	
	public static void solve(int [] ch) {
		//선택된것 카운트 변수로 정리, N<=10
		int [] cnt = new int[11];
		for(int i=0; i<ch.length; i++) {
			cnt[ch[i]] = 1;
		}
		
		//ch에 해당하는 것 연결
		boolean [] visited = new boolean[N+1];
		Queue <Integer> q = new LinkedList<>();
		//초기값
		visited[ch[0]] = true;
		q.add(ch[0]);
		//연결된 모든 정점 돌기
		while(!q.isEmpty()) {
			int v = q.peek();
			q.poll();
			for(int i=1; i<=N; i++) {
				if(visited[i]) continue;
				if(cnt[i]!=1) continue;
				//연결되어 있다면 큐에 넣고 방문 처리
				if(connect[v][i]==1 || connect[i][v]==1) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
		
		//방문처리한 것이 ch와 일치하는 지 확인
		for(int i=0; i<ch.length; i++) {
			if(!visited[ch[i]]) return;
		}
		
		//일치하면 나머지것들의 연결상태 확인
		visited = new boolean[N+1];
		q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			if(cnt[i]!=1) {
				q.add(i);
				visited[i] = true;
				break;
			}
		}
		//연결된 정점 돌기
		while(!q.isEmpty()) {
			int v = q.peek();
			q.poll();
			for(int i=1; i<=N; i++) {
				if(visited[i]) continue;
				if(cnt[i]==1) continue;
				if(connect[v][i]==1 || connect[i][v]==1) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
		//방문처리한 것이 나머지와 일치하는지 확인
		for(int i=1; i<=N; i++) {
			//다른쪽이기에 신경 노
			if(cnt[i]==1) continue;
			//방문 안한게 있으면 안됨
			if(!visited[i]) return;
		}
		
		
		//모든 경우 통과시
		//두개의 선거구의 인구차이의 최솟값
		int gu1 = 0;
		int gu2 = 0;
		for(int i=1; i<=N; i++) {
			if(cnt[i]==1) {
				gu1 += population[i];
			}
			else gu2 += population[i];
		}
		
		ans = Math.min(ans, Math.abs(gu1-gu2));

	}
	
}
