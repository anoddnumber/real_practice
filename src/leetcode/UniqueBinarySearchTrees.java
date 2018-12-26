package leetcode;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 */
public class UniqueBinarySearchTrees {
	public static void main(String[] args) {
		System.out.println("numTrees(2): " + numTrees(2));
		System.out.println("numTrees(3): " + numTrees(3));
		System.out.println("numTrees(4): " + numTrees(4));
		System.out.println("numTrees(5): " + numTrees(5));
	}
	public static int numTrees(int n) {
		if (n == 0) {
			return 1;
		}
		
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += numTrees(i) * numTrees(n - 1 - i);
		}
		return sum;
	}
	
	
//	public static int numTrees(int n) {
//        if (n <= 0) {
//        	return 0;
//        }
//        
//        if (n == 1) {
//        	return 1;
//        }
//        
//        int sum = 0;
//        //i represents the number of nodes we give to the left side
//        for (int i = n - 1; i >= n/2; i--) {
//        	int numTrees = numTrees(i) * 2;
//        	if (n - i - 1 != 0) {
//        		numTrees *= numTrees(n - i - 1);
//        	}
//        	sum += numTrees;
//        	
//        	
//        	//if the left and right sides are given the same number of nodes,
//        	//it is possible to have symmetric trees
//        	if (i == n - 1 - i) {
//        		sum -= numRepeats(i);
//        	}
//        }
//        return sum;
//    }
//	
//	public static int numRepeats(int n) {
//		return (int) Math.pow(2, n-1);
//	}
}
