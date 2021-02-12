package datastructure;
import java.util.*;
import java.io.*;


public class 괄호의값_2504 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		Stack <String> stack = new Stack<>();
		int f_open = 0, f_close=0;
		int s_open = 0, s_close=0;
		boolean right = true;
		//stack에 담아가며 확인
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			//열린괄호면 add
			if(ch=='(' || ch=='[') {
				if(ch=='(') f_open++;
				else s_open++;
				stack.add(Character.toString(s.charAt(i)));
			}
			//닫힌괄호면 
			else if(ch==')') {
				f_close++;
				//stack에 아무것도 없으면 올바르지 않은 문자열
				if(stack.isEmpty()) {
					right = false;
					break;
				}
				//peek과 비교
				//짝이 맞으면 pop하고 숫자넣기
				if(stack.peek().equals("(")) {
					stack.pop();
					stack.add("2");
				}
				//숫자라면 열린괄호 나올때까지 pop(숫자는 push)하면서 들어감
				else {
					int sum = 0;
					while(!stack.isEmpty()) {
						if(stack.peek().equals("(")) {
							//숫자 빼주기
							stack.pop();
							//열린괄호는 *2를 해준다.
							sum *= 2;
							//값을 다시 넣어주기
							stack.add(String.valueOf(sum));
							break;
						}
						//다른괄호열의 열린괄호가 중간에 나오면 중단.
						else if(stack.peek().equals("[")) {
							right = false;
							break;
						}
						//숫자인 경우
						else {
							//연속해서 숫자가 나온 경우
							sum += Integer.parseInt(stack.peek());
							stack.pop();
						}
					}
					
				}
				
			}
			else if(ch==']') {
				//stack에 아무것도 없으면 올바르지 않은 문자열
				s_close++;
				if(stack.isEmpty()) {
					right = false;
					break;
				}
				//peek과 비교
				//짝이 맞으면 pop하고 숫자넣기
				if(stack.peek().equals("[")) {
					stack.pop();
					stack.add("3");
				}
				//숫자라면 열린괄호 나올때까지 pop(숫자는 push)하면서 들어감
				else {
					int sum = 0;
					while(!stack.empty()) {
						if(stack.peek().equals("[")) {
							stack.pop();
							sum *= 3;
							stack.add(String.valueOf(sum));
							break;
						}
						//다른괄호열의 열린괄호가 중간에 나오면 중단.
						else if(stack.peek().equals("(")) {
							right = false;
							break;
						}
						//숫자인 경우
						else {
							sum += Integer.parseInt(stack.peek());
							stack.pop();		
						}
					}
					
				}
			}
		
		}
		
		int ans =0;
		//올바르지 않은 문자열이라면
		if(!right || f_open!=f_close || s_open!=s_close) System.out.println("0");
		else {
			while(!stack.isEmpty()) {
				ans += Integer.parseInt(stack.peek());
				stack.pop();
			}
			System.out.println(ans);
		}
		
	}
}
