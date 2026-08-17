class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int maxLen=0;
        int start=0;
        for(int i=0;i<n;i++){
            //odd length
            int l=i,r=i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(r-l+1>maxLen){
                    maxLen=r-l+1;
                    start=l;
                }
                l--;
                r++;
            }
            //even length
             l=i;
             r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(r-l+1>maxLen){
                    maxLen=r-l+1;
                    start=l;
                }
                l--;
                r++;
            }
        }
        return s.substring(start,start+maxLen);
    }
}