// ref. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75931/Easiest-JAVA-solution-with-explanations
// ref. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75927/Share-my-thinking-process

package app;

class Q309_best_time_to_buy_and_sell_stock_with_cooldown
{
    public int maxProfit(int[] prices)
    {
        if( prices == null )     return 0;
        if( prices.length <= 1 ) return 0;
        
        /* transition function:
         * buy[ i ]  = Math.max(  buy[ i-1 ], sell[ i-2 ] - prices[ i ] ); // sell 2 days ago and buy today
         * sell[ i ] = Math.max( sell[ i-1 ],  buy[ i-1 ] + prices[ i ] ); // buy yesterday and sell today
         */
        
        // init
        int b0 = -prices[ 0 ]; // if we buy on the first day, the profit will be -price[ 0 ]
        int b1 = b0;
        int s0 = 0;          // we could not sell before we buy
        int s1 = 0, s2 = 0;
        
        for( int i = 1; i < prices.length; i++ )
        {
            // max profit to buy on i is max( rest, sell on i - 1 then buy on i )
            b0  = Math.max( b1, s2 - prices[ i ] );
            // max profit to sell on i is max( rest, buy on i - 1 then sell on i )
            s0 = Math.max( s1, b1 + prices[ i ] );

            b1 = b0; s2 = s1; s1 = s0;
        }
        // the last day could only be rest or sell
        return s0;
    }
}