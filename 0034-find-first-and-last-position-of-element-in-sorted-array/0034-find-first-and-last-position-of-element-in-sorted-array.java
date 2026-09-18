class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
        int lb=lowerBound(nums,target);
        if(lb==nums.length || nums[lb]!=target) return new int[]{-1,-1};
        return new int[]{lb,upperBound(nums,target)-1};
    }
    public int lowerBound(int[] nums, int target) {
        int low=0;
              int high=nums.length-1;
              int ans=nums.length;
              while(low<=high){
                  int mid=low+(high-low)/2;
                  if(nums[mid]>=target){
                      ans=mid;
                      high=mid-1;
                  }
                 else low=mid+1;
              }
              return ans;
    }
     int upperBound(int[] nums, int target) {
               int low=0;
                     int high=nums.length-1;
                     int ans=nums.length;
                     while(low<=high){
                         int mid=low+(high-low)/2;
                         if(nums[mid]>target){
                             ans=mid;
                             high=mid-1;
                         }
                        else low=mid+1;
                     }
                     return ans;
    }
}