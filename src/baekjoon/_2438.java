package baekjoon;

import java.util.Scanner;

public class _2438 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		String str = "*";
		
		for(int i=0 ; i<a; i++ ) {
			String repeated = str.repeat(i+1);
			// '[string].repeat(a)' repeats [string] 'a' times.
			System.out.println(repeated);
		}
		sc.close();
	}

}
