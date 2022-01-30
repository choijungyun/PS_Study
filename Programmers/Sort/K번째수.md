```java
import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i,j,k,idx;
        for(int c=0; c<commands.length; c++){
            i = commands[c][0];
            j = commands[c][1];
            k = commands[c][2];
            idx = 0;
            int [] arr = new int[j-i+1];
            
            for(int l=i-1; l<j; l++){
                arr[idx++] = array[l]; 
            }
            Arrays.sort(arr);
            answer[c] = arr[k-1];
        }
        
        return answer;
    }
}
```

