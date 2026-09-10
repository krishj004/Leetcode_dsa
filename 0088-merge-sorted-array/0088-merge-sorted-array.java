class Solution {
    public void merge(int[] nums1, int n, int[] nums2, int m) {
        // int length=(n+m);
        // int gap=(length/2)+(length%2);
        // while(gap>0){
        //     int left=0;
        //     int right=left+gap;
        //     while(right<length){
        //         if(left<n && right>=n){
        //             swapgreater(nums1,nums2,left,right-n);
        //         }
        //         else if(left>=n){
        //             swapgreater(nums2,nums2,left-n,right-n);

        //         }
        //         else{
        //             swapgreater(nums1,nums1,left,right);

        //         }
        //         left++; right++;
                
        //     }
        //     if(gap==1) break;
        //         gap=(gap/2)+(gap%2);

        // }
        // for(int i=0;i<m;i++){
        //     nums1[n+i] = nums2[i];
        // }
        int i=n-1;int j=m-1; int k=n+m-1;
        while(j>=0){
            if(i>=0 && nums1[i]>nums2[j]){
                nums1[k]=nums1[i];
                i--;
            }
            else{
                nums1[k]=nums2[j];
                j--;
            }
            k--;
        }

    }
    public void swapgreater(int[] arr1,int[] arr2,int n,int m){
        if(arr1[n]>arr2[m]){
            int temp=arr1[n];
            arr1[n]=arr2[m];
            arr2[m]=temp;
        }
    }
}