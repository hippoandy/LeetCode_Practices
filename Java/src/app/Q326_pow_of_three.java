package app;

class Q326_pow_of_three
{
    public boolean isPowerOfThree(int n)
    {
        // In Java, we check if a number is an integer by taking the decimal part (using % 1) and checking if it is 0.
        return (Math.log10( n ) / Math.log10( 3 ) % 1 == 0);
    }
}