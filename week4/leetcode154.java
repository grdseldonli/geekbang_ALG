class Solution {
    public int findMin(int[] nums){
        int start=0;
		 
		 int end =nums.length-1;
		 
		 int middle=0;
		 int min=Integer.MAX_VALUE;
		 
		 while(start<end) {
			 middle=(start+end)/2;
			 if(nums[middle]>nums[end]) 
             {
				 //min=min<nums[start]? nums[start]:min;
				 start=middle+1;
            }else if(nums[middle]<nums[end]) {
				 
				 end=middle;
				 
			 }else{


                 end--;
             }
			 
		 }
		 return nums[start];

    }
}