public class GCJUtils {

	public static int charToInt(char c) {
		return c - '0';
	}
	
	public static int[] splitNumber(long n) {
		String nStr = String.valueOf(n);
		int[] splitted = new int[nStr.length()];
		for (int i = 0; i < splitted.length; i++) {
			splitted[i] = charToInt(nStr.charAt(i));
		}
		return splitted;
	}

	public static int[] splitNumber(int n) {
		return splitNumber(Long.valueOf(n));
	}
	
	public static boolean isAscOrdered(long n) {
		int[] splitted = splitNumber(n);
		for (int i = 0; i < splitted.length - 1; i++) {
			if (splitted[i] > splitted[i + 1])
				return false;
		}
		return true;
	}
	
	public static boolean isAscOrdered(int n) {
		return isAscOrdered(Long.valueOf(n));
	}
	
	public static boolean isDescOrdered(long n) {
		int[] splitted = splitNumber(n);
		for (int i = 0; i < splitted.length - 1; i++) {
			if (splitted[i] < splitted[i + 1])
				return false;
		}
		return true;
	}
	
	public static boolean isDescOrdered(int n) {
		return isDescOrdered(Long.valueOf(n));
	}

	public static int countOccurrences(String str, String oc) {
		return str.length() - str.replace(oc, "").length();
	}

	public static int countOccurrences(String str, char oc) {
		return countOccurrences(str, String.valueOf(oc));
	}
}
