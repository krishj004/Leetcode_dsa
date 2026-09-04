class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] visitor=new int[n][m];
        int cmnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visitor[i][j]==0 && grid[i][j]=='1'){
                    cmnt++;
                    bfs(i,j,grid,visitor);
                }
            }
        }
        return cmnt;
    }
    public void  bfs(int i,int j,char[][] grid,int[][] visitor){
        int n=grid.length;
        int m=grid[0].length;
            Queue<Pair> q=new LinkedList<>();
            visitor[i][j]=1;
            q.add(new Pair(i,j));
            int[] delrow={-1,0,1,0};
            int[] delcol={0,1,0,-1};
            while(!q.isEmpty()){
                int row=q.peek().r;
                int col=q.peek().c;
                q.remove();
                for(int r=0;r<4;r++){
                        int newr=row+delrow[r];
                        int newcol=col+delcol[r];
                        if(newr>=0 && newr<n && newcol>=0 && newcol<m && visitor[newr][newcol]!=1 && grid[newr][newcol]=='1'){
                            visitor[newr][newcol]=1;
                            q.add(new Pair(newr,newcol));
                        }
                    
                }
            }

    }
}
class Pair{
    int r;
    int c;
    Pair(int row,int col){
        this.r=row; this.c=col;
    }
}