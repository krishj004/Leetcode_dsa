class Solution {
    public int minDistance(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
       // int[][] dp=new int[n+1][m+1];
        // for(int i=0;i<=n;i++)
        // Arrays.fill(dp[i],-1);
      //  return dist(n,m,s1,s2,dp);
      //for(int j=0;j<=m;j++) dp[0][j]=j;
      //for(int i=0;i<=n;i++) dp[i][0]=i;
      int[] prev=new int[m+1];
      for(int j=0;j<=m;j++) prev[j]=j;
      for(int i=1;i<=n;i++){
         int[] curr=new int[m+1];
            curr[0]=i;
        for(int j=1;j<=m;j++){
            if(s1.charAt(i-1)==s2.charAt(j-1))
            curr[j]= 0+prev[j-1];
            else curr[j]= 1+Math.min(curr[j-1],Math.min(prev[j],prev[j-1]));
        }
        prev=curr;
      }
      return prev[m];
    }
    // public int dist(int i,int j,String s1,String s2,int[][] dp){
    //     if(i==0) return j;
    //     if(j==0) return i;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     if(s1.charAt(i-1)==s2.charAt(j-1))
    //     return dp[i][j]= 0+dist(i-1,j-1,s1,s2,dp);
    //     else return dp[i][j]= 1+Math.min(dist(i,j-1,s1,s2,dp),Math.min(dist(i-1,j,s1,s2,dp),dist(i-1,j-1,s1,s2,dp)));
    // }
}