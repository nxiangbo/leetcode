package leetcode.hashtable;

public class H_Index {
	 public int hIndex(int[] citations) {
	        if(citations.length==1 && citations[0]==0){
	            return 0;
	        }
	        if(citations.length==1){
	            return 1;
	        }
	        
	        int[] count = new int[citations.length+1];
	        for(Integer cit:citations){
	            if(cit>citations.length){
	                count[citations.length]++;
	            } else{
	                count[cit]++;
	            }
	        }
	        
	        int h_index = 0;
	        int c = 0;
	        for(int i=citations.length;i>=0;i--){
	            c += count[i];
	            if(c>=i){
	                return i;
	            }
	        }
	        
	        return 0;
	    }
}
