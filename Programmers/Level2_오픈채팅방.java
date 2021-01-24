package Programmers;
import java.util.*;
import java.io.*;

public class Level2_오픈채팅방 {
	public static String[] solution(String[] record) {
        String[] answer = {};
        HashMap <String, String> map = new HashMap<>();
        //1. map 유저아이디, 닉네임 담기
        for(int i=0; i<record.length; i++){
            String [] chat = record[i].split(" ");
            //2. enter, change라면 아이디, 닉네임 확인 후 저장
            if(chat[0].equals("Enter") || chat[0].equals("Change")){
                String user_id = chat[1];
                String user_nickname = chat[2];
                map.put(user_id, user_nickname);
            }
        }
        //3. record돌면서 출력
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i<record.length; i++){
            String [] chat = record[i].split(" ");
            if(chat[0].equals("Enter")){
                arr.add(map.get(chat[1])+"님이 들어왔습니다.");
            }
            else if(chat[0].equals("Leave")){
                arr.add(map.get(chat[1])+"님이 나갔습니다.");
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
