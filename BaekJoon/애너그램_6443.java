package BaekJoon;
import java.util.*;
import java.io.*;
/*
 * 문제 분류 - 백트래킹
 * 알파벳은 고정된 갯수가 있기때문에 이를 잘 이용할 것!
 * 굳이 메모리 늘리지 말것!
 */
public class 애너그램_6443 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			char [] ch = br.readLine().toCharArray();
			int [] alpha = new int[26];
			//알파벳 갯수 저장
			for(int j=0; j<ch.length; j++) {
				alpha[ch[j]-'a']++;
			}
			dfs(0, alpha, "", ch.length);
		
			
		}
		
	}
	public static void dfs(int L, int [] alpha, String ans, int size) {
		//원하는 문자열 길이가 되면 return
		if(L==size) {
			System.out.println(ans);
			return;
		}
		// alpha갯수만큼 26개 for문 돌면서
		for(int i=0; i<alpha.length; i++) {
			//사용할 수 있는 알파벳이 없으면 pass
			if(alpha[i]==0) continue;
			//사용할 수 있는 알파벳이 있으면 사용
			alpha[i]--;
			//문자열에 사용할 수 있는 알파벳 붙이기
			ans += String.valueOf(((char)(i+'a')));
			dfs(L+1, alpha, ans, size);
			//사용하지 않을 경우도 존재하기 때문에 마지막 알파벳 지우기
			ans = ans.substring(0, ans.length()-1);
			//사용안했으니깐 알파벳 갯수 돌려주기
			alpha[i]++;
		}
		
	}
	
	
}
	