package BaekJoon;
import java.io.*;
import java.util.*;

/*
 * 서로 다른 L개의 알파벳 
 * 최소 한 개의 모음 + 최소 두 개의 자음
 * 암호는 알파벳 증가하는 순
 * 문자의 종류 C가지, 가능성 있는 암호들을 모두 구하기
 * 
 * 사용하는 알고리즘?
 * - 브루트포스,백트래킹(모든 경우의 수를 다해본다, 단 알파벳 증가 순)
 * - DFS(알파벳 별 가능한 부분을 채택, 중복값 제외, 조합이용)  
 * 
 * 단계별 구현
 * 1. 들어오는 알파벳 정렬
 * 2. DFS를 이용해서 만들 수 있는 암호를 만들어 봄
 * 3. 종결조건(원하는 알파벳 길이만큼 만들어졌을 때)에 달하면 자음,모음 검사
 * 		출력, 아니라면 return
 * 
 */

public class 암호만들기_1759 {
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

		//1. 들어오는 알파벳 정렬
		Arrays.sort(alpha);
		//2. dfs이용해서 만들 수 있는 암호 만들기
		dfs(0,0);
	}
	
	public static void dfs(int len, int start) {
		//3. 종결조건
		if(len==L) {
			int mo = 0;
			int ja =0;
			String s = "";
			for(int i=0; i<len; i++) {
				//모음, 자음 개수 세기
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
			//ch에 해당 알파벳 담기
			ch[len] = alpha[i];
			dfs(len+1, i+1);
		}
	
		
	}
}
