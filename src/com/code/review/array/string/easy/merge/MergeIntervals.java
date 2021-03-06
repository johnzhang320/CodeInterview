package com.code.review.array.string.easy.merge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
	/**
	 *  LeetCode � Merge Intervals
 

		Given a collection of intervals, merge all overlapping intervals.
		
		For example,
		Given [1,3],[2,6],[8,10],[15,18],
		return [1,6],[8,10],[15,18].
		
		Analysis
		
		The key to solve this problem is defining a Comparator first to sort the arraylist of Intevals. 
		Overlap check 
		Alogrithm:
		(1) define class interval implements Comparable, compareTo , if o1.start != o2.start then o1.start -o2.start else o1.end - o2.end
		(2) List<Internel> list as parameter, Collections.sort(list)
		(3) define the prev = list.get(0);
		(4) i = 1 to list.size()
		(5) if prev.end > curr.start, means overlap, take start = prev.start, end = Max(prev.end, curr.end), create new interval, save it to prev
		(6) if prev.end <=curr.start means no overLap, add prev to result array list<Interval> , save curr to prev
		(7) after interation , save prev to result
		
	 * @param args
	 */
	public class Interval implements Comparable {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
		  public int compareTo(Object o) {
			  Interval o2 = (Interval) o;
			  Interval o1 = this;
			  // Ascend order
			  if (o1.start != o2.start) {
				  return o1.start - o2.start;
			  } else {
				  return o1.end - o2.end;
			  }
		  }
		@Override
		public String toString() {
			return "[" + start + "," + end + "]";
		}
		  
	}
	public List<Interval> merge(List<Interval> intervals) {
	    List<Interval> result = new ArrayList<Interval>();
	 
	    if(intervals==null||intervals.size()==0)
	        return result;
	 
	 /**   Collections.sort(intervals, new Comparator<Interval>(){
	        public int compare(Interval i1, Interval i2){
	            if(i1.start!=i2.start)
	                return i1.start-i2.start;
	            else
	                return i1.end-i2.end;
	        }
	    });*/
	    
	    Collections.sort(intervals);
	 
	    Interval pre = intervals.get(0);
	    for(int i=0; i<intervals.size(); i++){
	        Interval curr = intervals.get(i);
	        //check if overlap, curr.start is larger pre.end, which means not overlap
	        if(curr.start>pre.end){
	            result.add(pre);
	            pre = curr;
	        }else{
	            //check if overlap, curr.start is smaller pre.end, which means overlap
	        	//use pre.start and larger one between curr.end and pre.end to create
	        	//new interval
	        	        	
	            Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
	            pre = merged;
	        }
	    }
	    result.add(pre);
	 
	    return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int given[][]= {{1,3},{2,6},{8,10},{15,18}};
		List<Interval> list = new ArrayList<Interval>();
		MergeIntervals ref = new MergeIntervals();
		for (int i=0;i<given.length;i++) {
			Interval intl = ref.new Interval(given[i][0],given[i][1]);
			list.add(intl);
		}
		List<Interval> result= ref.merge(list);
		for (Interval in: result) {
			System.out.print(in.toString());
		}
	}

}
