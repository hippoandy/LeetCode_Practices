// ref. [Java count char occurence] https://www.baeldung.com/java-count-chars

package app;

import java.util.*;

class Q388_longest_abs_file_path_FAILED
{
    Stack<TreeNode> stack = new Stack<TreeNode>();
    int max = 0;

    public int lengthLongestPath(String input)
    {
        if( input == null ) return max;
        if( input.length() == 0 ) return max;

        // build the tree;
        String[] parts = input.split( "\\n" );

        TreeNode root = new TreeNode( parts[ 0 ], 0 );
        stack.push( root );
        int parentIdx = 0;
        for( int i = 1; i < parts.length; i++ )
        {
            // java 8 syntax, find char occurence in a string, return type: long
            // int level = (int) parts[ i ].chars().filter( c -> c == '-' ).count();
            int level = countLevel( parts[ i ] );
            String cur = parts[ i ].replaceAll( "\\t", "" );
            
            // go back to the previous parent
            if( stack.peek().getLevel() == level )
                stack.pop();
            // level difference is 2, the current node is the child
            // of the latest child of the current parent
            else if( level - stack.peek().getLevel() > 1 )
                // replace the parent
                stack.push( stack.peek().getChild( parentIdx ) );
            // level difference is 1, the current node is the child of the current parent
            // no need to change the root

            parentIdx = stack.peek().putChild( new TreeNode( cur, level ) );
        }
        dfs( root, "" );
        
        return max;
    }
    
    private int countLevel( String s )
    {
        String cur = s.replaceAll( "\\t", "" );
        return s.length() - cur.length();
    }
    
    private void dfs( TreeNode cur, String path )
    {
        if( cur == null ) return;
        path += cur.getText();

        // a leaf node
        if( cur.children.size() == 0 )
            max = (path.length() > max) ? path.length() : max;
        else
            for( TreeNode c: cur.children )
                dfs( c, path + "/" );
    }
    
    class TreeNode
    {
        private List<TreeNode> children;
        private String text;
        private int level;

        public TreeNode( String text, int level )
        {
            this.text = text;
            this.level = level;
            this.children = new ArrayList<TreeNode>();
        }

        public int putChild( TreeNode c )
        {
            this.children.add( c );
            return this.children.size()-1;
        }

        public TreeNode getChild( int idx )
        {
            return this.children.get( idx );
        }

        public int getLevel()
        {
            return this.level;
        }

        public String getText()
        {
            return this.text;
        }
    }
    
    // debug
    // private void levelorder( TreeNode cur )
    // {
    //     Queue<TreeNode> q = new LinkedList<TreeNode>();
    //     q.offer( cur );
    //     while( !q.isEmpty() )
    //     {
    //         TreeNode ptr = q.remove();
    //         System.out.println( ptr.getText() );
    //         if( ptr.children.size() != 0 )
    //             for( int i = 0; i < ptr.children.size(); i++ )
    //                 q.offer( ptr.children.get( i ) );
    //     }
    // }
}