// ref. https://leetcode.com/problems/jump-game-ii/discuss/18014/Concise-O(n)-one-loop-JAVA-solution-based-on-Greedy

package app;

class Q45_jump_game_2
{
    public int jump(int[] nums)
    {
        int jump = 0, currEnd = 0, currFurthest = 0;
        
        // "nums.length - 1" since we don't have to consider the last position
        for( int i = 0; i < nums.length - 1; i++ )
        {
            currFurthest = Math.max( currFurthest, i + nums[ i ] );
            // take this jump
            if( i == currEnd )
            {
                jump++;
                currEnd = currFurthest;
            }
        }
        return jump;
    }
}