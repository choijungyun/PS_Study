package 삼성_모의;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 특이한자석_4013 {

	public static ArrayList <Integer> [] dq;
	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("../samsung01/src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			//4개의 arr선언
			dq = new ArrayList[8];
			for(int i=0; i<4; i++) {
				dq[i] = new ArrayList<Integer>();
			}
			
			//자석을 회전시키는 횟수
			int K = Integer.parseInt(br.readLine());
			for(int i=0; i<4; i++) {
				String [] s = br.readLine().split(" ");
				for(int j=0; j<8; j++) {
					dq[i].add(Integer.parseInt(s[j]));
				}
			}
			
			//회전 정보
			for(int i=0; i<K; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(str.nextToken());
				int dir = Integer.parseInt(str.nextToken());
				
				//회전할 것 찾기
				move_num(num, dir);

				
			}
			int ans =0;
			//점수 계산
			for(int i=0; i<4; i++) {
				ans += dq[i].get(0)*Math.pow(2, i);
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
	
	public static void move_num(int num, int dir) {
		//회전가능한지 살피기, 가능하면 배열에 담기
		int tmp_dir = dir;
		ArrayList <State> arr = new ArrayList<>(); 
		//기준이 되는 것 담기
		arr.add(new State(num-1, dir));
		boolean ch = true;
		//앞부분
		for(int i=num-1; i>0; i--) {
			if(ch) {
				if(dq[i-1].get(2)!=dq[i].get(6)) {
					arr.add(new State(i-1, dir*-1));
					dir*=-1;
					ch = true;
				}
				else ch = false;
			}
		}
		dir = tmp_dir;
		//뒷부분
		ch = true;
		for(int i=num-1; i<3; i++) {
			if(ch) {
				if(dq[i].get(2)!=dq[i+1].get(6)) {
					arr.add(new State(i+1, dir*-1));
					dir*=-1;
					ch = true;
				}
				else ch = false;
			}
		}
		
		move(arr);
	}
	
	public static void move(ArrayList <State> arr) {
		for(int i=0; i<arr.size(); i++) {
			int num = arr.get(i).num;
			int dir = arr.get(i).dir;
			if(dir==1) {
				int tmp = dq[num].get(7);
				dq[num].remove(7);
				dq[num].add(0,tmp);
			}
			else {
				int tmp = dq[num].get(0);
				dq[num].remove(0);
				dq[num].add(tmp);
			}
		}
	}
}

class State{
	int num, dir;
	
	State(int num, int dir){
		this.num = num;
		this.dir = dir;
	}
}
