package medium;

import java.util.*;

/*
 * Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

Each process only has one parent process, but may have one or more children processes. 
This is just like a tree structure. Only one process has PPID that is 0, which means this process has no 
parent process. 
All the PIDs will be distinct positive integers.

We use two list of integers to represent a list of processes, where the first list contains PID for 
each process and the second list contains the corresponding PPID.

Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of 
processes that will be killed in the end. You should assume that when a process is killed, all its children 
processes will be killed. No order is required for the final answer.

Input: 
pid =  [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5
Output: [5,10]
Explanation: 
           3
         /   \
        1     5
             /
            10
Kill 5 will also kill 10.
 */
public class KillProcess {

	public static void main(String[] args) {
		//Either we can use DFS,HashMap+DFS,HashMap+BFS or TreeStructure
		List<Integer> pid = Arrays.asList(1, 3, 10, 5);
		List<Integer> ppid = Arrays.asList(3,0,5,3);
		KillProcess k = new KillProcess();
		List<Integer> res = k.killProcess(pid,ppid,3);
		for(int id : res) {
			System.out.println("Process to be killed is "+id);
		}
		
		List<Integer> res1 = k.killProcessBFS(pid,ppid,3);
		for(int id : res1) {
			System.out.println("Process to be killed with BFS is "+id);
		}
	}
	// Time Complexity O(n) and space complexity o(n)
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill){
		HashMap<Integer,List<Integer>> myMap = new HashMap<>();
		for(int i=0 ; i<ppid.size();i++) {
			if(ppid.get(i) >0) {
				List<Integer> list = myMap.getOrDefault(ppid.get(i), new ArrayList<Integer>());
				list.add(pid.get(i));
				myMap.put(ppid.get(i),list);
			}
		}
		List<Integer> result = new ArrayList<Integer>();
		result.add(kill);
		killProcessDFSUtil(result,myMap,kill);
		return result;
	}
	public void killProcessDFSUtil (List<Integer> result, HashMap<Integer,List<Integer>> myMap, int kill) {
		if(myMap.containsKey(kill)) {
			for(int id: myMap.get(kill)) {
				result.add(id);
				killProcessDFSUtil(result, myMap, id);
			}
		}
	}
	public List<Integer> killProcessBFS(List<Integer> pid, List<Integer> ppid, int kill){
		HashMap<Integer,List<Integer>> myMap = new HashMap<>();
		for(int i=0 ; i<ppid.size();i++) {
			if(ppid.get(i) >0) {
				List<Integer> list = myMap.getOrDefault(ppid.get(i), new ArrayList<Integer>());
				list.add(pid.get(i));
				myMap.put(ppid.get(i),list);
			}
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		queue.add(kill);
		while(!queue.isEmpty()) {
			int id = queue.remove();
			result.add(id);
			if(myMap.containsKey(id)) {
				for(int i : myMap.get(id)) {
					queue.add(i);
				}
			}
		}
		return result;
	}
}
