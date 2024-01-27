package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class NextPermutation {
	
	public static ArrayList<Integer> findNextPermutation(ArrayList<Integer> arr){
		
		
		//Find BreakPoint
		int breakPoint = 0;
		for (int i=arr.size()-2; i>=0; i--) {
			if (arr.get(i) < arr.get(i+1)) {
				breakPoint = i;
				break;
			}
		}
		
		//Find Least Element > Breakpoint
		int leastElementIndex = breakPoint+1;
		
		for (int i=breakPoint+1; i<arr.size(); i++) {
			if (arr.get(i) >= arr.get(breakPoint) && arr.get(i) < arr.get(leastElementIndex))
				leastElementIndex = i;
		}
		
		System.out.println(breakPoint);
		System.out.println(leastElementIndex);
		
		//Swap
		Collections.swap(arr, breakPoint, leastElementIndex);
		System.out.println(arr.toString());
		
		if (breakPoint == 0)
            Collections.sort(arr,Comparator.reverseOrder());
		
		else
			//Sort in Ascending Order
			Collections.sort(arr.subList(breakPoint, leastElementIndex));
		
		return arr;
	}
	
	public static void main(String[] args) {
	
		ArrayList <Integer> arr = new ArrayList<Integer>(Arrays.asList(3));
		System.out.println(findNextPermutation(arr).toString());
		
	}
}
