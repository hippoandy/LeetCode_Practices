// ref. https://leetcode.com/problems/battleships-in-a-board/discuss/90902/Simple-Java-Solution

package app;

/*
 * Follow up:
 * Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?
 */
class Q419_battleships_in_a_board_FOLLOWUP
{
    public int countBattleships(char[][] board)
    {
        if( board == null ) return 0;
        int m = board.length;
        if( m == 0 ) return 0;
        int n = board[ 0 ].length;
        if( n == 0 ) return 0;

        int count=0;
        for( int i = 0; i < m; i++ )
            for( int j = 0; j < n; j++ )
            {
                if( board[i][j] == '.' )                continue;
                if( i > 0 && board[ i-1 ][ j ] == 'X' ) continue;
                if( j > 0 && board[ i ][ j-1 ] == 'X' ) continue;
                count++;
            }
        
        return count;
    }
}