class Pair{
    int first,second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        int original_color=image[sr][sc];
        if(original_color==color) return image;
        image[sr][sc]=color;
        q.add(new Pair(sr,sc));
        while(!q.isEmpty()){
            Pair curr=q.remove();
            int row=curr.first;
            int col=curr.second;
            for(int i=0;i<4;i++){
                int nrow=row+dr[i];
                int ncol=col+dc[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==original_color){
                    image[nrow][ncol]=color;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
    return image;
    }
}