class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
    int cnt=0;
    int longest=Integer.MIN_VALUE;
    HashSet<Integer> st=new HashSet<>();
    for(int i=0;i<nums.length;i++){
        st.add(nums[i]);
    }    
    for(int it:st){
        if(!st.contains(it-1)){
            cnt=1;
           int x=it;
        
        while(st.contains(x+1)){
            cnt++;
            x++;
        }
        longest=Math.max(longest,cnt);
        }
    }
    return longest;
    }
}