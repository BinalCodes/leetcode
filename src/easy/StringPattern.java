package easy;

import java.util.HashMap;
import java.util.Map;

public class StringPattern {

	public static void main(String[] args) {
		//String pattern = "abba";
		//String sentence ="dog cat cat dog";
		String pattern ="ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
		String sentence ="s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
		StringPattern s = new StringPattern();
		System.out.println(s.wordPattern(pattern, sentence));

	}
	public boolean wordPattern(String pattern, String str) {
        String[] word = str.split(" ");
        if(word.length != pattern.length()){
            //System.out.println("Length is diff");
            return false;
        }
        Map<String,Integer> sMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();
        for(int i=0 ; i< word.length; i++){
            int sIndex = sMap.getOrDefault(word[i], i);
            int pIndex = pMap.getOrDefault(pattern.charAt(i),i);
            if(sIndex!= pIndex){
                return false;
            }
            sMap.put(word[i], i);
            pMap.put(pattern.charAt(i),i);
        }
        return true;
        
    }
	public boolean wordPattern1(String pattern, String str) {
	    String[] words = str.split(" ");
	    if (words.length != pattern.length())
	        return false;
	    Map index = new HashMap();
	    //TODO:  why Integer we need to understand here 
	    /*
	     * with i being an Integer object, which allows to compare 
	     * with just != because there's no autoboxing-same-value-to-different-objects-problem anymore. 
	     */
	    for (Integer i=0; i<words.length; ++i) {
	    	System.out.println("Pattern charAT "+pattern.charAt(i) +" words[i] "+words[i] +" i "+i );
	        if (index.put(pattern.charAt(i), i) != index.put(words[i], i)) {
	        	System.out.println(" index.get(pattern.char) "+ index.get(pattern.charAt(i)) + " words "+ index.get(words[i]));
	            return false;
	        }
	    }
	    return true;
	}

}
