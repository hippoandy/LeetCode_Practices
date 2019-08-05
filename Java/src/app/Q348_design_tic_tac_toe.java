// ref. https://leetcode.com/problems/design-tic-tac-toe/discuss/81898/Java-O(1)-solution-easy-to-understand

package app;

class Q348_design_tic_tac_toe
{
    class TicTacToe
    {
        private int[] rows;
        private int[] cols;
        private int diagonal;
        private int antidiagonal;
        private int size;

        /** Initialize your data structure here. */
        public TicTacToe(int n)
        {
            this.rows = new int[ n ];
            this.cols = new int[ n ];
            this.diagonal = 0;
            this.antidiagonal = 0;
            this.size = n;
        }
        
        /** Player {player} makes a move at ({row}, {col}).
            @param row The row of the board.
            @param col The column of the board.
            @param player The player, can be either 1 or 2.
            @return The current winning condition, can be either:
                    0: No one wins.
                    1: Player 1 wins.
                    2: Player 2 wins. */
        public int move(int row, int col, int player)
        {
            int move = (player == 1) ? 1 : -1;
            
            // horizontal and vertical
            this.rows[ row ] += move;
            this.cols[ col ] += move;
            // diagonal and antidiagonal
            if( row == col )
                this.diagonal += move;
            if( row + col == this.size-1 )
                this.antidiagonal += move;
            // if at any time a row or column matches the size of the board then that player has won.
            if(
                Math.abs( this.rows[ row ] )  == this.size ||
                Math.abs( this.cols[ col ] )  == this.size ||
                Math.abs( this.diagonal )     == this.size ||
                Math.abs( this.antidiagonal ) == this.size
            )
                return player;
            return 0;
        }
    }

    /**
     * Your TicTacToe object will be instantiated and called as such:
     * TicTacToe obj = new TicTacToe(n);
     * int param_1 = obj.move(row,col,player);
     */
}