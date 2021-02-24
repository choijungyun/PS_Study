package BaekJoon;
import java.util.*;
import java.io.*;

public class ����ǥ���_1918 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [] token = br.readLine().toCharArray();
		//�켱���� �����صα�
		HashMap <Character, Integer> hs = new HashMap<Character, Integer>();
		hs.put('(', 0);
		hs.put('+', 1);
		hs.put('-', 1);
		hs.put('*', 2);
		hs.put('/', 2);
		Stack <Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		//��ū Ȯ��
		for(int i=0; i<token.length; i++) {
			//���� ��ȣ, �ǿ����ڶ��
			if(token[i]=='(')
				stack.add(token[i]);
			//�ǿ����ڶ�� ���
			else if(token[i]>='A' && token[i]<='Z')
				sb.append(token[i]);
			//������ȣ���
			else if(token[i]==')') {
				//������ȣ�� ���� �� ���� pop
				while(stack.peek()!='(') {
					sb.append(stack.peek());
					stack.pop();
				}
				//������ȣ pop
				stack.pop();
			}
			//�����ڰ� ������
			else {
				//������ ���������
				if(stack.isEmpty()) 
					stack.add(token[i]);
				else {
					//�켱 ���� ��
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
