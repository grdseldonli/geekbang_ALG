class Solution {
   public int findShortestSubArray(int[] nums) {
		   Map<Integer,Integer> mapAppearCount= new HashMap<Integer,Integer>();
		   Map<Integer,Integer> mapMaxlegth= new HashMap<Integer,Integer>();

			if(nums.length<=1){
			    return 1;
			}
	       //双指针，i从0到length-1的每次遍历中，j从尾部向前找到第一个与怒骂【i】相等时，记录两者下标差，存放于mapMaxlegth中
			//mapAppearCount 记录nums中每个数字出现的最大次数
		   for(int i =0, j=nums.length-1;i<nums.length;) {
			   
		
			   if(nums[i]==nums[j]) {
				 
				   if(!mapMaxlegth.containsKey(nums[i])) {
					   mapMaxlegth.put(nums[i],j-i+1);
				   }
				   
				   mapAppearCount.put(nums[i],mapAppearCount.getOrDefault(nums[i],1)+1);
		           i++;
				   j=nums.length-1;
			   }else {
				   j--;
				   
				   if(j<=i) {
					   
					   mapAppearCount.put(nums[i],mapAppearCount.getOrDefault(nums[i],1)+1);

			           i++;			   
					   j=nums.length-1;
					   
				   }
   
				   
			   }		  		   
		   }
		   
		   //获取nums中重复的最大次数，可能会有多个数重复出现的次数一样
		   int max=0;
	       for (Integer in:mapAppearCount.values())
	       {
	       max=max<in? in:max;
	       }
	       //nums中没有重复数
	       if(max==1){

	           return 1;
	       }
		   
	       //把所有重复出现次数最大的那些数放在list中 
		   List<Integer> maxapper= new ArrayList<Integer>();
		   
		   for(Integer index:mapAppearCount.keySet()) {
			   
			   if(mapAppearCount.get(index)==max) {
				   
				   maxapper.add(index);
				   
			   }
			   
		   }
		   
	    

		   //寻找list中那些数的最大下标差的最小值
		   int min=100000;
		   for(Integer one:maxapper) {
			   min=min> mapMaxlegth.getOrDefault(one,1)? mapMaxlegth.getOrDefault(one,1):min;
 
		   }
		   return min;
		   
		   
		   
	    }
}