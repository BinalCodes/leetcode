package easy;

import java.util.LinkedList;

public class MovingAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	    LinkedList<Integer> queue;
	    int windowSize;
	    long sum;
	    /** Initialize your data structure here. */
	    public MovingAverage(int size) {
	        this.queue = new LinkedList<Integer>();
	        this.windowSize = size;
	        this.sum = 0;
	    }
	    
	    public double next(int val) {
	        queue.offer(val);
	        sum +=val;
	        if(queue.size() > windowSize){
	            sum -= queue.poll();
	        }
	        return (double)sum/queue.size();
	    }

}
