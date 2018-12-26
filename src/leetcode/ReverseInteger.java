package leetcode;

import org.junit.Assert;

/**
 * Reverse digits of an integer. Example1: x = 123, return 321 Example2: x =
 * -123, return -321
 * 
 */
public class ReverseInteger {

	public static void main(String[] args) {

		int testNum = 123;
		Assert.assertTrue(reverse(testNum) == 321);
		
		testNum = -123;
		Assert.assertTrue(reverse(testNum) == -321);
		
		testNum = 67304;
		Assert.assertTrue(reverse(testNum) == 40376);
		
		testNum = 0;
		Assert.assertTrue(reverse(testNum) == 0);
		
		System.out.println("reversed integer done");
	}

	public static int reverse(int x) {
		if (x < 0) {
			return reverse(Math.abs(x)) * -1;
		}
		
		int reversedNum = 0;
		while (x > 0) {
			int firstDigit = x % 10;
			reversedNum = reversedNum * 10 + firstDigit;
			x /= 10;
		}
		return reversedNum;
	}
}
