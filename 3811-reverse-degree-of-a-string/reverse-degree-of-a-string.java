class Solution {
    public int reverseDegree(String s) {
        int sum=0,prod=1;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int idx=(ch-'a')+1;
            prod=(26-idx+1)*(i+1);
            sum+=prod;
        }
        return sum;
    }
}