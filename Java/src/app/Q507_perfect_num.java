package app;

class Q507_perfect_num
{
    public boolean checkPerfectNumber(int num)
    {
        if( num <= 0 ) return false;
        
        int sum = 0;
        // consider until sqrt( num )
        for( int i = 1; i * i < num; i++ )
            // a factor of num
            if( num % i == 0 )
            {
                sum += i;
                // consider a pair, for example (4, 7)
                // if i * i == num, only consider once
                if( i * i != num ) sum += num / i;
            }
        // since we consider 1 as a factor, num itself will also be a factor (at the inner if loop)
        return (sum - num) == num;
    }
}