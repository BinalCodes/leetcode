package easy;

public class DesignHashSet {

	class MyHashSet {

	    /** Initialize your data structure here. */
	    ListNode[] nodes;
	    class ListNode{
	        int key;
	        ListNode next;
	        ListNode(int key){
	            this.key = key;
	        }
	    }
	    public MyHashSet() {
	        nodes = new ListNode[1000];
	    }
	    
	    public void add(int key) {
	        int idx = getHash(key);
	        if(nodes[idx] == null)
	            nodes[idx] = new ListNode(-1); // no bucket exists
	        ListNode prev = find(key, nodes[idx]); //selecting the bucket
	        if(prev.next == null){
	            prev.next = new ListNode(key);
	        }
	        prev.next.key = key;
	    }
	    
	    public void remove(int key) {
	        int i = getHash(key);
	        if(nodes[i] == null)
	            return;
	        ListNode prev = find(key,nodes[i]);
	        if(prev.next == null)
	            return;
	        prev.next = prev.next.next;
	    }
	    
	    /** Returns true if this set contains the specified element */
	    public boolean contains(int key) {
	        int idx = getHash(key);
	        if(nodes[idx] == null)
	            return false;
	        ListNode prev = find(key, nodes[idx]); //selecting the bucket
	        if(prev.next == null){
	            return false;
	        }
	        return true;
	    }
	    public ListNode find(int key, ListNode bucket){
	        ListNode prev =null, node = bucket;
	        while(node!=null && node.key!=key){
	            prev = node;
	            node = node.next;
	        }
	        return prev;
	    }
	    
	    public int getHash(int key){
	        return (Integer.hashCode(key) % nodes.length);
	    }
	}

	/**
	 * Your MyHashSet object will be instantiated and called as such:
	 * MyHashSet obj = new MyHashSet();
	 * obj.add(key);
	 * obj.remove(key);
	 * boolean param_3 = obj.contains(key);
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
