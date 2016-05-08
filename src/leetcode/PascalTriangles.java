package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangles {
	public static List<List<Integer>> generate(int numRows) {
		 List<List<Integer>> results = new ArrayList<>();
	        if(numRows<=0){
	            return results;
	        }
	        List<Integer> result1 = new ArrayList<>();
	        result1.add(0,1);
	        results.add(result1);
	        if(numRows==1){
	            return results;
	        }
	        
	        List<Integer> result2 = new ArrayList<>();
	        result2.add(0,1);
	        result2.add(1,1);
	        results.add(result2);
	        if(numRows==2){
	            return results;
	        }
	        for(int i = 2;i<numRows;i++){
	            List<Integer> result = new ArrayList<>();
	            for(int k=0;k<i+1;k++){
	            	result.add(1);
	            }
	            for(int j=1;j<=i-1;j++){
	                result.set(j,results.get(i-1).get(j-1)+results.get(i-1).get(j));
	            }
	            results.add(result);
	        }
	        return results;
	        
       
    }
	
	public static void main(String[] args) {
		int numRows = 5;
		generate(numRows);
		ArrayList<String> result = new ArrayList<>(12);
		Collections.fill(result, "helle");
		System.out.println(result.size());
	}
}
