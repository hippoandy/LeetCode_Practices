// ref. https://leetcode.com/problems/n-ary-tree-postorder-traversal/discuss/147959/Java-Iterative-and-Recursive-Solutions

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
class Q590_n_ary_tree_postorder
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

    public List<Integer> postorder(Node root)
    {
        List<Integer> sol = new ArrayList<Integer>();
        if( root == null ) return sol;

        Stack<Node> stack = new Stack<>();
        stack.add( root );
        
        while( !stack.isEmpty() )
        {
            root = stack.pop();
            sol.add( root.val );
            for( Node n: root.children ) stack.add( n );
        }
        Collections.reverse( sol );
        
        return sol;
    }
}