package Day2;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
        int count = 0;    //indicator that identifies encounter number
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target && count == 0) {
                range[0] = i;
                count++;
            }
            //count is not incremented b/c it would not be necessary
            if(nums[i] == target && count > 0)
                range[1] = i;
        }
        if(count == 0) { //if count is 0 then no encounters were found
            range[0] = -1;  //sets range to {-1, -1}
            range[1] = -1;
        }
        return range;
    }
}

//follow up question
