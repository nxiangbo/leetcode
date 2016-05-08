package leetcode;

public class ReverseVowelsofaString {
	public static String reverseVowels(String s) {
        if(s==null){
        	return null;
        }
        char[] array = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int low = 0;
        int high = array.length-1;
        while(low<high){
        	while(low<high&&vowels.indexOf(array[low])==-1){
        		low++;
        		System.out.println("low="+low);
        	}
        	while(low<high&&vowels.indexOf(array[high])==-1){
        		high--;
        		System.out.println("high="+high);
        	}
        	char temp = array[low];
        	array[low] = array[high];
        	array[high] = temp;
        	low++;
        	high--;
//        	String result = new String(array);
//        	System.out.println(result);
        }
        String result = new String(array);
        return result;
    }
	
	public static void main(String[] args) {
		String s = "leetcode";
		System.out.println(reverseVowels(s));
	}
}
