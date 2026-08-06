class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cookie=0;int greed=0;
        while(cookie<s.length && greed< g.length){
            if(g[greed]<=s[cookie]) greed++;//this child is satisfied
            cookie++;//move to next cookie
        }
         return greed;
    }
   }