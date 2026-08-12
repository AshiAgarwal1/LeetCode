class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
    Set<Integer> set=new HashSet<>();
    for(int[] t:triplets){
        if(t[0]>target[0] || t[1]>target[1] || t[2]>target[2]) continue;//if at any idx val greater than target ignore
        //for remaining triplets if their value matches add their idx 
        for(int i=0;i<t.length;i++){
            if(t[i]==target[i]) set.add(i);
        }
    } 
    return set.size()==3;   
    }
}