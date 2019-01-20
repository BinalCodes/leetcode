package medium;

import java.util.*;

/*
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the 
 * number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. 
Note that 1 does not map to any letters.
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinations {

	public static void main(String[] args) {
		String phoneNum = "2135";
		List<String> ans = letterCombinations(phoneNum);
		ans.forEach(System.out::println);
		
	}
	public static List<String> letterCombinations(String digits) {
        String[] map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        LinkedList<String> ans = new LinkedList<String>();
        ans.add("");
        for(int i = 0 ; i<digits.length(); i++) {
        	int x = Character.getNumericValue(digits.charAt(i));
        	while(ans.peek().length() == i) {
        		String toAppend = ans.remove();
        		for(int j = 0 ; j< map[x].length(); j++) {
        			ans.add(toAppend+map[x].charAt(j));
        		}
        	}
        }
        return ans;
	}

}
