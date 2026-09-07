class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<=n-2;i++){
            for(int j=i+1;j<m;j++){
                swap(matrix,i,j);
            }
        }
        for(int i=0;i<n;i++){
            reverse(matrix,i);
        }
        return;
    }
    public void swap(int[][] mat,int i,int j){
        int temp=mat[i][j];
        mat[i][j]=mat[j][i];
        mat[j][i]=temp;
    }
    public void reverse(int[][] mat,int i){
        int r=mat[0].length-1;
        int l=0;
        while(l<r){
            swap1(mat,l,r,i);
            l++;r--;
        }
        
    }
    public void swap1(int[][] mat,int l,int r,int i){
        int temp=mat[i][l];
        mat[i][l]=mat[i][r];
        mat[i][r]=temp;
    }
}