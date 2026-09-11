class Solution {
    public int maxProduct(int[] nums) {
        int pre=1;
        int suff=1;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(pre==0) pre=1;
            if(suff==0) suff=1;
            pre=pre*nums[i];
            suff=suff*nums[nums.length-1-i];
            maxi=Math.max(maxi,Math.max(pre,suff));
        }
        return maxi;
    }
}