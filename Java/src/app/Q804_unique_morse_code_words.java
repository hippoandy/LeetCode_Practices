package app;

import java.util.*;

class Q804_unique_morse_code_words
{
    // hashmap
    // Runtime: 3 ms, faster than 20.86% of Java online submissions for Unique Morse Code Words.
    // public int uniqueMorseRepresentations(String[] words)
    // {
    //     if( words == null ) return 0;
    //     Map<String, Integer> map = new HashMap<String, Integer>();

    //     String[] morse = { ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.." };
        
    //     for( String w: words )
    //     {
    //         String code = "";
    //         for( char c: w.toCharArray() )
    //             code += morse[ c - 'a' ];
    //         map.put( code, map.getOrDefault( code, 0 ) + 1 );
    //     }
        
    //     int sol = 0;
    //     for( int i: map.values() ) sol += 1;
    //     return sol;
    // }

    // change to hashset
    // Runtime: 2 ms, faster than 74.78% of Java online submissions for Unique Morse Code Words.
    public int uniqueMorseRepresentations(String[] words)
    {
        if( words == null ) return 0;
        Set<String> set = new HashSet<String>();

        String[] morse = { ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.." };
        
        for( String w: words )
        {
            String code = "";
            for( char c: w.toCharArray() )
                code += morse[ c - 'a' ];
            set.add( code );
        }
        return set.size();
    }
}