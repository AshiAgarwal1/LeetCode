class Solution {
    public int[] manachers(String s){
        StringBuilder t=new StringBuilder("#");
        for(char c:s.toCharArray()){
            t.append(c).append("#");
        }
        int n=t.length();
        int[] p=new int[n];
        int l=0,r=0;
        for(int i=0;i<n;i++){
            //mirror=l+(r-i)
            p[i]=(i<r)?Math.min(p[l+(r-i)],r-i):0;
            //if next left and right equal expand
            while(i+p[i]+1<n && i-p[i]-1>=0 && t.charAt(i+p[i]+1)==t.charAt(i-p[i]-1)){
                p[i]++;
            }
            //update if found bigger palindrome
            if(i+p[i]>r){
                l=i-p[i];
                r=i+p[i];
            }
        }
        return p;
    }
    public String longestPalindrome(String s) {
        //Manachers algo
        int[] p=manachers(s);
        int centerIdx=0, resLen=0;
        for(int i=0;i<p.length;i++){
            if(p[i]>resLen){
                resLen=p[i];
                centerIdx=i;
            }
        }
        //left bound=center-radius 
        //orig idx=left/2
        int resIdx=(centerIdx-resLen)/2;
        return s.substring(resIdx,resIdx+resLen);
    }
}