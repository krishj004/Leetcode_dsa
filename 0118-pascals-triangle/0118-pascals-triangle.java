class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ls=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            ls.add(generaterow(i));
        }
        return ls;
    }
    public List<Integer> generaterow(int r){
        int ans=1;
        List<Integer> ls=new ArrayList<>();
        ls.add(1);
        for(int col=1;col<r;col++){
            ans=ans*(r-col);
            ans=ans/(col);
            ls.add(ans);
        }
        return ls;

    }
}