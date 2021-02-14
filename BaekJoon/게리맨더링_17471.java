package BaekJoon;
import java.io.*;
import java.util.*;

public class �Ը��Ǵ���_17471 {
	public static int N;
	public static int [] population;
	public static int [] ch;
	public static int [][] connect;
	public static int ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//������ ����
		N = Integer.parseInt(br.readLine());
		//������ �α���
		population = new int [N+1];
		//������ ���� ����
		connect = new int[N+1][N+1];
		
		//������ �α���
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		for(int i=1; i<=N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		//������ ���� ����
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				int con = Integer.parseInt(st.nextToken());
				connect[i][con] = connect[con][i] = 1;
			}
		}
		//�ִ� �α����� �ʱ�ȭ
		ans = 2147000000;
		//dfs 1~N-1������ �����ϱ�
		for(int i=1; i<N; i++) {
			ch = new int[i];
			dfs(0, 1, i);
		}
		
		if(ans==2147000000) ans = -1;
		
		System.out.println(ans);
		
	}
	
	public static void dfs(int L, int start, int size) {
		//�� �� ���
		if(L==size) {
			//ch�迭 �ѱ��
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
		//���õȰ� ī��Ʈ ������ ����, N<=10
		int [] cnt = new int[11];
		for(int i=0; i<ch.length; i++) {
			cnt[ch[i]] = 1;
		}
		
		//ch�� �ش��ϴ� �� ����
		boolean [] visited = new boolean[N+1];
		Queue <Integer> q = new LinkedList<>();
		//�ʱⰪ
		visited[ch[0]] = true;
		q.add(ch[0]);
		//����� ��� ���� ����
		while(!q.isEmpty()) {
			int v = q.peek();
			q.poll();
			for(int i=1; i<=N; i++) {
				if(visited[i]) continue;
				if(cnt[i]!=1) continue;
				//����Ǿ� �ִٸ� ť�� �ְ� �湮 ó��
				if(connect[v][i]==1 || connect[i][v]==1) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
		
		//�湮ó���� ���� ch�� ��ġ�ϴ� �� Ȯ��
		for(int i=0; i<ch.length; i++) {
			if(!visited[ch[i]]) return;
		}
		
		//��ġ�ϸ� �������͵��� ������� Ȯ��
		visited = new boolean[N+1];
		q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			if(cnt[i]!=1) {
				q.add(i);
				visited[i] = true;
				break;
			}
		}
		//����� ���� ����
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
		
		//�湮ó���� ���� �������� ��ġ�ϴ��� Ȯ��
		for(int i=1; i<=N; i++) {
			//�ٸ����̱⿡ �Ű� ��
			if(cnt[i]==1) continue;
			//�湮 ���Ѱ� ������ �ȵ�
			if(!visited[i]) return;
		}
		
		
		//��� ��� �����
		//�ΰ��� ���ű��� �α������� �ּڰ�
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
