class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int left=0;
        int right=m-1;
        int top=0;
        int bottom=n-1;
        List<Integer> ls=new ArrayList<>();
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                ls.add(mat[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                ls.add(mat[i][right]);
            }
            right--;
            if(top<=bottom){
            for(int i=right;i>=left;i--){
                ls.add(mat[bottom][i]);
            }
            bottom--;}
            if(left<=right){
            for(int i=bottom;i>=top;i--){
                ls.add(mat[i][left]);
            }
            left++;}
        }
        return ls;
    }
}