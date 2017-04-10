import java.util.*;

public class GCJUtils {

	public static int charToInt(char c) {
		return c - '0';
	}

	/**
	* Intercambia los caracteres de str
	* @param String str El string del que se intercambian los valores
	* @param char c1 Uno de los dos caracteres a intercambiar
	* @param char c2 Uno de los dos caracteres a intercambiar
	* @return String La cadena con los valores intercambiados
	*/
	public static String flip(String str, char c1, char c2) {
		return flipFromOffset(str, c1, c2, 0);
	}

	/**
	* Intercambia los numeros de numbers
	* @param int[] numbers Los números que se van a intercambian los valores
	* @param int n1 Uno de los dos números a intercambiar
	* @param int n2 Uno de los dos números a intercambiar
	* @return int[] Los números cambiados
	*/
	public static int[] flip(int[] numbers, int n1, int n2) {
		return flipFromOffset(numbers, n1, n2, 0);
	}

	/**
	* Intercambia los caracteres de str desde un punto
	* @param String str El string del que se intercambian los valores
	* @param char c1 Uno de los dos caracteres a intercambiar
	* @param char c2 Uno de los dos caracteres a intercambiar
	* @param int offset Desde donde empiezaa hacer el flip 
	* @return String La cadena con los valores intercambiados
	*/
	public static String flipFromOffset(String str, char c1, char c2, int offset) {
		char[] chars = str.toCharArray();
		for (int i = offset; i < chars.length; i++)
			chars[i] = (chars[i] == c1) ? c2 : c1;
		return String.valueOf(chars);
	}

	/**
	* Intercambia los numeros de numbers desde un punto
	* @param int[] numbers Los números que se van a intercambian los valores
	* @param int n1 Uno de los dos números a intercambiar
	* @param int n2 Uno de los dos números a intercambiar
	* @param int offset Desde donde empiezaa hacer el flip 
	* @return int[] Los números cambiados
	*/
	public static int[] flipFromOffset(int[] numbers, int n1, int n2, int offset) {
		for (int i = offset; i < numbers.length; i++)
			numbers[i] = (numbers[i] == n1) ? n2 : n1;
		return numbers;
	}

	/**
	* Devuelve las diferentes cifras de un número (no repetidas)
	* @param long n El número del que saber las cifras 
	* @return int[] Las cifras del número
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
	* Devuelve las diferentes cifras de un número (no repetidas)
	* @param int n El número del que saber las cifras 
	* @return int[] Las cifras del número
	*/
	public static int[] differentCiphers(int n) {
		return differentCiphers(Long.valueOf(n));
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
