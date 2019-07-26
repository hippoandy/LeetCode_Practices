// ref. https://leetcode.com/problems/gas-station/discuss/42568/Share-some-of-my-ideas.

package app;

class Q134_gas_station
{
    // idea: If car starts at A and can not reach B. Any station between A and B can not reach B. (B is the first station that A can not reach.)
    public int canCompleteCircuit(int[] gas, int[] cost)
    {
        int sumGas = 0;
        int sumCost = 0;
        int start = 0;
        int tank = 0;
        for( int i = 0; i < gas.length; i++ )
        {
            sumGas  += gas[ i ];
            sumCost += cost[ i ];
            tank += gas[ i ] - cost[ i ];
            if( tank < 0 ) // not able to reach next station
            {
                start = i + 1;
                tank = 0;
            }
        }
        if( sumGas < sumCost )
            return -1;
        else
            return start;
    }
}