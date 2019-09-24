package app;

import java.util.*;

// Runtime: 69 ms, faster than 40.36% of Java online submissions for Design Twitter.
// Memory Usage: 45.2 MB, less than 100.00% of Java online submissions for Design Twitter.
class Q355_design_twitter
{
    class Twitter
    {
        private class Post
        {
            int id, tstamp;
            public Post( int id, int tstamp ) { this.id = id; this.tstamp = tstamp; }
        }
        
        int timestamp = 0;
        
        Map<Integer, PriorityQueue<Post>> userPosts;
        Map<Integer, Set<Integer>> userFollows;
        
        /** Initialize your data structure here. */
        public Twitter()
        {
            // store the posts by a certain user
            this.userPosts = new HashMap<Integer, PriorityQueue<Post>>();
            // stoer the followings of a certain user
            this.userFollows = new HashMap<Integer, Set<Integer>>();
        }
        
        // generic heap creation
        private PriorityQueue<Post> genHeap()
        {
            return new PriorityQueue<Post>(
                // sort by timestamp, most recent
                (a, b) -> b.tstamp - a.tstamp
            );
        }
        // generating the timestamp in String format
        private int genTimestamp() { return this.timestamp++; }
        
        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId)
        {
            // record the post
            this.userPosts.computeIfAbsent( userId, x -> genHeap() ).offer( new Post( tweetId, genTimestamp() ) );
            // let user follow himself/herself
            follow( userId, userId );
        }
        
        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId)
        {
            // store the result
            List<Integer> res = new ArrayList<Integer>();

            if( userFollows.containsKey( userId ) )
            {
                // sort the result
                PriorityQueue<Post> pq = genHeap();
                for( int id: userFollows.get( userId ) )
                {
                    // if the user has no posts
                    if( !userPosts.containsKey( id ) ) continue;
                    pq.addAll( userPosts.get( id ) );
                }
                int i = 0;
                while( i < 10 && !pq.isEmpty() )
                {
                    res.add( pq.remove().id );
                    i++;
                }
            }
            // return the result
            return res;
        }
        
        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId)
        {
            this.userFollows.computeIfAbsent( followerId, x -> new HashSet<Integer>() ).add( followeeId );
        }
        
        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId)
        {
            // user is not allowed to unfollow himself/herself
            if( followerId != followeeId )
                if( this.userFollows.containsKey( followerId ) )
                    this.userFollows.get( followerId ).remove( followeeId );
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
}