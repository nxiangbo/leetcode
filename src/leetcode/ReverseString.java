package leetcode;

public class ReverseString {
	public static String reverseString(String s) {
		if(s==null){
			return null;
		}
		
		char[] a = s.toCharArray();
        int low = 0;
        int high = s.length()-1;
        while(low<high){
        	char temp = a[low];
        	a[low] = a[high];
        	a[high] = temp;
        	low++;
        	high--;
        }
		String result = new String(a);
        return result;
    }
	public static void main(String[] args) {
		String demo = "hello world";
		System.out.println(reverseString(demo));
	}
}
