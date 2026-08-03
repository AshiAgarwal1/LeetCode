class Twitter {
    int time;
    HashMap<Integer,List<int[]>> tweetMap;
    HashMap<Integer,Set<Integer>> followMap;

    public Twitter() {
        int time=0;
        tweetMap=new HashMap<>();
        followMap=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId,new ArrayList<>());
        tweetMap.get(userId).add(new int[]{time,tweetId});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        //optimal approach using heap
       List<Integer> ans=new ArrayList<>();
       //{timestamp,tweetId,userId,index}
       PriorityQueue<int[]> maxHeap= new PriorityQueue<>((a,b)->b[0]-a[0]);
       //add users own latest tweet
       if(tweetMap.containsKey(userId)){
        List<int[]> tweets=tweetMap.get(userId);
        int last=tweets.size()-1;
        int[] tweet=tweets.get(last);
        maxHeap.add(new int[]{tweet[0],tweet[1],userId,last});
       }
       //add latest tweet of every followee
       if(followMap.containsKey(userId)){
        for(int followee: followMap.get(userId)){
            if(!tweetMap.containsKey(followee)) continue;
            List<int[]> tweets=tweetMap.get(followee);
            int last=tweets.size()-1;
            int[] tweet=tweets.get(last);
            maxHeap.add(new int[]{tweet[0],tweet[1],followee,last});
        }
       }
       while(!maxHeap.isEmpty() && ans.size()<10){
        int[] curr=maxHeap.poll();
        ans.add(curr[1]);
        int user=curr[2];
        int index=curr[3];
        //push the next older tweet of same user
        if(index>0){
            List<int[]> tweets=tweetMap.get(user);
            int[] prev=tweets.get(index-1);
            maxHeap.add(new int[]{prev[0],prev[1],user,index-1});
        }
       }
        return ans;


    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)) followMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */