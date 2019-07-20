package app;

class Q520_detect_capital
{
    public boolean detectCapitalUse(String word)
    {
        boolean firstIsCap = false, secondIsLow = false;
        for( int i = 0; i < word.length(); i++ )
        {
            char c = word.charAt( i );
            if( i == 0 && isCapital( c ) ) firstIsCap = true;
            if( i == 1 && !isCapital( c ) ) secondIsLow = true;

            if( firstIsCap && i > 1 && secondIsLow && isCapital( c ) ) return false;
            if( firstIsCap && i > 1 && !secondIsLow && !isCapital( c ) ) return false;
            if( !firstIsCap && isCapital( c ) ) return false;
        }
        return true;
    }
    
    private boolean isCapital( char c )
    {
        if( c - 'A' < 0 || c - 'A' > 26 ) return false;
        return true;
    }
}