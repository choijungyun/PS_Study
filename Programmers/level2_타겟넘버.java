package Programmers;
import java.util.*;
import java.io.*;

public class level2_타겟넘버 {
	 public int answer=0;
	    public int solution(int[] numbers, int target) {
	        dfs(0, 0, target, numbers);
	        return answer;
	    }
	    
	    public void dfs(int idx, int sum, int target, int[] numbers){
	        if(idx==numbers.length){
	            if(sum==target){
	                answer++;
	            }
	        }
	        else{
	            dfs(idx+1, sum+numbers[idx], target, numbers); 
	            dfs(idx+1, sum-numbers[idx], target, numbers);        
	        }
	    }
}
