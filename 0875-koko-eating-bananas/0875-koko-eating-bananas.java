class Solution {
    public int minEatingSpeed(int[] nums, int threshold) {
         int n=nums.length;
        if(n>threshold) return -1;
        int max=nums[0];
        for(int i=1;i<n;i++){
            max=Math.max(max,nums[i]);
        }
        int low=1;
        int high=max;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(sum(nums,mid)<=threshold){
                high=mid-1;
            }
            else low=mid+1;
        }
        return low;
    }
      public int sum(int[] nums,int mid){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.ceil((double)nums[i]/mid);
        }
        return sum;
    }
}