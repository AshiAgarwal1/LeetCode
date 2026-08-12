class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            //store the last occurrence of each character
            arr[s.charAt(i)-'a']=i;
        }
        List<Integer> res=new ArrayList<>();
        int start=0, end=0;
        for(int i=0;i<s.length();i++){
            end=Math.max(end,arr[s.charAt(i)-'a']);
            if(i==end){
                res.add(end-start+1);
                start=end+1;
            }
        }
        return res;
    }
}