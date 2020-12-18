import java.util.Arrays;

class Solution2 {
    public static int[] searchRange(int[] nums, int target) {
    	int range[] = new int[2];
    	range[0] = findFirst(nums, target);  //Searches for first index
    	range[1] = findLast(nums, target);  //Searches for last index 
    	return range;
    	
    }
    
    public static int findFirst(int[] nums, int target) { //uses a binary search
    	int start = 0;
    	int end = nums.length - 1;
    	int index = -1;
    	while(start <= end) {
    		int mid = (start + end) / 2;   
    		if(nums[mid] >= target) {       //starts with checking if the target is >= to mid, if so checks the right most side to get first index
    			end = mid-1;
    		}
    		else {
    			start = mid+1;
    		}
    		if(nums[mid] == target)
    			index = mid;
    	}
    	return index;
    }
    
    public static int findLast(int[] nums, int target) { //uses a binary search
    	int start = 0;
    	int end = nums.length - 1;
    	int index = -1;
    	while(start <= end) {
    		int mid = (start + end) / 2;
    		if(nums[mid] <= target) {       //starts with checking if the target is <= to mid, if so checks the left most side to get last index
    			start = mid+1;
    		}
    		else {
    			end = mid-1;
    		}
    		if(nums[mid] == target)
    			index = mid;
    	}
    	return index;
    }
}
