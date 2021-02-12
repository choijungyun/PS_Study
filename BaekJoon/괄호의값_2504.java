package datastructure;
import java.util.*;
import java.io.*;


public class ��ȣ�ǰ�_2504 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		Stack <String> stack = new Stack<>();
		int f_open = 0, f_close=0;
		int s_open = 0, s_close=0;
		boolean right = true;
		//stack�� ��ư��� Ȯ��
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			//������ȣ�� add
			if(ch=='(' || ch=='[') {
				if(ch=='(') f_open++;
				else s_open++;
				stack.add(Character.toString(s.charAt(i)));
			}
			//������ȣ�� 
			else if(ch==')') {
				f_close++;
				//stack�� �ƹ��͵� ������ �ùٸ��� ���� ���ڿ�
				if(stack.isEmpty()) {
					right = false;
					break;
				}
				//peek�� ��
				//¦�� ������ pop�ϰ� ���ڳֱ�
				if(stack.peek().equals("(")) {
					stack.pop();
					stack.add("2");
				}
				//���ڶ�� ������ȣ ���ö����� pop(���ڴ� push)�ϸ鼭 ��
				else {
					int sum = 0;
					while(!stack.isEmpty()) {
						if(stack.peek().equals("(")) {
							//���� ���ֱ�
							stack.pop();
							//������ȣ�� *2�� ���ش�.
							sum *= 2;
							//���� �ٽ� �־��ֱ�
							stack.add(String.valueOf(sum));
							break;
						}
						//�ٸ���ȣ���� ������ȣ�� �߰��� ������ �ߴ�.
						else if(stack.peek().equals("[")) {
							right = false;
							break;
						}
						//������ ���
						else {
							//�����ؼ� ���ڰ� ���� ���
							sum += Integer.parseInt(stack.peek());
							stack.pop();
						}
					}
					
				}
				
			}
			else if(ch==']') {
				//stack�� �ƹ��͵� ������ �ùٸ��� ���� ���ڿ�
				s_close++;
				if(stack.isEmpty()) {
					right = false;
					break;
				}
				//peek�� ��
				//¦�� ������ pop�ϰ� ���ڳֱ�
				if(stack.peek().equals("[")) {
					stack.pop();
					stack.add("3");
				}
				//���ڶ�� ������ȣ ���ö����� pop(���ڴ� push)�ϸ鼭 ��
				else {
					int sum = 0;
					while(!stack.empty()) {
						if(stack.peek().equals("[")) {
							stack.pop();
							sum *= 3;
							stack.add(String.valueOf(sum));
							break;
						}
						//�ٸ���ȣ���� ������ȣ�� �߰��� ������ �ߴ�.
						else if(stack.peek().equals("(")) {
							right = false;
							break;
						}
						//������ ���
						else {
							sum += Integer.parseInt(stack.peek());
							stack.pop();		
						}
					}
					
				}
			}
		
		}
		
		int ans =0;
		//�ùٸ��� ���� ���ڿ��̶��
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
