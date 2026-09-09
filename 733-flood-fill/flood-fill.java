class Solution {
    int n;
    int m;
    public void dfs(int[][] image,int row,int col,int color,int original_color){
        image[row][col]=color;
        
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
            for(int i=0;i<4;i++){
                int nrow=row+dr[i];
                int ncol=col+dc[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==original_color){
                   dfs(image,nrow,ncol,color,original_color);
                   }
                   }
                 }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        n=image.length;
        m=image[0].length;
        int original_color=image[sr][sc];
        if(original_color==color) return image;
        dfs(image,sr,sc,color,original_color);
         
    return image;
    }
}