public class RangeSumQuery
{
  private int[] data;

  public RangeSumQuery(int[] nums)
  {
    data = nums;
  }

  public int sumRange(int i, int j)
  {
    int sum = 0;
    for(int k = i; k <=j; k++)
    {
      sum = sum+data[k];
    }
    return sum;
  }
  public static void main(String[] args)
  {
    int[] nums = {-2, 0, 3, -5, 2, -1};
    RangeSumQuery sumQuery = new RangeSumQuery(nums);
    System.out.println("sumRange(0,2)"+sumQuery.sumRange(0,2));
    System.out.println("sumRange(2,5)"+sumQuery.sumRange(2,5));
    System.out.println("sumRange(0,5)"+sumQuery.sumRange(0,5));
  }
}
