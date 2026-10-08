class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] prev=new int[m];
        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        for(int i=0;i<n;i++){
            int[] curr=new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0) curr[j]=grid[0][0];
                else{
                int up=grid[i][j],left=grid[i][j];
                if(i>0) up+=prev[j];
                else up+=(int)1e9;
                if(j>0) left+=curr[j-1];
                else left+=(int)1e9;
                curr[j]=Math.min(up,left);
                }
            }
            prev=curr;
        }
        return prev[m-1];
    }
    // public int minpathsum(int[][] grid,int[][] dp,int i,int j){
    //     if(i==0 && j==0) return grid[0][0];
    //     if(i<0 || j<0) return (int)1e9;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int up=grid[i][j]+minpathsum(grid,dp,i-1,j);
    //     int left=grid[i][j]+minpathsum(grid,dp,i,j-1);
    //     return dp[i][j]=Math.min(up,left);
    // }
}