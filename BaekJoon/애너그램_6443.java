package BaekJoon;
import java.util.*;
import java.io.*;
/*
 * ���� �з� - ��Ʈ��ŷ
 * ���ĺ��� ������ ������ �ֱ⶧���� �̸� �� �̿��� ��!
 * ���� �޸� �ø��� ����!
 */
public class �ֳʱ׷�_6443 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			char [] ch = br.readLine().toCharArray();
			int [] alpha = new int[26];
			//���ĺ� ���� ����
			for(int j=0; j<ch.length; j++) {
				alpha[ch[j]-'a']++;
			}
			dfs(0, alpha, "", ch.length);
		
			
		}
		
	}
	public static void dfs(int L, int [] alpha, String ans, int size) {
		//���ϴ� ���ڿ� ���̰� �Ǹ� return
		if(L==size) {
			System.out.println(ans);
			return;
		}
		// alpha������ŭ 26�� for�� ���鼭
		for(int i=0; i<alpha.length; i++) {
			//����� �� �ִ� ���ĺ��� ������ pass
			if(alpha[i]==0) continue;
			//����� �� �ִ� ���ĺ��� ������ ���
			alpha[i]--;
			//���ڿ��� ����� �� �ִ� ���ĺ� ���̱�
			ans += String.valueOf(((char)(i+'a')));
			dfs(L+1, alpha, ans, size);
			//������� ���� ��쵵 �����ϱ� ������ ������ ���ĺ� �����
			ans = ans.substring(0, ans.length()-1);
			//���������ϱ� ���ĺ� ���� �����ֱ�
			alpha[i]++;
		}
		
	}
	
	
}
	