package easy;

public class DesignHashMap {

	    /** Initialize your data structure here. */
	    ListNode[] nodes;
	    class ListNode{
	        int key, value;
	        ListNode next;
	        ListNode(int key, int value){
	            this.key = key;
	            this.value = value;
	        }
	    }
	    public DesignHashMap() {
	        nodes = new ListNode[1000];
	    }
	    
	    /** value will always be non-negative. */
	    public void put(int key, int value) {
	        int hash = getHash(key);
	        if(nodes[hash] == null) //bucket doesnt exist
	            nodes[hash] = new ListNode(-1,-1);
	        ListNode prev = find(key, nodes[hash]);
	        if(prev.next == null){
	            prev.next = new ListNode(key,value);
	        }
	        prev.next.value = value;
	    }
	    
	    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	    public int get(int key) {
	        int hash = getHash(key);
	        if(nodes[hash] == null){
	            return -1;
	        }
	        ListNode prev = find(key, nodes[hash]);
	        if(prev.next == null)
	            return -1;
	        return prev.next.value;
	        
	    }
	    
	    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
	    public void remove(int key) {
	        int hash = getHash(key);
	        if(nodes[hash] == null)
	            return;
	        ListNode prev = find(key, nodes[hash]);
	        if(prev.next == null)
	            return;
	        if(prev.next.next == null)
	            prev.next = null;
	        else
	            prev.next = prev.next.next;
	    }
	    
	    public int getHash(int key){
	        return (Integer.hashCode(key))%nodes.length;
	    }
	    
	    public ListNode find(int key, ListNode bucket){
	        ListNode node = bucket, prev = null ;
	        while(node!=null && node.key!=key){
	            prev = node;
	            node = node.next;
	        }
	        return prev;    
	    }

	/**
	 * Your MyHashMap object will be instantiated and called as such:
	 * MyHashMap obj = new MyHashMap();
	 * obj.put(key,value);
	 * int param_2 = obj.get(key);
	 * obj.remove(key);
	 */
	public static void main(String[] args) {
		

	}

}
