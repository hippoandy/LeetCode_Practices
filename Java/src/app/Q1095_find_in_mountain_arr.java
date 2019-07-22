// ref. https://leetcode.com/problems/find-in-mountain-array/discuss/317607/JavaC%2B%2BPython-Triple-Binary-Search

package app;

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Q1095_find_in_mountain_arr
{
    // Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
    
    // brute-force: wrong answer
    // public int findInMountainArray(int target, MountainArray mountainArr)
    // {
    //     for( int i = 0; i < mountainArr.length(); i++ )
    //         if( mountainArr.get( i ) == target ) return i;
    //     return -1;
    // }

    public int findInMountainArray(int target, MountainArray mountainArr)
    {
        int low = 0, high = mountainArr.length() - 1, peak = 0;
        // find the peak
        while( low < high )
        {
            int mid = (high + low) / 2;
            if( mountainArr.get( mid ) < mountainArr.get( mid + 1 ) )
                low = peak = mid + 1;
            else
                high = mid;
        }
        // find the target in the increasing array
        low = 0; high = peak;
        while( low <= high )
        {
            int mid = (high + low) / 2;
            if( mountainArr.get( mid ) < target )
                low = mid + 1;
            else if( mountainArr.get( mid ) > target )
                high = mid - 1;
            else
                return mid;
        }
        // find the target in the decreasing array
        low = peak; high = mountainArr.length() - 1;
        while( low <= high )
        {
            int mid = (high + low) / 2;
            // the logic here is different than the above one!!!
            if( mountainArr.get( mid ) < target )
                high = mid - 1;
            else if( mountainArr.get( mid ) > target )
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}