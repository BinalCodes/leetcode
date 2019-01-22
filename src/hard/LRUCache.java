package hard;

import java.util.HashMap;

public class LRUCache {
	    static class Node{
	        int key;
	        int val;
	        Node pre;
	        Node next;
	        
	        Node(int key, int val){
	            this.key = key;
	            this.val = val;
	        }
	    }
	    HashMap<Integer, Node > cache = new HashMap<Integer, Node>();
	    int totCapacity;
	    Node head = null , tail = null;
	    public LRUCache(int capacity) {
	        this.totCapacity = capacity;
	    }
	    
	    public int get(int key) {
	        if(cache.containsKey(key)){
	            Node n = cache.get(key);
	            remove(n);
	            setHead(n);
	            return n.val;
	        }
	        return -1;
	    }
	    
	    public void remove(Node n){
	        if(n.pre!=null){
	            n.pre.next = n.next;
	        }else{
	            head = n.next;
	        }
	        if(n.next!=null){
	            n.next.pre = n.pre;
	        }
	        else{
	            tail = n.pre;
	        }
	    }
	    public void setHead(Node n){
	        n.next = head;
	        n.pre = null;
	        if(head != null){
	            head.pre = n;
	        }
	        head = n;
	        if(tail == null)
	            tail = head;
	    }
	    
	    public void put(int key, int value) {
	        if(cache.containsKey(key)){
	            Node oldValue = cache.get(key);
	            oldValue.val = value;
	            remove(oldValue);
	            setHead(oldValue);
	        }
	        else{
	            Node newNode = new Node(key,value);
	            if(cache.size() >= totCapacity){
	               cache.remove(tail.key);
	               remove(tail);
	               setHead(newNode);
	            }else{
	                setHead(newNode);
	            }
	            cache.put(key,newNode);
	            
	        }
	        
	    }

	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
