class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        int subset=(1<<nums.length);
        for(int num=0;num<subset;num++){
            List<Integer> ls=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                if((num&(1<<i))!=0)
                ls.add(nums[i]);

            }
            list.add(ls);
        }
        return list;
    }
}