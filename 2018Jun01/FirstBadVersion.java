public class Solution extends VersionControl
{
    public int firstBadVersion(int n)
    {
        //Binary search
        // Time complexity is O(logn)
        int left = 0;
        int right = n;
        while(left < right)
        {
            int mid = left +(right-left)/2; //Avoid overflow of left+right sum
            if(isBadVersion(mid) )
            {
                right = mid;
            }
            else
            {
                left = mid+1;
            }
        }
        return left; //either right or left, Prove by taking 2 numbers
    }
}
