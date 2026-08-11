class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize!=0) return false;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int num:hand){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //keep making groups
        while(!map.isEmpty()){
            //pick smallest available card
            int curr=map.firstKey();
            for(int i=0;i<groupSize;i++){
                int card=curr+i;
                if(!map.containsKey(card)) return false;
                //use one card
                map.put(card,map.get(card)-1);
                //if no cards left remove
                if(map.get(card)==0) map.remove(card);
            }
        }
        return true;
    }
}