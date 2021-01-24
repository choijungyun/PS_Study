package Programmers;
import java.util.*;
import java.io.*;

public class Level2_����ä�ù� {
	public static String[] solution(String[] record) {
        String[] answer = {};
        HashMap <String, String> map = new HashMap<>();
        //1. map �������̵�, �г��� ���
        for(int i=0; i<record.length; i++){
            String [] chat = record[i].split(" ");
            //2. enter, change��� ���̵�, �г��� Ȯ�� �� ����
            if(chat[0].equals("Enter") || chat[0].equals("Change")){
                String user_id = chat[1];
                String user_nickname = chat[2];
                map.put(user_id, user_nickname);
            }
        }
        //3. record���鼭 ���
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i<record.length; i++){
            String [] chat = record[i].split(" ");
            if(chat[0].equals("Enter")){
                arr.add(map.get(chat[1])+"���� ���Խ��ϴ�.");
            }
            else if(chat[0].equals("Leave")){
                arr.add(map.get(chat[1])+"���� �������ϴ�.");
            }
        }
        answer = new String[arr.size()];
        for(int i=0; i<arr.size(); i++){
            answer[i] = arr.get(i);
            //System.out.println(answer[i]);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(record);
	}

}
