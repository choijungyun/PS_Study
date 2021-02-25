package swea_java;
import java.util.*;
import java.io.*;
import java.io.*;

public class ����ִ¿����ΰ���_4615 {
	public static int [] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	public static int [] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			//���� �Ѻ��� ����
			int N = Integer.parseInt(st.nextToken());
			//�÷��̾ ���� ���� Ƚ��
			int M = Integer.parseInt(st.nextToken());
			int [][] map = new int [N+1][N+1];
			//�ʱⰪ �� ����
			map[N/2][N/2] = 2;
			map[N/2+1][N/2] = 1;
			map[N/2+1][N/2+1] = 2;
			map[N/2][N/2+1] = 1;
			
			//�� �α�
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int color = Integer.parseInt(st.nextToken());
				//�� ����
				map[x][y] = color;
				
				//8�������� ���鼭 �������� Ȯ��
				for(int j=0; j<8; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					//�������� ���� ������
					while(nx>0 && ny>0 && nx<=N && ny<=N) {
						//�������� �� ���� ����
						if(map[nx][ny]==color) {
							break;
						}
						//0�̶��
						else if(map[nx][ny]==0) {
							break;
						}
						//�ٸ� �����̸� ����
						else {
							nx += dx[j];
							ny += dy[j];
						}
					}
					//���� ���̶�� �� ~ �� ���� ���� �ٲٱ�
					if( (nx>0 && ny>0 && nx<=N && ny<=N) && map[nx][ny]==color){
						//���� ������ ������ �Ž��� ����
						while (nx!=x || ny!=y) { 
							map[nx][ny] = color;
							nx -= dx[j];
							ny -= dy[j];
						}
						
					}	
					
				}
			}
			int w = 0;
			int b = 0;
			//�� ���� �� ���� ����
			for(int k=1; k<=N; k++) {
				for(int l=1; l<=N; l++){
					if(map[k][l]==1)
						b+=1;
					else if(map[k][l]==2)
						w+=1;
				}
			}
			
			System.out.println("#" + test_case + " "+ b +" "+ w);
		}
				
		
	}

}
