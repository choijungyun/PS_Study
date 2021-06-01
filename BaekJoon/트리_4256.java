package BaekJoon;
import java.util.*;
import java.io.*;

/*
 * ������ȸ �߽����� ������ȸ ����Ʈ�� ���� -> �̺�Ž�� �̿�
 * 
 */
public class Ʈ��_4256 {
	public static int N;
	public static int [] preorder;
	public static int [] inorder;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			preorder = new int[N];
			inorder = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				preorder[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				inorder[i] = Integer.parseInt(st.nextToken());
			}
			
			postorder(0, N, 0);
			System.out.println();
		}
		
	}
	//������ġ, ������ ��ġ, ���� ��ġ 
	public static void postorder(int s, int e, int r) {
		for(int i=s; i<e; i++) {
			if(preorder[r]==inorder[i]) {
				//�̺�Ž��
				//����, ��Ʈ, pre��ġ
				postorder(s, i, r+1);
				postorder(i+1, e, r+i-s+1);
				System.out.print(preorder[r]+ " ");
			}
		}
	}

}
