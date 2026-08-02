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
        List<int[]> feedTweets=new ArrayList<>();
        //add users own tweets first
        if(tweetMap.containsKey(userId)){
            feedTweets.addAll(tweetMap.get(userId));
        }
        //add followees tweets
        //check if user follows someone
        if(followMap.containsKey(userId)){
            for(int followee: followMap.get(userId)){
                //check if followee tweeted something
                if(tweetMap.containsKey(followee))
                feedTweets.addAll(tweetMap.get(followee));
            }
        }
        //sort ny the latest tweet
        feedTweets.sort((a,b)->b[0]-a[0]);
        //return a list with tweet ids
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<Math.min(10,feedTweets.size());i++){
            ans.add(feedTweets.get(i)[1]);
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