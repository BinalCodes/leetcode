package medium;
/*
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “makes”, word2 = “coding”
Output: 1
Input: word1 = "makes", word2 = "makes"
Output: 3
 */
public class ShortestWordDist3 {

	public static void main(String[] args) {
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "makes";
		String word2 = "coding";
		System.out.println("Distance between 2 words "+shortestWordDistance(words, word1, word2));
		System.out.println("Distance between 2 words "+shortestWordDistance(words, word1, "makes"));
	}
	public static int shortestWordDistance(String[] words, String word1, String word2) {
        //Assuming word1 and word2 exists in words[] dict
		int p1 =-1 , p2=-1, min = Integer.MAX_VALUE;
		if(word1.equals(word2)) {
			for(int i =0 ;i<words.length ; i++) {
				if(word1.equals(words[i])) {
					if(p1 == -1)
						p1 = i;
					else {
						min = Math.min(min, i-p1); 
						p1 = i;
					}
				}
			}
		}
		else{
			for(int i = 0; i<words.length ;i++) {
				if(words[i].equalsIgnoreCase(word1))
					p1 = i;
				if(words[i].equalsIgnoreCase(word2))
					p2 =i;
				if(p1!=-1 && p2!=-1) {
					min = Math.min(min, Math.abs(p1-p2)); 
				}
			}
		}
		return min;
    }

}
