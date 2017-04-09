public class GCJUtils {

	public static int charToInt(char c) {
		return c - '0';
	}

	public static int countOccurrences(String str, String oc) {
		return str.length() - str.replace(oc, "").length();
	}

	public static int countOccurrences(String str, char oc) {
		return countOccurrences(str, String.valueOf(oc));
	}
}