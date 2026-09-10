class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);
        return fn(coins,n-1,amount,dp);
    }
    public int fn(int[] coins,int ind,int target,int[][] dp){
        if(ind==0)
        return (target%coins[ind]==0)?1:0;
        if(dp[ind][target]!=-1) return dp[ind][target];
        int nottaker=fn(coins,ind-1,target,dp);
        int take=0;
        if(coins[ind]<=target)
        take=fn(coins,ind,target-coins[ind],dp);
        return dp[ind][target]=(nottaker+take);
    }
}