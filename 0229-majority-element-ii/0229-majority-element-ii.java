class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int c1=0,c2=0;
        int el1=Integer.MIN_VALUE,el2=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(c1==0 && nums[i]!=el2){
                c1=1; el1=nums[i];
            }
            else if(c2==0 && nums[i]!=el1){
                c2=1; el2=nums[i];
            }
            else if(el1==nums[i]) c1++;
            else if(el2==nums[i]) c2++;
            else{
                c1--; c2--;
            }
        }
        int cn1=0,cn2=0;
        List<Integer> ls=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(el1==nums[i]) cn1++;
            if(el2==nums[i]) cn2++;
        }
        int min=(int)Math.floor(n/3)+1;
        if(cn1>=min) ls.add(el1);
        if(cn2>=min) ls.add(el2);
        Collections.sort(ls);
        return ls;
    }
}