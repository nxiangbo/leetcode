package leetcode;

public class ReverseString {
	public static String reverseString(String s) {
		if(s==null){
			return null;
		}
//		String result1 = "";
//		String result2 = "";
		
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
//        for (int i = s.length()-1,j=0; j<=i; i--,j++) {
//			result1+=s.charAt(i);
//			result2+=s.charAt(j);
//		}
        return result;
    }
	public static void main(String[] args) {
		String demo = "hello world";
		System.out.println(reverseString(demo));
	}
}
