package BaekJoon;
import java.io.*;
import java.util.*;

/*
 * ������ �ִ� �� R*C
 * �ǹ��� �ִ� ��쿡 �������� ���� �� ����
 * �� ĭ�� ������, ������ �� �밢��, ������ �Ʒ� �밢������ ���� ����
 * �� ĭ�� ������ �������� �ϳ�
 * �������� ������ �����ϴ� ������ ������ �ִ� ���� 
 * '.'�� ��ĭ, 'x'�� �ǹ�
 * 
 * ��� �˰���?
 * - ���Ʈ����, ��Ʈ��ŷ
 * (��� ����� ���� �ϸ� �ð����⵵�� Ŀ���� ������ �ȵǴ� ���� ���̻� �˻� ���� ����)
 * 
 *  - dfs(�� �� �ֳ�? ����?�� üũ�ϱ� ���� ���)
 * 
 * ����
 * 1. R*C�� ���� ���� ����
 * 2. 0�� ���� ���� (��� �� �� �� �غ���-> ������������ �����ϴ� ��)
 * 3. dfs����(�������� ������ �� �� �ִ��� �������� �ľ��ϱ� ����)
 *    3-1) �̵�,���� �鸮�� ���̶�� x�� ���� ü���� (��δ� ��ĥ �� ���⿡ �� ���� �湮�ϱ� ����)
 *    3-2) �������� -> ������ �� ��� ans+1���ֱ�
 * 4. 3�� �ึ�� �ݺ�
 */

public class ����_3109 {
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
		
		//1. R*C�� ���� ���� ����
		for(int i=0; i<R; i++) {
			String [] s = br.readLine().split("");
			for(int j=0; j<C; j++) {
				map[i][j] = s[j]; 
			}
		}
		
		//2. 0�� ���� ����(��� �� �� ���غ��� -> ������������ �����ϴ� ��)
		for(int i=0; i<R; i++) {
			//3. dfs����(�������� ������ �� �� �ִ��� �������� �ľ��ϱ� ����)
			if(dfs(i,0)) ans++;
		}
		System.out.println(ans);
	}
	
	public static boolean dfs(int x, int y) {
		if(y==C-1) {
			//3-2) ���� ����
			return true;
		}
		//3-1) �̵�, �鸮�� �� x�� �ٲٱ� + ��Ʈ��ŷ
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
