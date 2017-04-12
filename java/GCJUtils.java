import java.util.*;

public class GCJUtils {
	
	/**
	* Converts char numeric value (0-9) to its equal numerical value
	* @param char c Char we want to convert to int
	* @return int Char converted to its numerical value
	*/
	public static int charToInt(char c) {
		return c - '0';
	}

	/**
	* Replaces c1 for c2 and viceversa from string str
	* @param String str String input -the original one
	* @param char c1 One of the chars
	* @param char c2 The other one
	* @return String String output with replaced values
	*/
	public static String flip(String str, char c1, char c2) {
		return flipFromOffset(str, c1, c2, 0);
	}

	/**
	* Replaces n1 for n2 and viceversa from one array of ints, 
	* int[] numbers
	* @param int[] numbers Array of ints input -the original one
	* @param int n1 One of the integers
	* @param int n2 The other one
	* @return int[] Array of ints ouput with replaced values
	*/
	public static int[] flip(int[] numbers, int n1, int n2) {
		return flipFromOffset(numbers, n1, n2, 0);
	}

	/**
	* Replaces c1 for c2 and viceversa starting from an offset
	* @param String str String input -the original one
	* @param char c1 One of the chars
	* @param char c2 The other one
	* @param int offset Position where the flip starts 
	* @return String String output with replaced values
	*/
	public static String flipFromOffset(String str, char c1, char c2, int offset) {
		char[] chars = str.toCharArray();
		for (int i = offset; i < chars.length; i++)
			chars[i] = (chars[i] == c1) ? c2 : c1;
		return String.valueOf(chars);
	}

	/**
	* Replaces n1 for n2 and viceversa starting from an offset
	* @param int[] numbers Array of ints input -the original one
	* @param int n1 One of the integers
	* @param int n2 The other one
	* @param int offset Position where the flip starts 
	* @return int[] Array of ints output with replaced values
	*/
	public static int[] flipFromOffset(int[] numbers, int n1, int n2, int offset) {
		for (int i = offset; i < numbers.length; i++)
			numbers[i] = (numbers[i] == n1) ? n2 : n1;
		return numbers;
	}

	/**
	* Returns the different ciphers contained in n (no duplicates)
	* @param long n Number which we want to know the different ciphers 
	* @return int[] Different ciphers
	*/
	public static int[] differentCiphers(long n) {
		int[] ciphers = splitNumber(n), r;
		int it = 0;
		HashSet<Integer> knownC = new HashSet<Integer>();
		for(int i = 0; i < ciphers.length; i ++)
			knownC.add(ciphers[i]);
		r = new int[knownC.size()];
		for (int c : knownC) {
			r[it] = c;
			it ++;
		}
		return r;
	}

	/**
	* Returns the different ciphers containd in n (no duplicates)
	* @param int n Number which we want to know the different ciphers
	* @return int[] Different ciphers
	*/
	public static int[] differentCiphers(int n) {
		return differentCiphers(Long.valueOf(n));
	}
	
	/**
	* Splits a number into its ciphers
	* @param long n Number to split
	* @return int[] Array containing each cipher of n
	*/	
	public static int[] splitNumber(long n) {
		String nStr = String.valueOf(n);
		int[] splitted = new int[nStr.length()];
		for (int i = 0; i < splitted.length; i++) {
			splitted[i] = charToInt(nStr.charAt(i));
		}
		return splitted;
	}
	
	/**
	* Splits a number into its ciphers
	* @param int n Number to split
	* @return int[] Array containing each cipher of n
	*/
	public static int[] splitNumber(int n) {
		return splitNumber(Long.valueOf(n));
	}
	
	/**
	* Checks if a number is sorted in ascending order
	* @param long n Number to check its cipher order
	* @return boolean If it's sorted in ascending order or not
	*/
	public static boolean isAscOrdered(long n) {
		int[] splitted = splitNumber(n);
		for (int i = 0; i < splitted.length - 1; i++) {
			if (splitted[i] > splitted[i + 1])
				return false;
		}
		return true;
	}
	
	/**
	* Checks if a number is sorted in ascending order
	* @param int n Number to check its cipher order
	* @return boolean If it's sorted in ascending order or not
	*/
	public static boolean isAscOrdered(int n) {
		return isAscOrdered(Long.valueOf(n));
	}
	
	/**
	* Checks if a number is sorted in descending order
	* @param long n Number to check its cipher order
	* @return boolean If it's sorted in descending order or not
	*/
	public static boolean isDescOrdered(long n) {
		int[] splitted = splitNumber(n);
		for (int i = 0; i < splitted.length - 1; i++) {
			if (splitted[i] < splitted[i + 1])
				return false;
		}
		return true;
	}
	
	/**
	* Checks if a number is sorted in descending order
	* @param int n Number to check its cipher order
	* @return boolean If it's sorted in descending order or not
	*/	
	public static boolean isDescOrdered(int n) {
		return isDescOrdered(Long.valueOf(n));
	}
	
	/**
	* Count how many times oc appears in str
	* @param String str String we want to examine
	* @param String oc String we want to find in str
	* @return int Number of times that oc appears in str
	*/
	public static int countOccurrences(String str, String oc) {
		return str.length() - str.replace(oc, "").length();
	}
	
	/**
	* Count how many times oc appears in str
	* @param String str String we want to examine
	* @param char oc char we want to find in str
	* @return int Number of times that oc appears in str
	*/
	public static int countOccurrences(String str, char oc) {
		return countOccurrences(str, String.valueOf(oc));
	}

	/**
	* Adds a character to a String, writing right if alphabetically ascending sorted (or equal), left if else
	* @param String str String we want write in
	* @param char c char we want to add
	* @return String modified
	*/
	public static String addCharToStringAlphaSorted(String str, char c){
		int c_int = c;
		int c_initvalue_int = str.charAt(0);
		int c_lastvalue_int = str.charAt(str.length() - 1);

		System.out.println("Adding " +  c_int + " to \"" + str + "\", seeing extreme chars " + c_initvalue_int + " and " + c_lastvalue_int);

		if(c <= c_lastvalue_int)
			str += c;
		else if(c > c_lastvalue_int)
			str = c + str;

		System.out.println("Result: " + str);

		return str;
	}
}
