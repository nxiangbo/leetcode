package leetcode;

public class ImplementstrStr {
	public int strStr(String haystack, String needle) {
		int needleLen = needle.length();
		int hayStackLen = haystack.length();
		if (needleLen <= 0)
			return 0;
		if (needleLen > hayStackLen)
			return -1;

		int first = needle.charAt(0);
		int result = -1;
		for (int i = 0; i < hayStackLen; i++) {
			while (i < hayStackLen && haystack.charAt(i) != first) {
				i++;
			}
			result = i;
			if (needleLen == 1)
				return i;
			if (i < hayStackLen) {
				int j = i + 1;
				for (int k = 1; j < hayStackLen && k < needleLen
						&& haystack.charAt(j) == needle.charAt(k); j++, k++) {
					if (k == needleLen - 1) {
						return result;
					}
				}

			}
		}
		return -1;
	}
}
