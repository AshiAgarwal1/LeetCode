class Solution {
    public int lcs(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int[] prev=new int[m+1];
        for(int i=1;i<=n;i++){
            int[] curr=new int[m+1];
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                }
                else
                    curr[j]=Math.max(prev[j],curr[j-1]);
            }
            prev=curr;
        }
        return prev[m];
    }
    public int minDistance(String word1, String word2) {
        return word1.length()+word2.length()-2*lcs(word1,word2);
    }
}