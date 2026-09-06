class Solution {
    public void nextPermutation(int[] nums) {
     int ind=-1;
     int n=nums.length;
     for(int i=n-2;i>=0;i--){
        if(nums[i]<nums[i+1]){
            ind=i;
            break;
        }
     }   
     if(ind==-1){
        reverse(nums,0,n-1);
        return;}
     for(int i=n-1;i>ind;i--){
        if(nums[ind]<nums[i]){
            swap(nums,ind,i);
            break;
        }
     }
     reverse(nums,ind+1,n-1);
     return;
    }
    public void reverse(int[] nums,int i,int j){
        while(i<j){
            swap(nums,i,j);
            i++;j--;
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}