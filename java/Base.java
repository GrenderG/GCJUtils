import java.util.*;
import java.io.*;

public class Base {

	static String handleInput(int cs) {
		return "";
	}

	public static void main (String args[]) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int cases = sc.nextInt();

		for (int i = 1; i <= cases; i++) {
			System.out.println(handleInput(i));
		}
	}
}