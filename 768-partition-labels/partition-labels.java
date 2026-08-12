class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            //store the last occurrence of each character
            map.put(s.charAt(i),i);
        }
        List<Integer> res=new ArrayList<>();
        int start=0, end=0;
        for(int i=0;i<s.length();i++){
            end=Math.max(end,map.get(s.charAt(i)));
            if(i==end){
                res.add(end-start+1);
                start=end+1;
            }
        }
        return res;
    }
}