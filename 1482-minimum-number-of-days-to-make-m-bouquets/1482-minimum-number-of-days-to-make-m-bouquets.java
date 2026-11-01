class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        long limit=m*1L*k*1L;
        if(n<limit) return -1;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
        }
        int low=min;
        int high=max;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible(bloomDay,m,k,mid))
            high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public boolean possible(int[] nums,int m,int k,int day){
        int cut=0;
        int nk=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=day){
                cut++;
            }
            else{
                nk+=cut/k;
                cut=0;
            }
        }
        nk+=cut/k;
        if(nk>=m) return true;
        else return false;
    }
}