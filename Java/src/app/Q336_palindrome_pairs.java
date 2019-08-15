// ref. https://leetcode.com/problems/palindrome-pairs/discuss/79195/O(n-*-k2)-java-solution-with-Trie-structure

package app;

import java.util.*;

// Runtime: 26 ms, faster than 96.98% of Java online submissions for Palindrome Pairs.
// Memory Usage: 41.6 MB, less than 100.00% of Java online submissions for Palindrome Pairs.
class Q336_palindrome_pairs
{
    public List<List<Integer>> palindromePairs(String[] words)
    {
        List<List<Integer>> ans = new ArrayList<>();

        // build the trie
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) build( root, words[ i ], i );
        for (int i = 0; i < words.length; i++) search( ans, root, words[ i ], i );

        return ans;
    }

    private void build( TrieNode cur, String word, int indexInWords )
    {
        for( int i = word.length() - 1; i >= 0; i-- )
        {
            char c = word.charAt( i );
            if( cur.child[ c - 'a' ] == null ) cur.child[ c - 'a' ] = new TrieNode();
            
            // if from this node to beginning of a word is palindrome.
            if( isPalindrome( word, 0, i ) ) cur.list.add( indexInWords );
            
            cur = cur.child[ c - 'a' ];
        }
        cur.index = indexInWords;
    }

    private void search( List<List<Integer>> ans, TrieNode node, String word, int indexInWords )
    {
        // search part 1: compare the word to trie (the word may longer than the counterparty in trie)
        for (int j = 0; j < word.length(); j++)
        {
            if( node.index != -1 && node.index != indexInWords && isPalindrome( word, j, word.length()-1 ) )
                ans.add( Arrays.asList( indexInWords, node.index ) );

            node = node.child[ word.charAt( j ) - 'a' ];

            // no valid node in trie
            if( node == null ) return;
        }

        // search part 2: the word is end, only check the rest in trie. (the counterparty in trie may longer than the word )
        // if it is last trienode of a word, add to result.
        if( node.index != -1 )
            if( indexInWords != node.index )
                ans.add( Arrays.asList( indexInWords, node.index ) );

        // if from this trienode to beginning of a word can form a palindrome, add it to result.
        // this make the algorithm able to deal with case [ "a", "" ]!!
        for (int k : node.list)
        {
            if( indexInWords == k ) continue;
            ans.add( Arrays.asList( indexInWords, k ) );
        }
    }

    private boolean isPalindrome( String word, int i, int j )
    {
        while( i < j )
            if (word.charAt( i++ ) != word.charAt( j-- ) ) return false;
        return true;
    }
    
    private class TrieNode
    {
        TrieNode[] child;
        int index;
        // if from this letter in the word to the beginning can form a palindrome, add the current word index in the list
        // this make the algorithm able to deal with case [ "a", "" ]!!
        // record the current word if it is already a palindrome!
        List<Integer> list;

        public TrieNode()
        {
            this.child = new TrieNode[ 26 ];
            this.index = -1;
            this.list = new ArrayList<Integer>();
        }
    }
}

// not able to deal with case [ "a", "" ]!!!!
// class Solution {
//     public List<List<Integer>> palindromePairs(String[] words)
//     {
//         List<List<Integer>> ans = new ArrayList<List<Integer>>();
//         // build the trie
//         TrieNode root = new TrieNode();
//         for( int i = 0; i < words.length; i++ )
//         {
//             TrieNode cur = root;
//             for( char c: words[ i ].toCharArray() )
//             {
//                 if( cur.child[ c - 'a' ] == null ) cur.child[ c - 'a' ] = new TrieNode();
//                 cur = cur.child[ c - 'a' ];
//             }
//             cur.isEnd = true;
//             cur.word = words[ i ];
//             cur.index = i;
//         }
        
//         // find the palindrome pair
//         for( int i = 0; i < words.length; i++ )
//         {
//             String w = words[ i ];

//             TrieNode cur = root;
//             if( w.length() > 0 && cur.child[ w.charAt( (w.length()-1) ) - 'a' ] == null ) continue;

//             int j = 1;
//             // get the candidate
//             while( j <= w.length() && !cur.isEnd ) cur = cur.child[ w.charAt( (w.length()-j++) ) - 'a' ];

//             // make sure it is a valid and existing word 
//             if( cur != null && cur.isEnd && !w.equals( cur.word ) )
//             {
//                 int x = w.length()-1, y = 0;
//                 boolean flag = true;
//                 while( x >= 0 && y < cur.word.length() )
//                     if( w.charAt( x-- ) != cur.word.charAt( y++ ) )
//                     {
//                         flag = false; break;
//                     }
//                 if( x > 0 )
//                 {
//                     x = cur.word.length() - 1;
//                     while( y <= x )
//                         if( cur.word.charAt( x-- ) != cur.word.charAt( y++ ) )
//                         {
//                             flag = false; break;
//                         }
//                 }
//                 if( y < cur.word.length() )
//                 {
//                     y = 0;
//                     while( y <= x )
//                         if( w.charAt( x-- ) != w.charAt( y++ ) )
//                         {
//                             flag = false; break;
//                         }
//                 }
//                 // append the answer
//                 if( flag ) ans.add( Arrays.asList( i, cur.index ) );
//             }
//         }
//         return ans;
//     }
    
//     private class TrieNode
//     {
//         TrieNode[] child;
//         boolean isEnd;
//         String word;
//         int index;
//         public TrieNode()
//         {
//             this.child = new TrieNode[ 26 ];
//             this.isEnd = false;
//             this.word = "";
//             this.index = -1;
//         }
//     }
// }