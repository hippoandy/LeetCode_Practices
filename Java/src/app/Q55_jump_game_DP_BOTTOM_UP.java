package app;

enum Memo
{
    GOOD, BAD, UNKNOWN
}

// Runtime: 197 ms, faster than 21.25% of Java online submissions for Jump Game.
// Memory Usage: 41.1 MB, less than 46.56% of Java online submissions for Jump Game.
public class Q55_jump_game_DP_BOTTOM_UP
{
    Memo[] memo;

    public boolean canJump(int[] nums)
    {
        if( nums == null ) return false;
        if( nums.length == 0 ) return true;

        // memo init
        memo = new Memo[ nums.length ];
        for( int i = 0; i < nums.length; i++ )
            memo[ i ] = Memo.UNKNOWN;
        // the last index should always be good
        memo[ nums.length-1 ] = Memo.GOOD;
        
        for( int i = nums.length - 2; i >= 0; i-- )
        {
            int furthestJump = Math.min( i+nums[i], nums.length-1 );
            for( int j = i+1; j <= furthestJump; j++ )
                if( memo[ j ] == Memo.GOOD )
                {
                    memo[ i ] = Memo.GOOD;
                    break;
                }
        }
        
        return memo[ 0 ] == Memo.GOOD;
    }
}