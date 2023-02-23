class Twitter {
    HashMap<Integer, User> hashmap;
    int timeStamp;

    public Twitter() {
        int id;
        hashmap = new HashMap<>();
        timeStamp = 0;
    }
    
    class  Tweet{
        int id;
        int time;
        Tweet(int id, int time){
            this.id = id;
            this.time= time;
        }
    }

    class User{
        int id;
        HashSet<Integer> users;
        List<Tweet> tweets;
        User(int id){
            this.id = id;
            this.users = new HashSet<>();
            this.tweets = new ArrayList<>();
        }
    }


    public void postTweet(int userId, int tweetId) {
        if (!hashmap.containsKey(userId)){
            hashmap.put(userId, new User(userId));
        }
        
        hashmap.get(userId).tweets.add(new Tweet(tweetId, timeStamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b)->(b.time-a.time));
        List<Integer> results = new ArrayList<>();
        
        if (!hashmap.containsKey(userId)) return results;
    
        for (int i=0; i<hashmap.get(userId).tweets.size(); i++){
            pq.offer(hashmap.get(userId).tweets.get(i));
        }

        for (Integer us : hashmap.get(userId).users){
            if (hashmap.get(us)==null || us==userId) continue;
            for (Tweet t: hashmap.get(us).tweets){
                pq.offer(t);
            }
        }
        int i=0; 
        while (!pq.isEmpty() && i<10){
            results.add(pq.poll().id);
            i++;
        }
        return results;
    }
    
    public void follow(int followerId, int followeeId) {
        
        if (!hashmap.containsKey(followerId)){
            hashmap.put(followerId, new User(followerId));
        }

        hashmap.get(followerId).users.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        
        if (!hashmap.containsKey(followerId)){
            return;
        }

        hashmap.get(followerId).users.remove(followeeId);
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
