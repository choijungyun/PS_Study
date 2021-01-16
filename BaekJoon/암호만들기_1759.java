package BaekJoon;
import java.io.*;
import java.util.*;

/*
 * ���� �ٸ� L���� ���ĺ� 
 * �ּ� �� ���� ���� + �ּ� �� ���� ����
 * ��ȣ�� ���ĺ� �����ϴ� ��
 * ������ ���� C����, ���ɼ� �ִ� ��ȣ���� ��� ���ϱ�
 * 
 * ����ϴ� �˰���?
 * - ���Ʈ����,��Ʈ��ŷ(��� ����� ���� ���غ���, �� ���ĺ� ���� ��)
 * - DFS(���ĺ� �� ������ �κ��� ä��, �ߺ��� ����, �����̿�)  
 * 
 * �ܰ躰 ����
 * 1. ������ ���ĺ� ����
 * 2. DFS�� �̿��ؼ� ���� �� �ִ� ��ȣ�� ����� ��
 * 3. ��������(���ϴ� ���ĺ� ���̸�ŭ ��������� ��)�� ���ϸ� ����,���� �˻�
 * 		���, �ƴ϶�� return
 * 
 */

public class ��ȣ�����_1759 {
	public static int L,C;
	public static String [] ch;
	public static String [] alpha;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		L = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		ch = new String[C];
		String s = br.readLine();
		alpha = s.split(" ");

		//1. ������ ���ĺ� ����
		Arrays.sort(alpha);
		//2. dfs�̿��ؼ� ���� �� �ִ� ��ȣ �����
		dfs(0,0);
	}
	
	public static void dfs(int len, int start) {
		//3. ��������
		if(len==L) {
			int mo = 0;
			int ja =0;
			String s = "";
			for(int i=0; i<len; i++) {
				//����, ���� ���� ����
				if(ch[i].equals("a") || ch[i].equals("e") || ch[i].equals("i") || ch[i].equals("o") || ch[i].equals("u")) {
					mo++;
				}
				else ja++;
				s+=ch[i];
			}
			if(mo>=1 && ja>=2) System.out.println(s);
			return;
		}
		
		for(int i=start; i<C; i++) {
			//ch�� �ش� ���ĺ� ���
			ch[len] = alpha[i];
			dfs(len+1, i+1);
		}
	
		
	}
}
