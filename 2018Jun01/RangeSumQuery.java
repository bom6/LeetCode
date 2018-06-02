public class RangeSumQuery
{
  private int[] data;
  private int[] sum;
  public RangeSumQuery(int[] nums)
  {
    sum = new int[nums.length+1];
    for(int i = 0; i < nums.length; i++)
    {
      sum[i+1] = sum[i]+nums[i];
    }
  }

  //Solution 1: Brute force Time complexity is O(n) //space complexity is O(1)
  // public int sumRange(int i, int j)
  // {
  //   int sum = 0;
  //   for(int k = i; k <=j; k++)
  //   {
  //     sum = sum+data[k];
  //   }
  //   return sum;
  // }

  //Solution 2: Caching
  // Time complexity is O(1) time per query
  //Pre compution time complexity is O(n)
  //space complexity is O(n)
  public int sumRange2(int i, int j)
  {
    return sum[j+1] - sum[i];
  }

  public static void main(String[] args)
  {
    int[] nums = {-2, 0, 3, -5, 2, -1};
    RangeSumQuery sumQuery = new RangeSumQuery(nums);
    System.out.println("sumRange(0,2)"+sumQuery.sumRange2(0,2));
    System.out.println("sumRange(2,5)"+sumQuery.sumRange2(2,5));
    System.out.println("sumRange(0,5)"+sumQuery.sumRange2(0,5));
  }
}
