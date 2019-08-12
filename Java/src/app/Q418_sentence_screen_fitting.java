// ref. https://leetcode.com/problems/sentence-screen-fitting/discuss/90874/12ms-Java-solution-using-DP

package app;

class Q418_sentence_screen_fitting
{
    public int wordsTyping(String[] sentence, int rows, int cols)
    {
        int n = sentence.length;
        // stores num of words could be placed in a row if starting at i-th word
        int[] dp = new int[ n ];
        
        for( int i = 0; i < n; i++ )
        {
            int idx = i, numOfWs = 0, len = 0;
            while( len + sentence[ idx % n ].length() <= cols )
            {
                // keep adding words
                len += sentence[ idx % n ].length();
                // use a space to seperate the words
                len += 1;

                idx++;
                numOfWs++;
            }
            // store the result in the dp array
            // stores num of words could be placed in a row if starting at i-th word
            dp[ i ] = numOfWs;
        }

        int idx = 0, words = 0;
        for( int i = 0; i < rows; i++ )
        {
            // how many words could be placed in current words
            words += dp[ idx ];
            // the index of words the next row should start at
            idx = (dp[ idx ] + idx) % n;
        }
        return words/n;
    }
}