class Twitter {
    private static int timestamp = 0;
    
    // Each tweet needs an ID and a global time to sort it
    private class Tweet {
        int id;
        int time;
        Tweet(int id, int time) { this.id = id; this.time = time; }
    }

    private Map<Integer, Set<Integer>> following;
    private Map<Integer, List<Tweet>> tweets;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // A Max-Heap to sort tweets by time
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        
        // Add user's own tweets
        if (tweets.containsKey(userId)) {
            pq.addAll(tweets.get(userId));
        }
        
        // Add tweets from all followees
        Set<Integer> followed = following.get(userId);
        if (followed != null) {
            for (int followeeId : followed) {
                if (tweets.containsKey(followeeId)) {
                    pq.addAll(tweets.get(followeeId));
                }
            }
        }
        
        // Extract the top 10 most recent
        List<Integer> res = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            res.add(pq.poll().id);
            count++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // Cannot follow yourself
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}