class Solution {
    // public int uniquepaths(int i,int j,int[][] dp){
    //     if(i==0 && j==0) return 1;
    //     if(i<0 || j<0) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int up=uniquepaths(i-1,j,dp);
    //     int left=uniquepaths(i,j-1,dp);
    //     return dp[i][j]=up+left;
    // }
   
    public int uniquepaths2(int m,int n,int[] prev){
        for(int i=0;i<m;i++){
            int[] curr=new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0) curr[j]=1;
                else{
                int up=0,left=0;
                if(i>0)  up=prev[j];
                if(j>0)  left=curr[j-1];
                curr[j]=up+left;
                }
            }
            prev=curr;
        }
        return prev[n-1];
    }
    public int uniquePaths(int m, int n) {
        int[] prev=new int[n];        
        return uniquepaths2(m,n,prev);
    }
}