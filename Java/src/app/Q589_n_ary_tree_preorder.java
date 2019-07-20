// ref. https://leetcode.com/problems/island-perimeter/discuss/95001/clear-and-easy-java-solution

package app;

import java.util.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Q589_n_ary_tree_preorder
{
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root)
    {
        List<Integer> sol = new ArrayList<Integer>();
        if( root == null ) return sol;

        Stack<Node> stack = new Stack<Node>();
        stack.push( root );
        while( !stack.isEmpty() )
        {
            Node cur = stack.pop();
            sol.add( cur.val );
            if( cur.children != null )
                for( int i = cur.children.size() - 1; i >= 0; i-- )
                    stack.push( cur.children.get( i ) );
        }
        return sol;
    }
}