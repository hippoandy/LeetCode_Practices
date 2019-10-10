package app;

// Runtime: 1 ms, faster than 99.46% of Java online submissions for Jump Game.
// Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Jump Game.
class Q55_jump_game_GREEDY
{
    /*
        Iterating right-to-left, for each position we check if there is a potential jump that reaches a GOOD index
        (currPosition + nums[currPosition] >= leftmostGoodIndex).
        
        If we can reach a GOOD index, then our position is itself GOOD.
        Also, this new GOOD position will be the new leftmost GOOD index.
     */
    public boolean canJump(int[] nums)
    {
        int lastPos = nums.length - 1;
        for( int i = nums.length-1; i >= 0; i-- )
            if( i + nums[ i ] >= lastPos )
                lastPos = i;
        return lastPos == 0;
    }
}