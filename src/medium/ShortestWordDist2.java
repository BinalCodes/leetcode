package medium;

import java.util.*;
/*
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters. 

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
 */

public class ShortestWordDist2 {

	Map<String, ArrayList<Integer>> dict = new HashMap<String, ArrayList<Integer>>();
	Map<String,Integer> cachedDist = new HashMap<String,Integer>();
    public ShortestWordDist2(String[] words) {
        for(int i =0; i<words.length; i++) {
        	dict.computeIfAbsent(words[i], v -> new ArrayList<>()).add(i);
        	//or we can do the whole contains logic
        	//dict.put(words[i], dict.getOrDefault(words[i], new ArrayList<Integer>.add(i),new ArrayList<Integer>.add(i)));
        }
    }
    
    public int shortest(String word1, String word2) {
        String key = word1+"$"+word2;
        if(cachedDist.containsKey(key))
        	return cachedDist.get(key);
        ArrayList<Integer> list1 =  dict.get(word1);
        ArrayList<Integer> list2 = dict.get(word2);
        int i = 0 , j = 0, min = Integer.MAX_VALUE;
        while(i< list1.size() && j <list1.size()) {
        	int index1 = list1.get(i);
        	int index2 = list2.get(j);
        	if(index1> index2) {
        		min = Math.min(min, index1- index2);
        		j++;
        	}
        	else {
        		min = Math.min(min, index2- index1);
        		i++;
        	}
        	if(min == 1) {
        		cachedDist.put(key, min);
        		return min;//there is nothing less than 1
        	}
        }
        cachedDist.put(key, min);
        return min;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
