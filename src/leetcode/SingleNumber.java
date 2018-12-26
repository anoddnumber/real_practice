package leetcode;

import org.junit.Assert;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one. Note: Your algorithm should have a linear runtime
 * complexity. Could you implement it without using extra memory?
 * 
 */
public class SingleNumber {

	public static void main(String[] args) {
		{
			int[] testNums = {1};
			Assert.assertTrue(singleNumber(testNums) == 1);
		}
		{
			int[] testNums = {1, 1, 2};
			Assert.assertTrue(singleNumber(testNums) == 2);
		}
		{
			int[] testNums = {1, 2, 2, 3, 3, 1, 4, 5, 4};
			Assert.assertTrue(singleNumber(testNums) == 5);
		}
		{
			int[] testNums = {-1, -1, 5};
			Assert.assertTrue(singleNumber(testNums) == 5);
		}
		{
			int[] testNums = {-1, 8, -2, -1, 8};
			Assert.assertTrue(singleNumber(testNums) == -2);
		}
		System.out.println("done");
	}

	public static int singleNumber(int[] A) {
		if (A.length < 1) {
			return -1;
		}
		
		int result = 0;
		for (int i : A) {
			result = result ^ i;
		}
		
		return result;
	}
}
