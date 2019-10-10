// ref. https://stackoverflow.com/questions/41030069/c-doubly-linked-list-deleting-element-from-the-tail-using-pop-back

package app;

import java.util.*;

class Q353_design_snake_game
{
    class SnakeGame
    {
        int[][] food;
        int foodIdx;
        Snake snake;

        /** Initialize your data structure here.
            @param width - screen width
            @param height - screen height 
            @param food - A list of food positions
            E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
        public SnakeGame(int width, int height, int[][] food)
        {
            // Snake class: a self-defined doubly linked list
            snake = new Snake( width, height );
            // the snake started at (0, 0) with len = 1
            snake.insertHead( new Node( 0, 0 ) );
            
            // store a reference of food and init the foodIdx
            this.food = food;
            this.foodIdx = 0;
        }
        
        /** Moves the snake.
            @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
            @return The game's score after the move. Return -1 if game over. 
            Game over when snake crosses the screen boundary or bites its body. */
        public int move( String direction )
        {
            // the snake is already dead
            if( snake.died ) return -1;
            
            Node head = snake.getHead();

            int r = head.x, c = head.y;
            switch( direction )
            {
                case "U": r -= 1; break;
                case "D": r += 1; break;
                case "L": c -= 1; break;
                case "R": c += 1; break;
            }

            // if this grid contains a food
            if( foodIdx < this.food.length &&
                r == this.food[ foodIdx ][ 0 ] && c == this.food[ foodIdx ][ 1 ] )
                foodIdx++;
            // remove the last position the snake occupied (snake is not growing)
            else snake.popTail();

            // if valid, return the number (idx + 1) of food been eaten
            if( snake.insertHead( new Node( r, c ) ) ) return foodIdx;
            else
            {
                snake.died = true;
                return -1;
            }
        }
        
        private class Snake
        {
            Set<Integer> occupied;
            int w, h;
            boolean died;
            
            Node head, tail;
            int size;
            public Snake( int w, int h )
            {
                this.head = this.tail = null;

                // store the width and height of the screen
                this.w = w; this.h = h;
                
                // indicates the status of the snake
                this.died = false;
                
                // stores the grid number that the snake occupied
                this.occupied = new HashSet<Integer>();
            }
            
            public boolean insertHead( Node n )
            {
                if( !validMove( n.x, n.y ) ) return false;
                
                // update the length
                this.size++;
                // record the grid number
                this.occupied.add( n.x * this.w + n.y );
                
                if( this.head == null )
                {
                    this.head = n;
                    this.tail = n;
                }
                else
                {
                    // update the pointers
                    n.next = this.head;
                    this.head.prev = n;
                    this.head = n;

                    // update the tail pointer
                    Node ptr = head;
                    while( ptr.next != null ) ptr = ptr.next;
                    this.tail = ptr;
                }
                return true;
            }
            
            public void popTail()
            {
                Node toDel = tail;
                tail = toDel.prev;
                if( tail != null )  tail.next = null;
                // when the list become empty, set head = null!
                else                head = null;

                // remove the grid number
                this.occupied.remove( toDel.x * this.w + toDel.y );
                
                // decrease the size
                this.size--;
            }
            
            private boolean validMove( int x, int y )
            {
                // the snake bits itself
                if( occupied.contains( x * this.w + y ) ) return false;
                // the snake hit the wall
                if( x < 0 || y < 0 || x >= this.h || y >= this.w ) return false;
                
                return true;
            }

            public Node getHead() { return head; }
            public int getSize() { return this.size; }
            public boolean isEmpty() { return this.size == 0; }
        }
        
        private class Node
        {
            int x, y;
            Node prev, next;
            public Node( int x, int y ) { this.x = x; this.y = y; this.initPointers(); }
            
            private void initPointers()
            {
                this.prev = null;
                this.next = null;
            }
        }
    }

    /**
     * Your SnakeGame object will be instantiated and called as such:
     * SnakeGame obj = new SnakeGame(width, height, food);
     * int param_1 = obj.move(direction);
     */
}