import java.util.*;
class TwoSum1{
	public static void main(String args[]){
		int nums[] = {2,7,11,15};
		int target = 9;
		int[] result = twoSum(nums, target);
		System.out.print(result[0]+",");
		System.out.println(result[1]);
	}
	private static int[] twoSum(int[] nums, int target){
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i =0; i < nums.length; i++){
			if(map.containsKey(target-nums[i])){
				return new int[] { map.get(target-nums[i]), i+1};
			}
			map.put(nums[i], i+1);
		}
		return new int[2];
	}
}