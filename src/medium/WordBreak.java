package medium;

import java.util.ArrayList;
import java.util.*;

/*
 * Given a string and a dictionary , return true if the string can be formed by using the words in the dict
 * 
 */
public class WordBreak {

	public static void main(String[] args) {
		//String s ="applepenapple";
		WordBreak obj = new WordBreak();
		String s ="catsandog";
		List<String> dict = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
		System.out.println(obj.wordBreakBruteForce(s,dict));
	}

	public boolean wordBreakBruteForce(String s , List<String> dict) {
		int[] pos = new int[s.length()+1];
		//int maxLen = Integer.MIN_VALUE;
		Arrays.fill(pos, -1);
		Set<String> set = new HashSet<>(dict);
		/*for(String ss : set)
			maxLen = Math.max(maxLen, ss.length()); */
		pos[0] = 0;
		for(int i =0; i < s.length() ;i++) {
			if(pos[i]!= -1) {
				for(int j=i+1; j<=s.length() ; j++) {
					String sub = s.substring(i, j);
					//if(j-i<= maxLen && set.contains(sub))
					if(set.contains(sub))
						pos[j] = i;
				}
			}
		}
		//print the pos array
		for(int i : pos)
			System.out.println(" pos "+i);
		return pos[s.length()]!=-1; 
		/*boolean [] mem = new boolean[s.length() + 1];
        mem[0] = true;
        Set<String> set = new HashSet<>(dict);
        int maxLen = 0;
        for(String ss: dict) maxLen = Math.max(maxLen,ss.length());
        for(int i = 0;i< s.length();i++){
            if(mem[i]){
                for(int j = i+1;j<= s.length();j++){
                    if(j-i <= maxLen && set.contains(s.substring(i,j))){
                        mem[j] = true;
                    }
                }
            }
        }
        return mem[s.length()];*/
	}
}
