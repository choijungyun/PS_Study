package BaekJoon;
import java.util.*;
import java.io.*;

/*
 * 1. 주어진 문자열에 해당하는 알파벳을 모두 센다.
 * 2. 주어진 문자열을 바탕으로 만들 수 있는 모든 알파벳을 만든다.(dfs이용)
 * 3. 각 문자열마다 행운의 문자열을 센다.
 * 
 */

public class 행운의문자열_1342 {
	//행운의 문자열 갯수
	public static int answer = 0;
	//등장하는 알파벳을 저장하기 위함
	public static int [] alpha;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char [] c = s.toCharArray();
		alpha = new int[27];
		//등장하는 알파벳 모두 저장
		for(int i=0; i<c.length; i++) {
			alpha[c[i]-'a']+=1;
		}
//		System.out.println(s);
		//dfs를 이용해 만들 수 있는 모든 문자열 만들기
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
