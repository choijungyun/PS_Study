package BaekJoon;
import java.util.*;
import java.io.*;

/*
 * 1. �־��� ���ڿ��� �ش��ϴ� ���ĺ��� ��� ����.
 * 2. �־��� ���ڿ��� �������� ���� �� �ִ� ��� ���ĺ��� �����.(dfs�̿�)
 * 3. �� ���ڿ����� ����� ���ڿ��� ����.
 * 
 */

public class ����ǹ��ڿ�_1342 {
	//����� ���ڿ� ����
	public static int answer = 0;
	//�����ϴ� ���ĺ��� �����ϱ� ����
	public static int [] alpha;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char [] c = s.toCharArray();
		alpha = new int[27];
		//�����ϴ� ���ĺ� ��� ����
		for(int i=0; i<c.length; i++) {
			alpha[c[i]-'a']+=1;
		}
//		System.out.println(s);
		//dfs�� �̿��� ���� �� �ִ� ��� ���ڿ� �����
		dfs(0, s.length(), "");
		System.out.println(answer);
	}
	
	public static void dfs(int L, int len, String s) {
		if(L==len) {
			if(isLucky(s))
				answer++;
			return;
		}
		for(int i=0; i<26; i++) {
			if(alpha[i]==0) continue;
			alpha[i]--;
			s += String.valueOf((char)(i+'a'));
			dfs(L+1, len, s);
			s = s.substring(0, s.length()-1);
			alpha[i]++;
		}
	}
	
	public static boolean isLucky(String s) {
		char cur = s.charAt(0);
		for(int i=1; i<s.length(); i++) {
			char next = s.charAt(i);
			if(cur==next) return false;
			cur = next;
		}
		return true;
	}

}
