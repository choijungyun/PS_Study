package BaekJoon;
import java.util.*;
import java.io.*;

public class 후위표기식_1918 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [] token = br.readLine().toCharArray();
		//우선순위 저장해두기
		HashMap <Character, Integer> hs = new HashMap<Character, Integer>();
		hs.put('(', 0);
		hs.put('+', 1);
		hs.put('-', 1);
		hs.put('*', 2);
		hs.put('/', 2);
		Stack <Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		//토큰 확인
		for(int i=0; i<token.length; i++) {
			//열린 괄호, 피연산자라면
			if(token[i]=='(')
				stack.add(token[i]);
			//피연산자라면 출력
			else if(token[i]>='A' && token[i]<='Z')
				sb.append(token[i]);
			//닫힌괄호라면
			else if(token[i]==')') {
				//열린괄호가 나올 때 까지 pop
				while(stack.peek()!='(') {
					sb.append(stack.peek());
					stack.pop();
				}
				//열린괄호 pop
				stack.pop();
			}
			//연산자가 들어오면
			else {
				//스택이 비어있으면
				if(stack.isEmpty()) 
					stack.add(token[i]);
				else {
					//우선 순위 비교
					while(!stack.isEmpty() && hs.get(stack.peek())>=hs.get(token[i])) {
						sb.append(stack.peek());
						stack.pop();
					}
					stack.add(token[i]);
				}
				
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.peek());
			stack.pop();
		}
		
		System.out.println(sb);
		
	}

}
