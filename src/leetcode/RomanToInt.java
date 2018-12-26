package leetcode;

import java.util.Hashtable;


/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 */
public class RomanToInt {

	static Hashtable<Character, Integer> table;
	
	static {
		table = new Hashtable<Character, Integer>();
		table.put('I', 1);
		table.put('V', 5);
		table.put('X', 10);
		table.put('L', 50);
		table.put('C', 100);
		table.put('D', 500);
		table.put('M', 1000);
	}
	
	public static void main(String[] args) {
		String romanNumerals = "MDCCCLXXIX";
		System.out.println("1: " + romanToInt(romanNumerals));
	}
	
	public static int romanToInt(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        
        char[] chars = s.toCharArray();
        Integer prevVal = table.get(chars[0]);
        if (prevVal == null) {
        	return -1;
        }
        int sum = prevVal;
        for (int i = 1; i < chars.length; i++) {
        	Integer curVal = table.get(chars[i]);
        	if (curVal == null) {
        		return -1;
        	}
        	
        	if (prevVal < curVal) {
        		sum += curVal - 2 * prevVal;
        	} else {
        		sum += curVal;
        	}
        	prevVal = curVal;
        }
        return sum;
    }
}
