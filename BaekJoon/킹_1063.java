package BaekJoon;
import java.io.*;
import java.util.*;

public class ŷ_1063 {
	public static char king_alpha, stone_alpha;
	public static int king_num, stone_num;
	public static String [] alpha = {"R", "L", "B", "T", "RT", "LT", "RB", "LB"};
	public static int [] move_alpha = {1, -1, 0, 0, 1, -1, 1, -1};
	public static int [] move_num = {0, 0, -1, 1, 1, 1, -1, -1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//������ ��ǥ �ޱ�
		String []king = st.nextToken().split("");
		String []stone = st.nextToken().split("");
		king_alpha = king[0].charAt(0);
		king_num = Integer.parseInt(king[1]);
		
		stone_alpha = stone[0].charAt(0);
		stone_num = Integer.parseInt(stone[1]);
		
		//�ݺ� Ƚ��
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			//ŷ �̵�
			String dir = br.readLine();
			move(dir);
		}
		System.out.println(king_alpha+String.valueOf(king_num));
		System.out.println(stone_alpha+String.valueOf(stone_num));
	}
	
	public static void move(String dir) {
		//�̵�����
		int move_idx = 0;
		for(int j=0; j<8; j++) {
			//ŷ �̵�
			if(alpha[j].equals(dir)) {
				move_idx = j;
			}
		}
		king_alpha += move_alpha[move_idx];
		king_num += move_num[move_idx];
		boolean ch = false;
		//ŷ==��?
		if(king_alpha==stone_alpha && king_num==stone_num) {
			ch = true;
			//�� dir�������� ������
			stone_alpha += move_alpha[move_idx];
			stone_num += move_num[move_idx];
		}
			//���� ���?
		if(king_alpha<'A'||king_alpha>'H'||king_num<=0 || king_num>8 || stone_alpha<'A' 
					|| stone_alpha>'H' || stone_num<=0 || stone_num>8) {
				//�ǵ�����
			king_alpha -= move_alpha[move_idx];
			king_num -= move_num[move_idx];
			
			if(ch==true) {
				//�� �ǵ�����
				//�� dir�������� ������
				stone_alpha -= move_alpha[move_idx];
				stone_num -= move_num[move_idx];
			}
			
		}	
	} 
		
	}

