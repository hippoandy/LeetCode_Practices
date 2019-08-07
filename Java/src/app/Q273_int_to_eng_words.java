package app;

class Q273_int_to_eng_words
{
    private final String[] LESS_THAN_20 = {
        "", // first "" for a dummy entry to let the index match the num
        "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private final String[] TENS = {
        "", // first "" for a dummy entry to let the index match the num
        "Ten", "Twenty", "Thirty", "Forty", "Fifty",
        "Sixty", "Seventy", "Eighty", "Ninety"
    };
    private final String[] THOUSANDS = {
        "", // first "" for a dummy entry to let the index match the num
        "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num)
    {
        // corner case
        if( num < 0 ) throw null;
        if( num == 0 ) return "Zero";
        
        String ans = "";
        int i = 0;
        while( num > 0 )
        {
            // larger than thousand
            if( num % 1000 != 0 )
                ans = helper( num % 1000 ) + THOUSANDS[ i ] + " " + ans;
            num /= 1000;
            i++;
        }
        // use "trim()" to get rid of the tailing spaces
        return ans.trim();
    }
    
    private String helper( int num )
    {
        // "/" to get the higher digit, "%" to get the one digit
        if( num == 0 ) return "";
        if( num < 20 ) return LESS_THAN_20[ num ] + " ";
        if( num < 100 ) return TENS[ num / 10 ] + " " + helper( num % 10 );
        return LESS_THAN_20[ num / 100 ] + " Hundred " + helper( num % 100 );
    }
}